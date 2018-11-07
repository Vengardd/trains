package com.vengard.trains.model;

import java.util.ArrayList;
import java.util.List;

public class Train {

    private List<String> cityList = new ArrayList<>();

    public Train() {
    }

    public Train(List<String> cityList) {
        this.cityList = cityList;
    }

    public List<String> getCityList() {
        return cityList;
    }
}
