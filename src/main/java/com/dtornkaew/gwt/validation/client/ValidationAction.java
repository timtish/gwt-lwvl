package com.dtornkaew.gwt.validation.client;


/**
 * Validation result collector.
 */
public interface ValidationAction
{    
    public void invoke(ValidationResult... results);
    
    public void reset();
}
