package com.dtornkaew.gwt.validation.client;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

/**
 * Abstract validator.
 *
 * @param <T> target element class
 */
public abstract class Validator<T> implements
		/*gwt logical events*/ ValueChangeHandler, ChangeHandler, CloseHandler, BlurHandler,
		/*keyboard events*/ KeyPressHandler, KeyUpHandler,
		/*mouse events*/ ClickHandler, MouseUpHandler, MouseMoveHandler, MouseWheelHandler, MouseOutHandler,
		/*touch events*/ TouchEndHandler, TouchMoveHandler, TouchCancelHandler
{
    private List<ValidationAction> actions = new LinkedList<ValidationAction>();

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

	/* Validator activation events */

	@Override
	public void onBlur(BlurEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onChange(ChangeEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onClick(ClickEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onClose(CloseEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onKeyPress(KeyPressEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onKeyUp(KeyUpEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onMouseMove(MouseMoveEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onMouseUp(MouseUpEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onMouseWheel(MouseWheelEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onValueChange(ValueChangeEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onMouseOut(MouseOutEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onTouchCancel(TouchCancelEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onTouchEnd(TouchEndEvent event) {
		if (enabled) validate();
	}

	@Override
	public void onTouchMove(TouchMoveEvent event) {
		if (enabled) validate();
	}
}
