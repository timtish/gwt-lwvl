package com.dtornkaew.gwt.validation.client.validators;

import java.util.Arrays;
import java.util.List;

import com.dtornkaew.gwt.validation.client.ValidationResult;
import com.dtornkaew.gwt.validation.client.Validator;

public class ValidatorsGroup extends Validator
{
	// last validation result cache
	private ValidationResult validationResult = new ValidationResult();

    private final List<Validator<?>> validators;

	public ValidatorsGroup(Validator<?>... validators) {
		this("ValidatorsGroup", validators);
	}

	public ValidatorsGroup(String key, Validator<?>... validators) {
		super(key);
		this.validators = Arrays.asList(validators);
	}

    public ValidationResult validate()
    {
		validationResult.clearErrors();
		if (!isEnabled()) return validationResult;

		for( Validator<?> v : validators )
		{
			ValidationResult r = v.validate();
			if( r.getErrors().size() > 0 )
			{
				validationResult.addErrors(r.getErrors());
				v.performActions( r );
			}
		}

		performActions(validationResult);

		return validationResult;
    }

	@Override
	public void resetActions() {
		validationResult.clearErrors();

		for( Validator<?> v : validators )
		{
			v.resetActions();
		}

		super.resetActions();
	}

	public ValidationResult getValidationResult() {
		return validationResult;
	}
}
