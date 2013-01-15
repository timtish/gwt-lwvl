package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.HasValue;
import com.dtornkaew.gwt.validation.client.ValidationError;
import com.dtornkaew.gwt.validation.client.ValidationResult;

public class HasTrueValidator
    extends RequiredValidator<Boolean>
{
	public static final String NOT_TRUE = "NOT_TRUE";

    public HasTrueValidator( HasValue<Boolean> target)
    {
        super("HasTrueValidator", target);
    }

    public HasTrueValidator( HasValue<Boolean>... targets )
    {
        super( "HasTrueValidator", new ValuesGroup(targets) );
    }

    public HasTrueValidator( String key, HasValue<Boolean> target )
    {
        super( key, target );
    }

    public HasTrueValidator( String key, HasValue<Boolean>... targets )
    {
        super( key, new ValuesGroup(targets) );
    }

	@Override
	public ValidationResult validate() {
		ValidationResult result = super.validate();
		if (!result.isValid()) return result;
		if (!isEnabled()) return result;

		if (!Boolean.TRUE.equals(getValue()))
			result.addError(new ValidationError<Object>(this, NOT_TRUE));

		return result;
	}

	private static class ValuesGroup implements HasValue<Boolean> {
		private HasValue<Boolean>[] targets;

		private ValuesGroup(HasValue<Boolean>... targets) {
			this.targets = targets;
		}

		@Override
		public Boolean getValue() {
			for (HasValue<Boolean> target : targets) {
				Boolean o = target.getValue();
				if (Boolean.TRUE.equals(o)) return o;
			}
			return null;
		}
	}

}
