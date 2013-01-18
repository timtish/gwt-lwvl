package com.dtornkaew.gwt.validation.client;

/**
 * @author Timofey Tishin (ttishin@luxoft.com)
 */
public interface Validator<T> {

	String getKey();

	boolean isEnabled();

	Validator<T> setEnabled(boolean value);

}
