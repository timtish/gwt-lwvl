package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.*;

/**
 * Abstract validator.
 *
 * @param <T> target element class
 */
public abstract class AsyncValidator<T> implements com.dtornkaew.gwt.validation.client.Validator<T>
{
	private boolean enabled;

	private final String key;

	public AsyncValidator( String key )
	{
		this.enabled = true;
		this.key = key;
	}

	public String getKey()
	{
		return key;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public AsyncValidator<T> setEnabled( boolean value )
	{
		enabled = value;
		return this;
	}

	public abstract void validate(ValidationHandler callback);

}
