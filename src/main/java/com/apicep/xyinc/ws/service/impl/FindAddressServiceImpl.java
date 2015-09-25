package com.apicep.xyinc.ws.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apicep.xyinc.domain.Address;
import com.apicep.xyinc.util.ParserHtml;
import com.apicep.xyinc.ws.service.FindAddressService;

@Service
public class FindAddressServiceImpl implements FindAddressService {

    public List<Address> findByZipCode(final String zipCode) {
        String urlName = "http://www.buscacep.correios.com.br/servicos/dnec/consultaLogradouroAction.do?Metodo=listaLogradouro&CEP=" + zipCode
            + "&TipoConsulta=cep";

        ParserHtml parserHtml = new ParserHtml();

        return parserHtml.findHtml(urlName);
    }

    public List<Address>  findByAddress(final String patio) {
        String urlName =
            /*"http://www.buscacep.correios.com.br/servicos/dnec/consultaLogradouroAction.do?Metodo=listaLogradouro&TipoConsulta=logradouro&Logradouro="
            + patio + "&UF=MG&Localidade=uberlandia";*/
        "http://www.buscacep.correios.com.br/servicos/dnec/consultaEnderecoAction.do?relaxation="+ patio +
            "&TipoCep=ALL&semelhante=S&cfm=1&Metodo=listaLogradouro&TipoConsulta=relaxation";

        ParserHtml parserHtml = new ParserHtml();

        return parserHtml.findHtml(urlName);
    }

}
