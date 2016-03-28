package com.api.xyinc.domain;


public class Address {

    protected String addressDescription;
    protected String districtName;
    protected String locality;
    protected String zipCode;


    public String getAddressDescription() {
        return addressDescription;
    }


    public void setAddressDescription(String value) {
        this.addressDescription = value;
    }


    public String getDistrictName() {
        return districtName;
    }


    public void setDistrictName(String value) {
        this.districtName = value;
    }


    public String getLocality() {
        return locality;
    }


    public void setLocality(String locality) {
        this.locality = locality;
    }


    public String getZipCode() {
        return zipCode;
    }


    public void setZipCode(String value) {
        this.zipCode = value;
    }

}
