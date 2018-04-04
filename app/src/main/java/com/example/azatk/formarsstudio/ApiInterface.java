package com.example.azatk.formarsstudio;

import com.example.azatk.formarsstudio.Models.Model;
import com.example.azatk.formarsstudio.Models2.SearchList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by azatk on 03.04.2018.
 */

public interface ApiInterface {


    @GET("data/2.5/forecast?q=Almaty&appid=090901ca7580a26005173e9e9786d5f2")
    Observable<Model> getWeather();

    @GET("data/2.5/weather")
    Observable<SearchList> getSearch(
            @Query("q") String query,
            @Query("appid") String query2
    );

}
