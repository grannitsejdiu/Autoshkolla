package com.example.admin.autoshkolla.SinjalizimiHorizontal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.autoshkolla.Models.Sign;
import com.example.admin.autoshkolla.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class SinjalizimiHorizontalRecyclerAdapter extends RecyclerView.Adapter<SinjalizimiHorizontalRecyclerAdapter.ViewHolder> {

    private List<Sign> signs = new ArrayList<>();
    private Context context;

    public  SinjalizimiHorizontalRecyclerAdapter(List<Sign> s, Context c){
        signs = s;
        context = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_sinjalizimi_horizontal, parent,false);
        SinjalizimiHorizontalRecyclerAdapter.ViewHolder sinjalizimiHorizontalviewHolder =
                new SinjalizimiHorizontalRecyclerAdapter.ViewHolder(view);
        return sinjalizimiHorizontalviewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Sign s = signs.get(position);

        holder.sinjalizimiHorizontalDescription.setText(s.description);

        holder.sinjalizimiHorizontalImage.setImageResource(R.drawable.imageplaceholder);
        if ((s.imager != null) && (!s.imager.link.equals("")))
        {
            Picasso.with(context).load(s.imager.getUrl()).into(holder.sinjalizimiHorizontalImage);
        }

    }

    @Override
    public int getItemCount() {
        return signs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView sinjalizimiHorizontalImage;
        public TextView sinjalizimiHorizontalDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            sinjalizimiHorizontalImage = (ImageView) itemView.findViewById(R.id.sinjalizimitHorizontalImage);
            sinjalizimiHorizontalDescription = (TextView) itemView.findViewById(R.id.sinjalizimitHorizontalDescription);
        }
    }
}
