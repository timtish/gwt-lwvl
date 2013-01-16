package com.dtornkaew.gwt.validation.client;

/**
 * Abstract validator.
 *
 * @param <T> target element class
 */
public abstract class AsyncValidator<T> extends Validator<T>
{
	protected AsyncValidator(String key) {
		super(key);
	}

	@Override
	public ValidationResult validate() {
		throw new UnsupportedOperationException();
	}

	public abstract void validate(ValidationHandler callback);

}
