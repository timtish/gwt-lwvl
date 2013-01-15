package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.HasValue;
import com.dtornkaew.gwt.validation.client.Validator;
import com.dtornkaew.gwt.validation.client.ValidationResult;
import com.dtornkaew.gwt.validation.client.ValidationError;

/**
 * Validator, requires not null and not empty value (as string).
 *
 * @param <T>
 */
public class RequiredValidator<T>
    extends Validator<T>
{
    public RequiredValidator(HasValue<T> target)
    {
        this("RequiredValidator", target);
    }

	public RequiredValidator(HasValue<T>... targets)
	{
		super("RequiredValidator", new ValuesGroup<T>(targets));
	}

    public RequiredValidator(String key, HasValue<T> target)
    {
        super(key, target);
    }

    public RequiredValidator(String key, HasValue<T>... targets)
    {
        super(key, new ValuesGroup<T>(targets));
    }

    @Override
    public ValidationResult validate()
    {
        final ValidationResult result = new ValidationResult();
		if (!isEnabled()) return result;

        if (isEmpty(getValue()))
            result.addError(new ValidationError<ErrorCodes>(this, ErrorCodes.REQUIRED));

        return result;
    }

	private static boolean isEmpty(Object o) {
		return o == null || o.toString().length() == 0;
	}

	public static enum ErrorCodes
    {
        REQUIRED
    }

	private static class ValuesGroup<T> implements HasValue<T> {
		private HasValue<T>[] targets;

		private ValuesGroup(HasValue<T>... targets) {
			this.targets = targets;
		}

		@Override
		public T getValue() {
			for (HasValue<T> target : targets) {
				T o = target.getValue();
				if (!isEmpty(o)) return o;
			}
			return null;
		}
	}
}
