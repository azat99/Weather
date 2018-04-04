package com.example.azatk.formarsstudio;

import android.util.Log;

import com.example.azatk.formarsstudio.Models.Model;
import com.example.azatk.formarsstudio.Models2.SearchList;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by azatk on 03.04.2018.
 */

public class Api {

    private final static String BASE_URL = "http://api.openweathermap.org/";

    private static Api instance;
    private static Retrofit retrofit = null;

    public static synchronized Api getInstance()
    {
        if (instance == null)
            instance = new Api();

        return instance;
    }


    private static Retrofit getClient()
    {
        if (retrofit==null)
        {

            //Log.d(App.TAG, "retrofit");
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())) // used with RxJava2
                    .build();
        }

        return retrofit;
    }



    private ApiInterface createService()
    {
        return getClient().create(ApiInterface.class);
    }

    public Observable<Model> getWeather(){
        return createService().getWeather().map(
                object->{
                    Log.d("khsdskk",object+"");
                    if(object.list != null ){
                        return object;
                    }else{

                        return new Model();
                    }

                }
        );
    }

    public Observable<SearchList> getSearch(final String query,final String query2) {
        return createService().getSearch(query,query2).map(
                likeObject -> {
                    Log.d("sfvsvsdvds","not null1");
                    if (likeObject!=null ) {

                        return likeObject;
                    } else {
                        return new SearchList();
                    }
                }
        );
    }



}
