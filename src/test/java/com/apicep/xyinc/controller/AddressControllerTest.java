package com.apicep.xyinc.controller;

import javax.validation.ValidationException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.apicep.xyinc.ws.service.FindAddressService;

public class AddressControllerTest {

	
	@Mock
	private FindAddressService service;
	@InjectMocks
	private AddressController controller;

	private String name;
	private int x;
	private int y;
	private int distanceMax;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		addressFactory();
	}

	private void addressFactory() {
		name = RandomStringUtils.randomAlphabetic(10);
		x = RandomUtils.nextInt(0, 100);
		y = RandomUtils.nextInt(0, 100);
	}


	@Test(expected = ValidationException.class)
	public void testSaveWithError() {
		controller.save(x, y, StringUtils.EMPTY);
	}

	@Test(expected = ValidationException.class)
	public void testSaveWithError2() {
		controller.save(x, null, name);
	}

	@Test(expected = ValidationException.class)
	public void testSaveWithError3() {
		controller.save(null, y, name);
	}

	@Test(expected = ValidationException.class)
	public void testSaveWithError4() {
		controller.save(null, null, null);
	}

	@Test
	public void testFindNearest() {
		controller.findNearest(x, y, distanceMax);
		Mockito.verify(service).findNearest(x, y, distanceMax);
	}

	@Test(expected = ValidationException.class)
	public void testFindNearestWithError() {
		controller.findNearest(x, y, null);
	}

	@Test(expected = ValidationException.class)
	public void testFindNearestWithError2() {
		controller.findNearest(x, null, distanceMax);
	}

	@Test(expected = ValidationException.class)
	public void testFindNearestWithError3() {
		controller.findNearest(null, y, distanceMax);
	}

	@Test(expected = ValidationException.class)
	public void testFindNearestWithError4() {
		controller.findNearest(null, null, null);
	}

	@Test
	public void testDeleteAll() {
		controller.deleteAll();
		Mockito.verify(service).deleteAll();
	}

	@Test
	public void testCreateDefaultDocuments() {
		controller.createDefaultDocuments();
		Mockito.verify(service).createDefaultDocuments();
	}

	@Test
	public void deleteAll() {
		controller.deleteAll();
		Mockito.verify(service).deleteAll();
	}
	
}
