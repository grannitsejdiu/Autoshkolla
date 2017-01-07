package com.example.admin.autoshkolla.Ilustrimet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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


public class Ilustrimet_RecyclerAdapter extends RecyclerView.Adapter<Ilustrimet_RecyclerAdapter.ViewHolder> {

    private List<Sign> signs = new ArrayList<>();
    private Context context;
    public Ilustrimet_RecyclerAdapter(List<Sign> ss, Context ctx){
        signs = ss;
        context = ctx;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_ilustrimet, parent,false);
        Ilustrimet_RecyclerAdapter.ViewHolder ilustrimetViewHolder =
                new Ilustrimet_RecyclerAdapter.ViewHolder(view);
        return ilustrimetViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Sign s = signs.get(position);

        holder.cardviewItemTitle.setText(s.name);
        holder.getCardviewItemDescription.setText(s.description);
        holder.cardviewItemImage.setImageResource(R.color.titleColor);

        if (s.imager != null) {
            if (!s.imager.link.equals("")) {
                Picasso.with(context).load(s.imager.getUrl()).into(holder.cardviewItemImage);
            }
        }
    }

    @Override
    public int getItemCount() {
        return signs.size();
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

                    Intent intent = new Intent(view.getContext().getApplicationContext(), Ilustrimet_Webview.class);
                    view.getContext().startActivity(intent);

//                   view.getContext().startActivity(new Intent(Intent.ACTION_VIEW,
//                           Uri.parse("https://www.youtube.com/watch?v=N7VCLNBNJQs")));
                }
            });
        }
    }
}
