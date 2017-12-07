package com.pencilcanada.rubick.model;

import lombok.Data;

@Data
public class Address {
    private String line1;
    private String line2;
    private String city;
    private String province;
    private String zip;
    private String country;
}
