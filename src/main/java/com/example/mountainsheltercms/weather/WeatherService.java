package com.example.mountainsheltercms.weather;

import com.example.mountainsheltercms.shared.MakeRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public class WeatherService {


    public Weather getWeather(){
        String request = MakeRequest.getRequest(Weather.API_ADDRESS);
        return parseWeatherJSON(request);
    }

    private Weather parseWeatherJSON(String responseBody) {
        Weather weather = new Weather();
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONObject mainInfo = jsonObject.getJSONArray(EWeather.EXTRA_INFO.getValue()).getJSONObject(0);
        JSONObject extraInfo = jsonObject.getJSONObject(EWeather.MAIN_INFO.getValue());

        weather.setCondition(mainInfo.getString(EWeather.CONDITION.getValue()));
        weather.setDescription(mainInfo.getString(EWeather.DESCRIPTION.getValue()));
        weather.setIcon(mainInfo.getString(EWeather.ICON.getValue()));
        weather.setTemperature(extraInfo.getInt(EWeather.TEMPERATURE.getValue()));
        weather.setCity(jsonObject.getString(EWeather.CITY.getValue()));

        return weather;
    }


}
