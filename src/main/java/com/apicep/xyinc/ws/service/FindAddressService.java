package com.apicep.xyinc.ws.service;

import java.util.List;

import com.apicep.xyinc.domain.Address;

public interface FindAddressService {

    public List<Address> findByZipCode(final String zipCode);
    public List<Address> findByAddress(final String patio);
}
