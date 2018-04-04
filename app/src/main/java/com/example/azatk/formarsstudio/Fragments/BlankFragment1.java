package com.example.azatk.formarsstudio.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.azatk.formarsstudio.Adapter;
import com.example.azatk.formarsstudio.Api;
import com.example.azatk.formarsstudio.Models.City;
import com.example.azatk.formarsstudio.Models.List;
import com.example.azatk.formarsstudio.Models.Model;
import com.example.azatk.formarsstudio.R;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class BlankFragment1 extends Fragment {

    private RecyclerView recyclerView;
    java.util.List<List> arrayList = new ArrayList();
    java.util.List<City> arrayCity = new ArrayList();
    java.util.List<Model> arrayModel = new ArrayList();

    public BlankFragment1() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);

        recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        Api.getInstance().getWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object->{
                    Log.d("kjadbkja",object+"");

                    arrayList.clear();
                    arrayCity.clear();
                    arrayModel.clear();
                    arrayModel.add(object);
                    Log.d("sdjnsldn",""+object.list.size());
                    for(int i=0; i<object.list.size();i++){
                        arrayList.add(object.list.get(i));


                    }
                    recyclerView.setAdapter(new Adapter(arrayList,arrayModel,getActivity()));


                },(Throwable throwable)->{
                    Log.d("dcadcasca","error "+throwable);
                });


        // Inflate the layout for this fragment
        return view;
    }


}
