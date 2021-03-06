package co.tenton.admin.autoshkolla.Procedurat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 1/10/2017.
 */

public class Procedurat_RecyclerAdapter extends RecyclerView.Adapter<Procedurat_RecyclerAdapter.ViewHolder> {

    int[] descriptions = {co.tenton.admin.autoshkolla.R.string.procedura1, co.tenton.admin.autoshkolla.R.string.procedura2, co.tenton.admin.autoshkolla.R.string.procedura3};
    String[] hapat = {"Hapi 1", "Hapi 2", "Hapi 3"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(co.tenton.admin.autoshkolla.R.layout.cardview_procedurat, parent,false);
        Procedurat_RecyclerAdapter.ViewHolder viewHolder = new Procedurat_RecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.hapat.setText(hapat[position]);
        holder.procedura.setText(descriptions[position]);
    }

    @Override
    public int getItemCount() {
        return descriptions.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hapat;
        TextView procedura ;
        public ViewHolder(View itemView) {
            super(itemView);

            procedura = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.procedurat_Description);
            hapat = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.procedurat_Title);
        }
    }
}
