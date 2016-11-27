package com.example.admin.autoshkolla.SinjalizimiVertikal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.autoshkolla.BlurryBackgrounds_Activities.BlurRecyclerView_Activity;
import com.example.admin.autoshkolla.Models.Sign;
import com.example.admin.autoshkolla.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    public List<Sign> signs = new ArrayList<Sign>();
    public Context context;

    public SectionListDataAdapter(List<Sign> ss, Context c) {
        signs = ss;
        context = c;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_list_single, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int position) {
//        SingleItemModel singleItem = itemsList.get(position);

        Sign s = signs.get(position);

        holder.tvTitle.setText(s.name);
//        holder.itemImage.setImageResource(sectionImages[position]);

        Picasso.with(context).load(s.imager.getUrl()).into(holder.itemImage);

    }

    @Override
    public int getItemCount() {
        return signs.size() >= 10 ? 10 : signs.size();
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;
        protected ImageView itemImage;

        public SingleItemRowHolder(final View itemView) {
            super(itemView);

            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) itemView.findViewById(R.id.itemImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(itemView.getContext().getApplicationContext(), BlurRecyclerView_Activity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
