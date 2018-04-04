package com.example.azatk.formarsstudio.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.azatk.formarsstudio.Api;
import com.example.azatk.formarsstudio.Models2.SearchList;
import com.example.azatk.formarsstudio.R;
import com.example.azatk.formarsstudio.SearchAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BlankFragment2 extends Fragment {

    private EditText text;
    private ImageButton btnearch;
    private RecyclerView recyclerView;
    List<SearchList> array= new ArrayList<>();

    public BlankFragment2() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);

        text = view.findViewById(R.id.text);
        btnearch = view.findViewById(R.id.iv);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        btnearch.setOnClickListener(v ->{

            search(text.getText().toString());


        });

        return view;
    }

    private void search(String text) {

        Api.getInstance().getSearch(text,"090901ca7580a26005173e9e9786d5f2")
                .debounce(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object -> {
                    Log.d("zazazaza","uurraaa="+object);

                    array.clear();

                        array.add(object);


                    recyclerView.setAdapter(new SearchAdapter(getActivity(),array));

                },(Throwable throwable) -> {
                    Log.d("jhvhvjh", "news processor, error"+throwable);


                });
    }

}
