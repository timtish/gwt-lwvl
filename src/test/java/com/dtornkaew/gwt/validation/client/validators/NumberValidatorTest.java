package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.ValidationResult;
import junit.framework.Assert;
import org.junit.Test;

public class NumberValidatorTest
{

    @Test
    public void testValid()
    {
        Dummy<Double> d = new Dummy<Double>( 5d );

        IntervalValidator<Double> v = new IntervalValidator<Double>( d );
        v.setMinValue( 5d );
        v.setMaxValue( 10d );

        ValidationResult r = v.validate();

        Assert.assertNotNull( r );

        Assert.assertEquals( 0, r.getErrors().size() );
    }

    @Test
    public void testMin()
    {
        Dummy<Double> d = new Dummy<Double>( 5d );

        IntervalValidator<Double> v = new IntervalValidator<Double>( d );
        v.setMinValue( 6d );
        v.setMaxValue( 10d );

        ValidationResult r = v.validate();

        Assert.assertNotNull( r );

        Assert.assertEquals( 1, r.getErrors().size() );

        Assert.assertEquals( IntervalValidator.ErrorCodes.LOWER_THAN_MIN, r.getErrors().get( 0 ).getCode() );
    }

    @Test
    public void testMax()
    {
        Dummy<Long> d = new Dummy<Long>( 5l );

        IntervalValidator<Long> v = new IntervalValidator<Long>( d );
        v.setMinValue( 2l );
        v.setMaxValue( 4l );

        ValidationResult r = v.validate();

        Assert.assertNotNull( r );

        Assert.assertEquals( 1, r.getErrors().size() );

        Assert.assertEquals( IntervalValidator.ErrorCodes.EXCEEDS_MAX, r.getErrors().get( 0 ).getCode() );
    }

}
