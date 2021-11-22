package com.example.mountainsheltercms.weather;

public enum EWeather {
     CONDITION("main"), DESCRIPTION("description"), ICON("icon"), CITY("name"),
     TEMPERATURE("temp"), MAIN_INFO("main"), EXTRA_INFO("weather");

    private String value;

    EWeather(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
