package com.api.xyinc.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.api.xyinc.domain.Address;

public class ParserHtml {

    public List<Address> findHtml(String urlName, String relaxation, String cepType, String similar) {
        Document html;
        try {
            html = Jsoup.connect(urlName).data("relaxation", relaxation).data("tipoCEP", cepType)
                .data("semelhante", similar).post();

            Elements tr = html.select("tr");
            List<Address> addressList = new ArrayList<Address>();

            if (tr.size() == 0) {
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
            return addressList;

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }// .get();

        return null;
    }
}
