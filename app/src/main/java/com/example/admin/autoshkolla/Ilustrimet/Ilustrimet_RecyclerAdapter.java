package com.example.admin.autoshkolla.Ilustrimet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.autoshkolla.R;


public class Ilustrimet_RecyclerAdapter extends RecyclerView.Adapter<Ilustrimet_RecyclerAdapter.ViewHolder> {

    private String[] title = {"Titulli 1", "Titulli 2","Titulli 3","Titulli 4","Titulli 5"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_ilustrimet, parent,false);
        Ilustrimet_RecyclerAdapter.ViewHolder ilustrimetViewHolder =
                new Ilustrimet_RecyclerAdapter.ViewHolder(view);
        return ilustrimetViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cardviewItemTitle.setText(title[position]);
        holder.getCardviewItemDescription.setText("https://www.youtube.com/watch?v=N7VCLNBNJQs");
        holder.cardviewItemImage.setImageResource(R.color.titleColor);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardviewItemImage;
        public TextView cardviewItemTitle;
        public TextView getCardviewItemDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            cardviewItemImage = (ImageView) itemView.findViewById(R.id.ilustrimet_Image);
            cardviewItemTitle = (TextView) itemView.findViewById(R.id.ilustrimet_Title);
            getCardviewItemDescription = (TextView) itemView.findViewById(R.id.ilustrimet_Description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   view.getContext().startActivity(new Intent(Intent.ACTION_VIEW,
                           Uri.parse("https://www.youtube.com/watch?v=N7VCLNBNJQs")));
                }
            });
        }
    }
}
