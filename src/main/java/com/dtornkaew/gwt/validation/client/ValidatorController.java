package com.dtornkaew.gwt.validation.client;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

public class ValidatorController implements
		/*logical events*/ ValueChangeHandler, ChangeHandler, CloseHandler, BlurHandler,
		/*keyboard events*/ KeyPressHandler, KeyUpHandler,
		/*mouse events*/ ClickHandler, MouseUpHandler, MouseMoveHandler, MouseWheelHandler, MouseOutHandler,
		/*touch events*/ TouchEndHandler, TouchMoveHandler, TouchCancelHandler
{
	private final List<Validator<?>> validators = new LinkedList<Validator<?>>();

	private List<ValidationHandler> actions = new LinkedList<ValidationHandler>();

	private AsyncValidator asyncValidator;

	private ValidationHandler asyncCallback;

	public ValidatorController() {
	}

	public ValidatorController(Validator<?>... validators) {
		addValidators(validators);
	}

	public ValidatorController(AsyncValidator asyncValidator, Validator<?>... validators) {
		setAsyncValidator(asyncValidator);
		addValidators(validators);
	}

	public ValidatorController addValidators(Validator<?>... validators) {
		this.validators.addAll(Arrays.asList(validators));
		return this;
	}

	public ValidatorController addValidationHandler(ValidationHandler action)
	{
		actions.add( action );
		return this;
	}

	public ValidatorController setAsyncValidator(AsyncValidator asyncValidator) {
		this.asyncValidator = asyncValidator;
		return this;
	}

	protected ValidationHandler getAsyncCallback() {
		if (asyncCallback == null) {
			asyncCallback = new ValidationHandler() {
				@Override
				public void invoke(ValidationResult result) {
					performActions(result);
				}

				@Override
				public void reset() {
					resetActions();
				}
			};
		}
		return asyncCallback;
	}

	protected void performActions( ValidationResult result )
	{
		Iterator<ValidationHandler> i = actions.iterator();
		while ( i.hasNext() )
			i.next().invoke( result );
	}

	protected void resetActions()
	{
		Iterator<ValidationHandler> i = actions.iterator();
		while ( i.hasNext() ) i.next().reset();
	}

    public void validate()
    {
		ValidationResult validationResult = new ValidationResult();
		for( Validator v : validators )
		{
			if (v.isEnabled()) {
				ValidationResult r = v.validate();
				validationResult.addErrors(r.getErrors());
			}
		}
		if (!validationResult.isValid() || asyncValidator == null) {
			performActions(validationResult);
		} else {
			asyncValidator.validate(getAsyncCallback());
		}
    }

	/* Validator activation events */

	@Override
	public void onBlur(BlurEvent event) {
		validate();
	}

	@Override
	public void onChange(ChangeEvent event) {
		validate();
	}

	@Override
	public void onClick(ClickEvent event) {
		validate();
	}

	@Override
	public void onClose(CloseEvent event) {
		validate();
	}

	@Override
	public void onKeyPress(KeyPressEvent event) {
		validate();
	}

	@Override
	public void onKeyUp(KeyUpEvent event) {
		validate();
	}

	@Override
	public void onMouseMove(MouseMoveEvent event) {
		validate();
	}

	@Override
	public void onMouseUp(MouseUpEvent event) {
		validate();
	}

	@Override
	public void onMouseWheel(MouseWheelEvent event) {
		validate();
	}

	@Override
	public void onValueChange(ValueChangeEvent event) {
		validate();
	}

	@Override
	public void onMouseOut(MouseOutEvent event) {
		validate();
	}

	@Override
	public void onTouchCancel(TouchCancelEvent event) {
		validate();
	}

	@Override
	public void onTouchEnd(TouchEndEvent event) {
		validate();
	}

	@Override
	public void onTouchMove(TouchMoveEvent event) {
		validate();
	}
}
