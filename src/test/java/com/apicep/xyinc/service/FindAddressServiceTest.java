package com.apicep.xyinc.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.api.xyinc.controller.AddressController;
import com.api.xyinc.service.impl.FindAddressServiceImpl;

public class FindAddressServiceTest {

	@Mock
	private FindAddressServiceImpl service;
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
	public void testFindByAddress() {
		Assert.assertNotNull(service.findByAddress(addressDescription));
	}

	@Test
	public void testFindByZipCode() {
		Assert.assertNotNull(service.findByZipCode(zipCode));
	}

}
