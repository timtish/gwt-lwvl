package com.dtornkaew.gwt.validation.client.validators;

import com.dtornkaew.gwt.validation.client.ValidationResult;
import junit.framework.Assert;
import org.junit.Test;

public class HasTrueValidatorTest
{
    @Test
    public void testRequiredOk()
    {

        Dummy[] values = new Dummy[]{
            new Dummy<Boolean>( true ),
            new Dummy<Boolean>( false )
        };

        HasTrueValidator v = new HasTrueValidator( values );

        ValidationResult r = v.validate();
        
        Assert.assertEquals( 0, r.getErrors().size() );
    }
    
    @Test
    public void testRequiredFail()
    {
        Dummy[] values = new Dummy[]{
            new Dummy<Boolean>( false ),
            new Dummy<Boolean>( false )
        };
        
        HasTrueValidator v = new HasTrueValidator( values );
        
        ValidationResult r = v.validate();
        
        Assert.assertEquals( 1, r.getErrors().size() );
    }

}


