package com.apicep.xyinc.domain;



public class Address {

    protected String addressDescription;
    protected String districtName;
    protected String city;
    protected String state;
    protected String zipCode;


    public String getAddressDescription() {
        return addressDescription;
    }


    public void setAddressDescription(final String value) {
        this.addressDescription = value;
    }


    public String getDistrictName() {
        return districtName;
    }


    public void setDistrictName(final String value) {
        this.districtName = value;
    }


    public String getCity() {
        return city;
    }


    public void setCity(final String value) {
        this.city = value;
    }


    public String getState() {
        return state;
    }


    public void setState(final String value) {
        this.state = value;
    }


    public String getZipCode() {
        return zipCode;
    }


    public void setZipCode(final String value) {
        this.zipCode = value;
    }

}
