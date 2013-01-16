package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.HasValue;
import com.dtornkaew.gwt.validation.client.ValidationError;
import com.dtornkaew.gwt.validation.client.ValidationResult;
import com.dtornkaew.gwt.validation.client.Validator;

public class HasTrueValidator
    extends Validator<Boolean>
{
	private final HasValue<Boolean>[] targets;

    public HasTrueValidator( HasValue<Boolean>... targets )
    {
        this( "HasTrueValidator", targets );
    }

    public HasTrueValidator( String key, HasValue<Boolean>... targets )
    {
        super( key );
		assert targets.length > 0;
		this.targets = targets;
    }

	@Override
	public ValidationResult validate() {
		ValidationResult result = new ValidationResult();
		if (!isEnabled()) return result;

		for (HasValue<Boolean> target : targets) {
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
