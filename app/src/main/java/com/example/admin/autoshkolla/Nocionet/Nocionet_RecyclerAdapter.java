package com.example.admin.autoshkolla.Nocionet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.ShenjatPolicit.Shenjat_Policit_RecyclerAdapter;

/**
 * Created by Admin on 11/22/2016.
 */

public class Nocionet_RecyclerAdapter extends RecyclerView.Adapter<Nocionet_RecyclerAdapter.ViewHolder> {

    private String[] nocionet_Description = {"1. Pershkrimi i pare","2. Pershkrimi i dyte",
            "3. Pershkrimi i trete, Pershkrimi i trete,Pershkrimi i trete ,Pershkrimi i trete ,Pershkrimi i trete," +
                    "Pershkrimi i trete, Pershkrimi i trete, Pershkrimi i trete",
            "4. Pershkrimi i katert","5.Pershkrimi i peste","6. Pershkrimi i gjaste"};

    private String[] nocionet_DescriptionTitle = {"1. Titulli i pare","2. Pershkrimi i dyte",
            "3. Pershkrimi i trete"," Pershkrimi i katert","5.Pershkrimi i peste","6. Pershkrimi i gjaste"};

    private int[] nocionet_Image = {R.drawable.imageplaceholder ,R.drawable.imageplaceholder,
            R.drawable.imageplaceholder,R.drawable.imageplaceholder,R.drawable.imageplaceholder,R.drawable.imageplaceholder};


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_nocionet, parent,false);
        Nocionet_RecyclerAdapter.ViewHolder nocionetViewHolder =
                new Nocionet_RecyclerAdapter.ViewHolder(view);
        return nocionetViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.nocionet_Image.setImageResource(nocionet_Image[position]);
        holder.nocionet_Description.setText(nocionet_Description[position]);
        holder.nocionet_DescriptionTitle.setText(nocionet_DescriptionTitle[position]);
    }

    @Override
    public int getItemCount() {
        return nocionet_Description.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView nocionet_Image;
        TextView nocionet_Description, nocionet_DescriptionTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            nocionet_Image = (ImageView) itemView.findViewById(R.id.nocionet_Image);
            nocionet_Description = (TextView) itemView.findViewById(R.id.nocionet_Description);
            nocionet_DescriptionTitle = (TextView) itemView.findViewById(R.id.nocionet_Description_Title);

        }
    }
}
