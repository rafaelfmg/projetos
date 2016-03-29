package com.api.xyinc.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.xyinc.domain.Address;

public class ParserHtml {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserHtml.class);
    List<Address> addressList = new ArrayList<>();

    public List<Address> findHtml(String urlName, String relaxation, String cepType, String similar) {
        Document html;
        try {
            html = Jsoup.connect(urlName).data("relaxation", relaxation).data("tipoCEP", cepType)
                .data("semelhante", similar).post();

            Elements tr = html.select("tr");

            if (tr.isEmpty()) {
                return addressList;

            }
            tr.remove(0);
            for (Element e : tr) {
                Address address = new Address();
                address.setAddressDescription(e.child(0).text());
                address.setDistrictName(e.child(1).text());
                address.setLocality(e.child(2).text());
                address.setZipCode(e.child(3).text());

                addressList.add(address);
            }

        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return addressList;
    }
}
