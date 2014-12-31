package com.addiscan.currentweather;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.addiscan.currentweather.api.IWeather;
import com.addiscan.currentweather.model.WeatherData;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class Main extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final EditText inCountry = (EditText) findViewById(R.id.inCountry);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        final TextView tv = (TextView) findViewById(R.id.textView);
        Button getBtn = (Button) findViewById(R.id.getBtn);

        getBtn.setOnClickListener(new View.OnClickListener() {
            RestAdapter restAdapter = new RestAdapter
                    .Builder()
                    .setEndpoint("http://api.openweathermap.org/data/2.5")
                    .build();
            IWeather weather = restAdapter.create(IWeather.class);
            @Override
            public void onClick(View v) {
                weather.getWeatherCity(inCountry.getText().toString(),new Callback<WeatherData>() {
                    @Override
                    public void success(WeatherData weatherData, Response response) {
                        String da = weatherData.getWeather().get(0).getIcon();
                        String url = "http://openweathermap.org/img/w/"+da+".png";
                        Picasso.with(getBaseContext()).load(url).into(imageView);

                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
