package com.dtornkaew.gwt.validation.client;

import java.util.Arrays;
import java.util.List;

public class ValidationError<C>
{
	private final Validator validator;
	private final C code;
	private final List targets;
	
	public ValidationError(Validator validator, C code, Object... targets)
	{
		this.validator = validator;
		this.code = code;
		this.targets = Arrays.asList(targets);
	}

	public C getCode()
	{
		return code;
	}

	public String getValidatorKey() {
		return validator.getKey();
	}

	public Validator getValidator() {
		return validator;
	}

	public List getTargets() {
		return targets;
	}
}
