package com.example.azatk.formarsstudio;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.azatk.formarsstudio.Models2.SearchList;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by azatk on 04.04.2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    List<SearchList> list;


    public SearchAdapter(FragmentActivity context, List<SearchList> array) {
        this.list = array;
    }

    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item2,null);

        return new SearchAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SearchAdapter.ViewHolder holder, int position) {



        SearchList con = list.get(0);
        Log.d("kbkbk",""+position);

        holder.city.setText(con.name);
        holder.time.setText(con.weather.get(0).description);
//          Log.d("sdvsd",con.name);
        holder.temp.setText((int) (273 - con.main.temp)/1 +" C");
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
        ImageView icon;


        public ViewHolder(View itemView) {
            super(itemView);
            city = itemView.findViewById(R.id.city_tv);
            time = itemView.findViewById(R.id.time_tv);
            temp = itemView.findViewById(R.id.temp_tv);
            icon = itemView.findViewById(R.id.icon_iv);



        }
    }

}
