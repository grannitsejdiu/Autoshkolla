package co.tenton.admin.autoshkolla.Rregullat_Komunikacionit_Siguria_MjetetMotorike;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.tenton.admin.autoshkolla.Models.Sign;
import co.tenton.admin.autoshkolla.Models.This;

public class SiguriaDheMjetet_RecyclerAdapter extends RecyclerView.Adapter<SiguriaDheMjetet_RecyclerAdapter.ViewHolder> {

    List<Sign> signList = new ArrayList<>();

    public SiguriaDheMjetet_RecyclerAdapter(){
        signList = This.groups.get(4).signs;
    }

    @Override
    public SiguriaDheMjetet_RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(co.tenton.admin.autoshkolla.R.layout.cardview_siguriadhemjetet, parent,false);
        SiguriaDheMjetet_RecyclerAdapter.ViewHolder viewHolder = new SiguriaDheMjetet_RecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SiguriaDheMjetet_RecyclerAdapter.ViewHolder holder, int position) {

        Sign s = signList.get(position);

        holder.description.setText(s.description);
    }

    @Override
    public int getItemCount() {
        return signList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        public ViewHolder(View itemView) {
            super(itemView);
            description = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.siguriadhemjetet_Description);
        }
    }
}
