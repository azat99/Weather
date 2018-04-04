package com.example.azatk.formarsstudio;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.azatk.formarsstudio.Models.Model;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by azatk on 02.04.2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    List<com.example.azatk.formarsstudio.Models.List> list;
    List<Model> models;

    public Adapter(List<com.example.azatk.formarsstudio.Models.List> list, List<Model> mod, FragmentActivity context) {
        this.models = mod;
        this.list = list;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,null);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {



        com.example.azatk.formarsstudio.Models.List con = list.get(position);
        Model mod = models.get(0);
        Log.d("kbkbk",""+position);

        holder.city.setText(mod.city.name);
        holder.time.setText(String.valueOf(con.dt_txt));
        holder.temp.setText((int) (273 - con.main.temp)/1 +" C");
        holder.main.setText(con.weather.get(0).description);
        Picasso.with(holder.icon.getContext()).load("http://openweathermap.org/img/w/"+con.weather.get(0).icon+".png")
                .into(holder.icon);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView city;
        TextView time;
        TextView temp;
        TextView main;
        ImageView icon;


        public ViewHolder(View itemView) {
            super(itemView);
            city = itemView.findViewById(R.id.city_tv);
            time = itemView.findViewById(R.id.time_tv);
            temp = itemView.findViewById(R.id.temp_tv);
            main = itemView.findViewById(R.id.main_tv);
            icon = itemView.findViewById(R.id.icon_iv);


        }
    }

}
