package com.example.admin.autoshkolla.BlurryBackgrounds_Activities;

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


public class BlurRecyclerView_Adapter extends RecyclerView.Adapter<BlurRecyclerView_Adapter.ViewHolder> {

    public List<Sign> signs = new ArrayList<>();
    public Context context;
    private String[] blurText = {"1. Pershkrimi i pare","2. Pershkrimi i dyte","3. Pershkrimi i trete",
            "4. Pershkrimi i katert","5.Pershkrimi i peste", "6. Pershkrimi i gjaste"};

    private int[] blurImage = {R.drawable.imageplaceholder ,R.drawable.imageplaceholder,
            R.drawable.imageplaceholder,R.drawable.imageplaceholder,R.drawable.imageplaceholder,R.drawable.imageplaceholder};
    public  BlurRecyclerView_Adapter(List<Sign> ss, Context c){
        signs = ss;
        context = c;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_shenjat_policit, parent,false);
        BlurRecyclerView_Adapter.ViewHolder blurViewHolder = new BlurRecyclerView_Adapter.ViewHolder(view);
        return blurViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Sign s = signs.get(position);
        holder.descirption.setText(s.name);

        holder.imageView.setImageResource(R.drawable.imageplaceholder);
        if (s.imager != null){
            Picasso.with(context).load(s.imager.getUrl()).into(holder.imageView);
        }


    }

    @Override
    public int getItemCount() {
        return signs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView descirption;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.shenjat_Policit_Image);
            descirption = (TextView) itemView.findViewById(R.id.shenjat_Policit_Description);
        }
    }
}
