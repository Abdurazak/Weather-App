package com.addiscan.currentweather.api;

import com.addiscan.currentweather.model.WeatherData;

import retrofit.Callback;
import retrofit.http.*;

/**
 * Created by Abdu on 12/21/2014.
 */
public interface IWeather {
    @GET("/weather")
    public void getWeatherCity(@Query("q")String cities, Callback<WeatherData> callback);

}
