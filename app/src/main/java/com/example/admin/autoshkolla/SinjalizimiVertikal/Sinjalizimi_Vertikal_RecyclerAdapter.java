package com.example.admin.autoshkolla.SinjalizimiVertikal;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.autoshkolla.Models.Subgroup;
import com.example.admin.autoshkolla.R;

import java.util.ArrayList;
import java.util.List;

public class Sinjalizimi_Vertikal_RecyclerAdapter extends RecyclerView.Adapter<Sinjalizimi_Vertikal_RecyclerAdapter.ItemRowHolder>{

    public List<Subgroup> subgroups = new ArrayList<Subgroup>();
    public Context context;

    public Sinjalizimi_Vertikal_RecyclerAdapter(List<Subgroup> ss, Context c) {
        context = c;
        subgroups = ss;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_list_item, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int position) {

        Subgroup sg = subgroups.get(position);

        holder.itemTitle.setText(sg.name);
        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(sg.signs, context);

        holder.recycler_view_list.setHasFixedSize(true);
        holder.recycler_view_list.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recycler_view_list.setAdapter(itemListDataAdapter);

    }

    @Override
    public int getItemCount() {
        return subgroups.size();
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        TextView itemTitle;
        RecyclerView recycler_view_list;
        Button btnMore;

        public ItemRowHolder(View itemView) {
            super(itemView);

            this.itemTitle = (TextView) itemView.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) itemView.findViewById(R.id.recycler_view_list);
            this.btnMore= (Button) itemView.findViewById(R.id.btnMore);

        }
    }
}
