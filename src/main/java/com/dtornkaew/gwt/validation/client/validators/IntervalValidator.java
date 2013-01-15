package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.HasValue;
import com.dtornkaew.gwt.validation.client.ValidationError;
import com.dtornkaew.gwt.validation.client.ValidationResult;

/**
 * Validator, requires specified integer(or float) interval
 *
 * @param <N>
 */
public class IntervalValidator<N extends Comparable<N>>
    extends RequiredValidator<N>
{    
    N minValue;
    
    N maxValue;
    
    public IntervalValidator(HasValue<N> target)
    {
        this( "IntervalValidator", target );
    }

    public IntervalValidator(String key, HasValue<N> target)
    {
        super(key, target);
    }

    public IntervalValidator(String key, HasValue<N> target, N minValue, N maxValue)
    {
        super( key, target );
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
        final ValidationResult result = super.validate();
		if( !result.isValid() ) return result;
		if( !isEnabled()) return result;

		N v = getValue();

		if( minValue != null && minValue.compareTo(v) > 0 )
			result.addError( new ValidationError<ErrorCodes>(this, ErrorCodes.LOWER_THAN_MIN ) );
		else if( maxValue != null && maxValue.compareTo(v) < 0 )
			result.addError( new ValidationError<ErrorCodes>(this, ErrorCodes.EXCEEDS_MAX ) );

        return result;
    }

    public static enum ErrorCodes
    {
        LOWER_THAN_MIN,
        EXCEEDS_MAX,
        NEGATIVE
    }
}