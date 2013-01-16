package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.HasValue;
import com.dtornkaew.gwt.validation.client.ValidationError;
import com.dtornkaew.gwt.validation.client.ValidationResult;
import com.dtornkaew.gwt.validation.client.Validator;

/**
 * Validator, requires increasing values.
 */
public class SequenceValidator<N extends Comparable<N>>
    extends Validator<N>
{
	private boolean canEquals;
	private HasValue<N>[] targets;
	
    public SequenceValidator(boolean canEquals, HasValue<N>... targets)
    {
        this("HasTrueValidator", canEquals, targets);
    }

    public SequenceValidator(String key, boolean canEquals, HasValue<N>... targets)
    {
        super( key );
		this.canEquals = canEquals;
		assert targets.length > 1;
		this.targets = targets;
    }

	@Override
	public ValidationResult validate() {
		ValidationResult result = new ValidationResult();
		if (!isEnabled()) return result;

		for (int i = 1; i < targets.length; i++) {
			N v1 = targets[i-1].getValue();
			N v2 = targets[i].getValue();
			if (v1 != null && v2 != null) {
				if (!isValid(v1, v2)){
					result.addError(new ValidationError<Object>(this, ErrorCodes.INCORRECT_SEQUENCE, v2));
					break;
				}
			}
		}

		return result;
	}

	private boolean isValid(N v1, N v2) {
		int c = v2.compareTo(v1);
		return c > 0 || (canEquals && c == 0);
	}

	public static enum ErrorCodes
	{
		INCORRECT_SEQUENCE
	}

}
