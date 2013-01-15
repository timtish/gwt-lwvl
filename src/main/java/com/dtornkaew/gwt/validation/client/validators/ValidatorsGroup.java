package com.dtornkaew.gwt.validation.client.validators;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.dtornkaew.gwt.validation.client.Validator;
import com.dtornkaew.gwt.validation.client.ValidationResult;

public class ValidatorsGroup extends Validator
{
	// last validation result cache
	private ValidationResult validationResult = new ValidationResult();

    private final List<Validator<?>> validators = new LinkedList<Validator<?>>();

	public ValidatorsGroup(Validator<?>... validator) {
		super("ValidatorsGroup", null);
		validators.addAll(Arrays.asList(validator));
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
