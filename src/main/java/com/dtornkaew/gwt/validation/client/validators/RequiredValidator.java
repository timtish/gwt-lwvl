package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.HasValue;
import com.dtornkaew.gwt.validation.client.Validator;
import com.dtornkaew.gwt.validation.client.ValidationResult;
import com.dtornkaew.gwt.validation.client.ValidationError;

/**
 * Validator, requires not null and not empty value (as string) for at least one target.
 *
 * @param <T>
 */
public class RequiredValidator<T>
    extends Validator<T>
{
	private final HasValue<T>[] targets;

	public RequiredValidator(HasValue<T>... targets)
	{
		this("RequiredValidator", targets);
	}

    public RequiredValidator(String key, HasValue<T>... targets)
    {
        super(key);
		assert targets.length > 0;
		this.targets = targets;
    }

    @Override
    public ValidationResult validate()
    {
        final ValidationResult result = new ValidationResult();
		if (!isEnabled()) return result;

		for (HasValue<T> target : targets) {
			T o = target.getValue();
			if (!isEmpty(o)) return result;
		}
        result.addError(new ValidationError<ErrorCodes>(this, ErrorCodes.REQUIRED, targets[0]));

        return result;
    }

	private static boolean isEmpty(Object o) {
		return o == null || o.toString().length() == 0;
	}

	public static enum ErrorCodes
    {
        REQUIRED
    }
}
