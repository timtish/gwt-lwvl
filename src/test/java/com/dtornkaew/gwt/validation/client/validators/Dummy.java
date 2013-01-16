package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.HasValue;
import com.google.gwt.user.client.TakesValue;

/**
* Simple HasValue target.
*/
public class Dummy<T>
	implements HasValue<T>, TakesValue<T>
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

	public void setValue(T value) {
		throw new UnsupportedOperationException();
	}
}
