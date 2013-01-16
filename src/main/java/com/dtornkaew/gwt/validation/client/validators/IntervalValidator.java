package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.HasValue;
import com.dtornkaew.gwt.validation.client.ValidationError;
import com.dtornkaew.gwt.validation.client.ValidationResult;
import com.dtornkaew.gwt.validation.client.Validator;

/**
 * Validator, requires specified integer(or float) interval.
 *
 * @param <N>
 */
public class IntervalValidator<N extends Comparable<N>>
    extends Validator<N>
{    
    private N minValue;
    
    private N maxValue;

	private final HasValue<N> target;
    
    public IntervalValidator(HasValue<N> target)
    {
        this( "IntervalValidator", target );
    }

    public IntervalValidator(String key, HasValue<N> target)
    {
        super( key );
		this.target = target;
    }

    public IntervalValidator(HasValue<N> target, N minValue, N maxValue)
    {
        this( "IntervalValidator", target, minValue, maxValue );
    }

    public IntervalValidator(String key, HasValue<N> target, N minValue, N maxValue)
    {
        super( key );
		this.target = target;
		this.minValue = minValue;
		this.maxValue = maxValue;
    }
    
    public IntervalValidator<N> setMinValue( N min )
    {
        minValue = min;
        return this;
    }

    public N getMinValue()
    {
        return minValue;
    }
    
    public IntervalValidator<N> setMaxValue( N max )
    {
        maxValue = max;
        return this;
    }
    public N getMaxValue()
    {
        return maxValue;
    }

    @Override
    public ValidationResult validate()
    {
        final ValidationResult result = new ValidationResult();
		N v = target.getValue();
		if( !isEnabled() || v == null) return result;


		if( minValue != null && minValue.compareTo(v) > 0 )
			result.addError(new ValidationError<ErrorCodes>(this, ErrorCodes.LOWER_THAN_MIN, v) );
		else if( maxValue != null && maxValue.compareTo(v) < 0 )
			result.addError(new ValidationError<ErrorCodes>(this, ErrorCodes.EXCEEDS_MAX, v) );

        return result;
    }

    public static enum ErrorCodes
    {
        LOWER_THAN_MIN,
        EXCEEDS_MAX
    }
}