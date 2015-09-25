package com.apicep.xyinc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apicep.xyinc.domain.Address;
import com.apicep.xyinc.service.FindAddressService;


@Controller
@RequestMapping("/searchAddress")
public class AddressController {

    private FindAddressService findAddressService;

    @Autowired
    public AddressController(final FindAddressService findAddressService) {
        super();
        this.findAddressService = findAddressService;
    }

    @RequestMapping(method=RequestMethod.GET, value="/addressByDescription")
    public @ResponseBody List<Address> getAddressByDescription(final String name) {
        List<Address> addressList = findAddressService.findByAddress(name);

        return addressList;
    }


    @RequestMapping(method=RequestMethod.GET, value="/addressByZipCode")
    public @ResponseBody List<Address> getAddressByZipCode(final String zipCode) {
        List<Address> addressList = findAddressService.findByZipCode(zipCode);

        return addressList;
    }

}
