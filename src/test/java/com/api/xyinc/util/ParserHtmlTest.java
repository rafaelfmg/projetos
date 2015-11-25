package com.api.xyinc.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class ParserHtmlTest {

    @InjectMocks
    private ParserHtml parserHtml;
    private String urlZipCode;
    private String urlAddress;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        urlFactory();
    }

    private void urlFactory() {
        urlZipCode = Constants.URL_CORREIOS + Constants.ACTION_CORREIOS +"?Metodo=listaLogradouro&CEP=38408400&TipoConsulta=cep";
        urlAddress = Constants.URL_CORREIOS + Constants.ACTION_CORREIOS + "?relaxation=Rondon Pacheco&TipoCep=ALL&semelhante=S&cfm=1&Metodo=listaLogradouro&TipoConsulta=relaxation";
    }

    @Test
    public void testFindHtmlUrlZipCode() {

        Assert.assertNotNull(parserHtml.findHtml(urlZipCode));
    }

    @Test
    public void testFindHtmlUrlAddress() {

        Assert.assertNotNull(parserHtml.findHtml(urlAddress));
    }

    @Test
    public void testFindHtmlUrlAddressNull() {
        String url = Constants.URL_CORREIOS + Constants.ACTION_CORREIOS + "?relaxation=Rondon&TipoCep=ALL&semelhante=S&cfm=1&Metodo=listaLogradouro&TipoConsulta=relaxation";
        Assert.assertTrue(parserHtml.findHtml(url).isEmpty());
    }

    @Test
    public void testFindHtmlUrlZipCodeNull() {
        String url = Constants.URL_CORREIOS + Constants.ACTION_CORREIOS +"?Metodo=listaLogradouro&CEP=10&TipoConsulta=cep";
        Assert.assertTrue(parserHtml.findHtml(url).isEmpty());
    }


}
