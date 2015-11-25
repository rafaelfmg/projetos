package com.api.xyinc.service;

import java.util.List;
import com.api.xyinc.domain.Address;

public interface FindAddressService {

    public List<Address> findByZipCode(String zipCode);
    public List<Address> findByAddress(String addressDescription);
}
