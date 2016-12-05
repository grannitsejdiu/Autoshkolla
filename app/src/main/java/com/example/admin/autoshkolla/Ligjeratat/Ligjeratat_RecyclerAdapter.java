package com.example.admin.autoshkolla.Ligjeratat;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.autoshkolla.Models.Group;
import com.example.admin.autoshkolla.Nocionet.Nocionet_Activity;
import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.ShenjatPolicit.Shenjat_Policit_Activity;
import com.example.admin.autoshkolla.SinjalizimiHorizontal.SinjalizimiHorizontalActivity;
import com.example.admin.autoshkolla.SinjalizimiVertikal.Sinjalizimi_Vertikal_Activity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Admin on 11/22/2016.
 */

public class Ligjeratat_RecyclerAdapter extends RecyclerView.Adapter<Ligjeratat_RecyclerAdapter.ViewHolder> {

    public List<Group> groups = new ArrayList<Group>();

    public Ligjeratat_RecyclerAdapter(List<Group> g){
        groups = g;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_ligjeratat, parent,false);
        Ligjeratat_RecyclerAdapter.ViewHolder viewHolder = new Ligjeratat_RecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Group g = groups.get(position);

        holder.cardviewItemTitle.setText(g.name.toUpperCase());
        holder.getCardviewItemDescription.setText(g.description);
        holder.cardviewItemImage.setImageResource(R.drawable.a_questionicon);
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardviewItemImage;
        public TextView cardviewItemTitle;
        public TextView getCardviewItemDescription;

        public ViewHolder(final View itemView) {
            super(itemView);

            cardviewItemImage = (ImageView) itemView.findViewById(R.id.ligjeratat_CardviewItemImage);
            cardviewItemTitle = (TextView) itemView.findViewById(R.id.ligjeratat_CardViewTitle);
            getCardviewItemDescription = (TextView) itemView.findViewById(R.id.ligjeratat_CardviewDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    switch (position){
                        case 0:
                            Intent intent = new Intent(itemView.getContext().getApplicationContext(), Nocionet_Activity.class);
                            intent.putExtra("index", position);
                            itemView.getContext().startActivity(intent);
                            break;
                        case 2:
                            Intent intent3 = new Intent(itemView.getContext().getApplicationContext(), Sinjalizimi_Vertikal_Activity.class);
                            intent3.putExtra("index", position);
                            itemView.getContext().startActivity(intent3);
                            break;
                        case 1:
                            Intent intent1 = new Intent(itemView.getContext().getApplicationContext(), SinjalizimiHorizontalActivity.class);
                            intent1.putExtra("index", position);
                            itemView.getContext().startActivity(intent1);
                            break;
                        case 3:
                            Intent intent2 = new Intent(itemView.getContext().getApplicationContext(), SinjalizimiHorizontalActivity.class);
                            intent2.putExtra("index", position);
                            itemView.getContext().startActivity(intent2);
                            break;
                       default:
                           return;
                    }
                }
            });
        }
    }


}
