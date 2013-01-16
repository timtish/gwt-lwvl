package com.dtornkaew.gwt.validation.client;

/**
 * Validator target interface.
 *
 * @deprecated use {@link com.google.gwt.user.client.TakesValue} for support GWT components
 */
public interface HasValue<T>
{
	T getValue();
}
