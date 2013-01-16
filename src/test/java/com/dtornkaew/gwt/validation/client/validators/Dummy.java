package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.HasValue;

/**
* Simple HasValue target.
*/
public class Dummy<T>
	implements HasValue<T>
{
	private T value;

	public Dummy()
	{

	}

	public Dummy(T value)
	{
		this.value = value;
	}

	@Override
	public T getValue()
	{
		return value;
	}

}
