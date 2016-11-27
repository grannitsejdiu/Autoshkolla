package com.example.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.SinjalizimiVertikal.SectionListDataAdapter;


public class SinjalizimiVertikalGrid_Adapter extends RecyclerView.Adapter<SinjalizimiVertikalGrid_Adapter.ViewHolder> {

    private String[] title = {"1. Pershkrimi i pare","2. Pershkrimi i dyte","3. Pershkrimi i trete",
            "4. Pershkrimi i katert","5.Pershkrimi i peste", "6. Pershkrimi i gjaste","1. Pershkrimi i pare","2. Pershkrimi i dyte","3. Pershkrimi i trete",
            "4. Pershkrimi i katert","5.Pershkrimi i peste", "6. Pershkrimi i gjaste","1. Pershkrimi i pare","2. Pershkrimi i dyte"};

    private int[] image = {R.drawable.imageplaceholder ,R.drawable.imageplaceholder,
            R.drawable.imageplaceholder,R.drawable.imageplaceholder,R.drawable.imageplaceholder,R.drawable.imageplaceholder};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_list_single, null);
        SinjalizimiVertikalGrid_Adapter.ViewHolder mh = new SinjalizimiVertikalGrid_Adapter.ViewHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemImage.setImageResource(R.drawable.imageplaceholder);
        holder.tvTitle.setText(title[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView tvTitle;
         ImageView itemImage;
        public ViewHolder(final View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            itemImage = (ImageView) itemView.findViewById(R.id.itemImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext().getApplicationContext(),BlurRecyclerView_Activity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
