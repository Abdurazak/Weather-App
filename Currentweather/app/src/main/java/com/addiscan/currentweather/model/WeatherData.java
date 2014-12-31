package com.addiscan.currentweather.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abdu on 12/21/2014.
 */
public class WeatherData {
    public List<weather> weather = new ArrayList<weather>();

    public List<weather> getWeather() {
        return weather;
    }

    public void setWeather(List<weather> weather) {
        this.weather = weather;
    }

    public class weather{
        public int id;
        public String main;
        public String description;
        public String icon;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }
    }
}
