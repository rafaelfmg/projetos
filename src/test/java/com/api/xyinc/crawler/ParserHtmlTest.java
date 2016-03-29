package com.api.xyinc.crawler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.api.xyinc.crawler.ParserHtml;
import com.api.xyinc.util.Constants;

public class ParserHtmlTest {

    @InjectMocks
    private ParserHtml parserHtml;
    private String url;
    private String zipCode;
    private String addressDescription;
    private String cepType;
    private String similar;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        urlFactory();
    }

    private void urlFactory() {
        url = Constants.URL_CORREIOS;
        zipCode = "38408400";
        addressDescription = "Rondon Pacheco";
        cepType = Constants.ALL;
        similar = Constants.NAO;
    }

    @Test
    public void testFindHtmlUrlZipCode() {

        Assert.assertNotNull(parserHtml.findHtml(url,zipCode, cepType, similar));
    }

    @Test
    public void testFindHtmlUrlAddress() {

        Assert.assertNotNull(parserHtml.findHtml(url, addressDescription, cepType, similar));
    }

    @Test
    public void testFindHtmlUrlAddressNull() {
        addressDescription = "zup";
        Assert.assertTrue(parserHtml.findHtml(url, addressDescription, cepType, similar).isEmpty());
    }

    @Test
    public void testFindHtmlUrlZipCodeNull() {
        zipCode = "98998555";
        Assert.assertTrue(parserHtml.findHtml(url,zipCode, cepType, similar).isEmpty());
    }


}
