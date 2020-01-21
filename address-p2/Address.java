package com.company;

public class Address
{
    int street_num;
    String city, state, country;
    Address()
    {
        street_num = 0;
        city = "NA";
        state = "NA";
        country = "NA";
    }
    Address(int street_num, String city,String state,String country)
    {
        this.street_num = street_num;
        this.city = city;
        this.country = country;
        this.state = state;
    }
    int getstreetnum()
    {
        return street_num;
    }
    String getcity()
    {
        return city;
    }
    String getstate()
    {
        return state;
    }
    String getcountry()
    {
        return country;
    }
}
