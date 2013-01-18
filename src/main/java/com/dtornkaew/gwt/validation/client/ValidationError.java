package com.dtornkaew.gwt.validation.client;

import java.util.Arrays;
import java.util.List;

public class ValidationError<C>
{
	private final Validator validator;
	private final String key;
	private final C code;
	private final List targets;
	
	public ValidationError(Validator validator, C code, Object... targets)
	{
		this.validator = validator;
		this.code = code;
		this.key = validator.getKey();
		this.targets = Arrays.asList(targets);
	}

	public ValidationError(String key, C code, Object... targets)
	{
		this.validator = null;
		this.code = code;
		this.key = key;
		this.targets = Arrays.asList(targets);
	}

	public C getCode()
	{
		return code;
	}

	public String getKey() {
		return key;
	}

	public Validator getValidator() {
		return validator;
	}

	public List getTargets() {
		return targets;
	}
}
