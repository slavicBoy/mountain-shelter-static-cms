package com.example.mountainsheltercms.weather;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Weather {
    public static final String API_ADDRESS = "https://api.openweathermap.org/data/2.5/weather?q=Zawoja&appid=22d4b23fef95ea8ee893f60edea00904&units=metric";
    private String condition;
    private String description;
    private String icon;
    private int temperature;
    private String city;
}
