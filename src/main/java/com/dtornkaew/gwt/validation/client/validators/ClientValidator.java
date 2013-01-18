package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.ValidationResult;

/**
 * Abstract validator.
 *
 * @param <T> target element class
 */
public abstract class ClientValidator<T> implements com.dtornkaew.gwt.validation.client.Validator<T> {
    private boolean enabled;
    
    private final String key;
    
    public ClientValidator(String key)
    {
        this.enabled = true;
        this.key = key;
    }
    
    @Override
	public String getKey()
    {
        return key;
    }
    
    @Override
	public boolean isEnabled()
    {
        return enabled;
    }
    
    @Override
	public ClientValidator<T> setEnabled(boolean value)
    {
        enabled = value;
        return this;
    }

    public abstract ValidationResult validate();

}
