package com.example.admin.autoshkolla.SinjalizimiHorizontal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.autoshkolla.R;


public class SinjalizimiHorizontalRecyclerAdapter extends RecyclerView.Adapter<SinjalizimiHorizontalRecyclerAdapter.ViewHolder> {

    private String[] sinjalizimiHorizontalDescription = {"1. Pershkrimi i pare","2. Pershkrimi i dyte","3. Pershkrimi i trete",
            "4. Pershkrimi i katert","5.Pershkrimi i peste", "6. Pershkrimi i gjaste"};

    private int[] sinjalizimiHorizontalImage = {R.drawable.imageplaceholder ,R.drawable.imageplaceholder,
            R.drawable.imageplaceholder,R.drawable.imageplaceholder,R.drawable.imageplaceholder,R.drawable.imageplaceholder};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_sinjalizimi_horizontal, parent,false);
        SinjalizimiHorizontalRecyclerAdapter.ViewHolder sinjalizimiHorizontalviewHolder =
                new SinjalizimiHorizontalRecyclerAdapter.ViewHolder(view);
        return sinjalizimiHorizontalviewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.sinjalizimiHorizontalImage.setImageResource(sinjalizimiHorizontalImage[position]);
        holder.sinjalizimiHorizontalDescription.setText(sinjalizimiHorizontalDescription[position]);

    }

    @Override
    public int getItemCount() {
        return sinjalizimiHorizontalDescription.length;
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
