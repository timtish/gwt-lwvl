package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.ValidationResult;
import junit.framework.Assert;
import org.junit.Test;

public class SequenceValidatorTest
{

    @Test
    public void testCanNotEquals()
    {
        Dummy<Double> d1 = new Dummy<Double>( 5d );
        Dummy<Double> d2 = new Dummy<Double>( 5d );

		SequenceValidator<Double> v = new SequenceValidator<Double>( false, d1, d2 );

        ValidationResult r = v.validate();

        Assert.assertNotNull( r );

        Assert.assertEquals( 1, r.getErrors().size() );
    }

    @Test
    public void testCanEquals()
    {
        Dummy<Double> d1 = new Dummy<Double>( 5d );
        Dummy<Double> d2 = new Dummy<Double>( 5d );

		SequenceValidator<Double> v = new SequenceValidator<Double>( true, d1, d2 );

        ValidationResult r = v.validate();

        Assert.assertNotNull( r );

        Assert.assertEquals( 0, r.getErrors().size() );
    }

    @Test
    public void testWrongSequence()
    {
        Dummy<Double> d1 = new Dummy<Double>( 5d );
        Dummy<Double> d2 = new Dummy<Double>( 4d );
        Dummy<Double> d3 = new Dummy<Double>( 6d );
        Dummy<Double> d4 = new Dummy<Double>( 8d );

		SequenceValidator<Double> v = new SequenceValidator<Double>( "myKey", true, d1, d2, d3 ,d4 );

        ValidationResult r = v.validate();

        Assert.assertNotNull( r );

        Assert.assertEquals( 1, r.getErrors().size() );
    }
    @Test
    public void testIncreaseSequence()
    {
        Dummy<Integer> d1 = new Dummy<Integer>( -234 );
        Dummy<Integer> d2 = new Dummy<Integer>( -29 );
        Dummy<Integer> d3 = new Dummy<Integer>( 0 );
        Dummy<Integer> d4 = new Dummy<Integer>( 3523 );

		SequenceValidator<Integer> v = new SequenceValidator<Integer>( true, d1, d2, d3, d4 );

        ValidationResult r = v.validate();

        Assert.assertNotNull( r );

        Assert.assertTrue( r.isValid() );
    }

}
