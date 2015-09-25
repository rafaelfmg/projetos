package com.apicep.xyinc.controller;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.api.xyinc.controller.AddressController;
import com.api.xyinc.service.FindAddressService;

public class AddressControllerTest {


	@Mock
	private FindAddressService service;
	@InjectMocks
	private AddressController controller;

	private String addressDescription;
	private String zipCode;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		addressFactory();
	}

	private void addressFactory() {
		addressDescription = "Rondon Pacheco";
		zipCode = "38408447";
	}


	@Test
	public void testGetAddressByDescription() {
		controller.getAddressByDescription(addressDescription);
		Mockito.verify(service).findByAddress(addressDescription);
	}

	@Test(expected = Exception.class)
	public void testGetAddressByDescriptionWithError() {
		controller.getAddressByDescription(null);
	}

	@Test
	public void testGetAddressByZipCode() {
		controller.getAddressByZipCode(zipCode);
		Mockito.verify(service).findByZipCode(zipCode);
	}

	@Test(expected = IOException.class)
	public void testGetAddressByZipCodeWithError() {
		controller.getAddressByZipCode(null);
	}

}
