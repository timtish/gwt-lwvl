package com.dtornkaew.gwt.validation.client;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Abstract validator.
 *
 * @param <T> target element class
 */
public abstract class Validator<T>
{
    private List<ValidationAction> actions = new LinkedList<ValidationAction>();

    private final HasValue<T> target;

    private boolean enabled;
    
    private final String key;
    
    public Validator( String key, HasValue<T> target )
    {
        this.target = target;
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

    public Validator<T> addAction( ValidationAction action )
    {
        actions.add( action );
        return this;
    }

    public void performActions( ValidationResult result )
    {
        Iterator<ValidationAction> i = actions.iterator();
        while ( i.hasNext() )
            i.next().invoke( result );
    }

    public void resetActions()
    {
        Iterator<ValidationAction> i = actions.iterator();
        while ( i.hasNext() )
            i.next().reset();
    }

	protected T getValue()
	{
		return target.getValue();
	}

	public HasValue<T> getTarget() {
		return target;
	}
}
