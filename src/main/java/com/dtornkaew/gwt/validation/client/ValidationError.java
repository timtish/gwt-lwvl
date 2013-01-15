package com.dtornkaew.gwt.validation.client;

public class ValidationError<C>
{
	private final Validator validator;
	private final C code;

	public ValidationError(Validator validator, C code)
	{
		this.validator = validator;
		this.code = code;
	}

	public C getCode()
	{
		return code;
	}

	public Validator getValidator() {
		return validator;
	}
}
