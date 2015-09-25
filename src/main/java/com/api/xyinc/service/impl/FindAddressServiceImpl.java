package com.api.xyinc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.xyinc.domain.Address;
import com.api.xyinc.service.FindAddressService;
import com.api.xyinc.util.Constants;
import com.api.xyinc.util.ParserHtml;

@Service
public class FindAddressServiceImpl implements FindAddressService {
    String urlName = Constants.URL_CORREIOS + Constants.ACTION_CORREIOS;

    public List<Address> findByZipCode(final String zipCode) {
        urlName = urlName + "?Metodo=listaLogradouro&CEP=" + zipCode + "&TipoConsulta=cep";

        ParserHtml parserHtml = new ParserHtml();

        return parserHtml.findHtml(urlName);
    }

    public List<Address> findByAddress(final String addressDescription) {
        urlName = urlName + "?relaxation=" + addressDescription +
            "&TipoCep=ALL&semelhante=S&cfm=1&Metodo=listaLogradouro&TipoConsulta=relaxation";

        ParserHtml parserHtml = new ParserHtml();

        return parserHtml.findHtml(urlName);
    }

}
