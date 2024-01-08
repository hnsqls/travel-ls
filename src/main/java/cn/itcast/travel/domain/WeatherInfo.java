package cn.itcast.travel.domain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class WeatherInfo {

    private JSONObject now;
    private JSONArray forecasts;


    public JSONObject getNow() {
        return now;
    }

    public void setNow(JSONObject now) {
        this.now = now;
    }

    public JSONArray getForecasts() {
        return forecasts;
    }

    public void setForecasts(JSONArray forecasts) {
        this.forecasts = forecasts;
    }

    public WeatherInfo() {
    }

    public WeatherInfo(JSONObject now, JSONArray forecasts) {
        this.now = now;
        this.forecasts = forecasts;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "now=" + now +
                ", forecasts=" + forecasts +
                '}';
    }
}
