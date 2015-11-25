package com.api.xyinc.util;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ValidationException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.api.xyinc.domain.Address;

public class ValidatorTest {


    @InjectMocks
    private Validator validator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = ValidationException.class)
    public void testValidateParameterException() {
        Validator.validateParameter(null);
    }

    @Test(expected = ValidationException.class)
    public void testValidateResultNull() {
        List<Address> adList = null;
        Validator.validateResult(adList);
    }

    @Test(expected = ValidationException.class)
    public void testValidateResultEmpty() {
        List<Address> adList = new ArrayList<Address>();
        Validator.validateResult(adList);

    }


}
