package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.ValidationError;
import com.dtornkaew.gwt.validation.client.ValidationResult;
import com.google.gwt.user.client.TakesValue;

public class HasTrueValidator
    extends ClientValidator<Boolean>
{
	private final TakesValue<Boolean>[] targets;

    public HasTrueValidator( TakesValue<Boolean>... targets )
    {
        this( "HasTrueValidator", targets );
    }

    public HasTrueValidator( String key, TakesValue<Boolean>... targets )
    {
        super( key );
		assert targets.length > 0;
		this.targets = targets;
    }

	@Override
	public ValidationResult validate() {
		ValidationResult result = new ValidationResult();
		if (!isEnabled()) return result;

		for (TakesValue<Boolean> target : targets) {
			if (Boolean.TRUE.equals(target.getValue())) return result;
		}
		result.addError(new ValidationError<Object>(this, ErrorCodes.NEED_TRUE, targets[0]));

		return result;
	}

	public static enum ErrorCodes
	{
		NEED_TRUE
	}

}
