package com.example.admin.autoshkolla.Rregullat_Komunikacionit_Siguria_MjetetMotorike;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.autoshkolla.R;

public class SiguriaDheMjetet_RecyclerAdapter extends RecyclerView.Adapter<SiguriaDheMjetet_RecyclerAdapter.ViewHolder> {
    int[] descriptions = {R.string.procedura1,R.string.procedura1, R.string.procedura1,
            R.string.procedura1,R.string.procedura1, R.string.procedura1};

    @Override
    public SiguriaDheMjetet_RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_siguriadhemjetet, parent,false);
        SiguriaDheMjetet_RecyclerAdapter.ViewHolder viewHolder = new SiguriaDheMjetet_RecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SiguriaDheMjetet_RecyclerAdapter.ViewHolder holder, int position) {
        holder.description.setText(descriptions[position]);
    }

    @Override
    public int getItemCount() {
        return descriptions.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        public ViewHolder(View itemView) {
            super(itemView);
            description = (TextView) itemView.findViewById(R.id.siguriadhemjetet_Description);
        }
    }
}
