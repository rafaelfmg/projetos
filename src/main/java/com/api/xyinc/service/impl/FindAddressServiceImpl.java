package com.api.xyinc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.xyinc.domain.Address;
import com.api.xyinc.service.FindAddressService;
import com.api.xyinc.util.Constants;
import com.api.xyinc.util.ParserHtml;

@Service
public class FindAddressServiceImpl implements FindAddressService {

    @Override
    public List<Address> findByZipCode(String zipCode) {
        ParserHtml parserHtml = new ParserHtml();
        return parserHtml.findHtml(Constants.URL_CORREIOS, zipCode, Constants.ALL, Constants.NAO);
    }

    @Override
    public List<Address> findByAddress(String addressDescription) {
        ParserHtml parserHtml = new ParserHtml();
        return parserHtml.findHtml(Constants.URL_CORREIOS, addressDescription, Constants.ALL, Constants.NAO);
    }

}
