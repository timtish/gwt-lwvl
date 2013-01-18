package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.ValidationError;
import com.dtornkaew.gwt.validation.client.ValidationResult;
import com.google.gwt.user.client.TakesValue;

/**
 * Validator, requires not null and not empty value (as string) for at least one target.
 *
 * @param <T>
 */
public class RequiredValidator<T>
    extends ClientValidator<T>
{
	private final TakesValue<T>[] targets;

	public RequiredValidator(TakesValue<T>... targets)
	{
		this("RequiredValidator", targets);
	}

    public RequiredValidator(String key, TakesValue<T>... targets)
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

		for (TakesValue<T> target : targets) {
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
