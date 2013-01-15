package com.dtornkaew.gwt.validation.client;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * List of validation errors.
 */
public class ValidationResult implements Iterable<ValidationError<?>>
{
	private final List<ValidationError<?>> errors;

    public ValidationResult()
    {
        this.errors = new LinkedList<ValidationError<?>>();
    }
    
    public void addError( ValidationError<?> error )
    {
        this.errors.add( error );
    }

    public void addErrors( Collection<ValidationError<?>> error )
    {
        this.errors.addAll(error);
    }

    public List<ValidationError<?>> getErrors()
    {
        return errors;
    }

	public void clearErrors() {
		errors.clear();
	}

	public boolean isValid() {
		return errors.isEmpty();
	}

	@Override
	public Iterator<ValidationError<?>> iterator() {
		return errors.iterator();
	}
}
