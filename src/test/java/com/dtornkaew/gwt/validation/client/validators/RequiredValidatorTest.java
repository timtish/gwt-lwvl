package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.ValidationResult;
import junit.framework.Assert;
import org.junit.Test;

public class RequiredValidatorTest
{
    @Test
    public void testIntegerRequired()
    {
        Dummy<Integer> d = new Dummy<Integer>();

		RequiredValidator<Integer> v = new RequiredValidator<Integer>( d );

        ValidationResult r = v.validate();

        Assert.assertNotNull( r );

        Assert.assertEquals( 1, r.getErrors().size() );
    }

    @Test
    public void testStringRequired()
    {
        Dummy<String> d = new Dummy<String>("");

		RequiredValidator<String> v = new RequiredValidator<String>( d );

        ValidationResult r = v.validate();

        Assert.assertNotNull( r );

        Assert.assertEquals( 1, r.getErrors().size() );
    }

    @Test
    public void testObjectRequired()
    {
        Dummy<Integer> d = new Dummy<Integer>( 2 );

		RequiredValidator<Integer> v = new RequiredValidator<Integer>( d );

        ValidationResult r = v.validate();

        Assert.assertNotNull(r);

        Assert.assertTrue(r.isValid());
    }

}
