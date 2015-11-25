package com.api.xyinc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.xyinc.domain.Address;
import com.api.xyinc.service.FindAddressService;
import com.api.xyinc.util.Validator;


@Controller
@RequestMapping("/searchAddress")
public class AddressController {

    private FindAddressService findAddressService;

    @Autowired
    public AddressController(FindAddressService findAddressService) {
        super();
        this.findAddressService = findAddressService;
    }

    @RequestMapping(method=RequestMethod.GET, value="/addressByDescription")
    public @ResponseBody List<Address> getAddressByDescription(String name) {
        Validator.validateParameter(name);
        List<Address> addressList = findAddressService.findByAddress(name);
        return addressList;
    }

    @RequestMapping(method=RequestMethod.GET, value="/addressByZipCode")
    public @ResponseBody List<Address> getAddressByZipCode(String zipCode) {
        Validator.validateParameter(zipCode);
        List<Address> addressList = findAddressService.findByZipCode(zipCode);
        return addressList;
    }

}
