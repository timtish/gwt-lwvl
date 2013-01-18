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
	private final List<ValidationError<?>> errors = new LinkedList<ValidationError<?>>();

    public ValidationResult()
    {
    }

    public ValidationResult(String code)
    {
		this("", code);
    }

    public ValidationResult(String key, String code)
    {
		addError(new ValidationError<Object>(key, code));
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
