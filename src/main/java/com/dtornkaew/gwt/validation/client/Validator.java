package com.dtornkaew.gwt.validation.client;

/**
 * Abstract validator.
 *
 * @param <T> target element class
 */
public abstract class Validator<T>
{
    private boolean enabled;
    
    private final String key;
    
    public Validator( String key )
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
    
    public Validator<T> setEnabled( boolean value )
    {
        enabled = value;
        return this;
    }

    public abstract ValidationResult validate();

}
