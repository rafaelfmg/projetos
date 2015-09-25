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

    public List<Address> findHtml(final String urlName){
        try {

            Document html = Jsoup.connect(urlName).get();
            Elements tr = html.select("tr[style]");
            List<Address> addressList= new ArrayList<Address>();

            if (tr.size() == 0) {
              return null;

            } else {
                for (Element e : tr) {
                    Address address = new Address();
                    address.setAddressDescription(e.child(0).text());
                    address.setDistrictName(e.child(1).text());
                    address.setCity(e.child(2).text());
                    address.setState(e.child(3).text());
                    address.setZipCode(e.child(4).text());

                    addressList.add(address);

                }
                return addressList;

            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        return null;
    }
}
