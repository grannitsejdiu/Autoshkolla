package co.tenton.admin.autoshkolla.Nocionet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import co.tenton.admin.autoshkolla.Models.Sign;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/22/2016.
 */

public class Nocionet_RecyclerAdapter extends RecyclerView.Adapter<Nocionet_RecyclerAdapter.ViewHolder> {

    private List<Sign> signs = new ArrayList<Sign>();
    private Context context;

    public Nocionet_RecyclerAdapter(List<Sign> ss, Context c){
        signs = ss;
        context = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(co.tenton.admin.autoshkolla.R.layout.cardview_nocionet, parent,false);
        Nocionet_RecyclerAdapter.ViewHolder nocionetViewHolder =
                new Nocionet_RecyclerAdapter.ViewHolder(view);
        return nocionetViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Sign s = signs.get(position);
        holder.nocionet_DescriptionTitle.setText(s.name);
        holder.nocionet_Description.setText(s.description);

        holder.nocionet_Image.setVisibility(View.GONE);

        if ((s.imager != null) && (!s.imager.link.equals("")))
        {
            holder.nocionet_Image.setVisibility(View.VISIBLE);
            Picasso.with(context).load(s.imager.getUrl()).into(holder.nocionet_Image);
        }
    }

    @Override
    public int getItemCount() {
        return signs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView nocionet_Image;
        TextView nocionet_Description, nocionet_DescriptionTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            nocionet_Image = (ImageView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.nocionet_Image);
            nocionet_Description = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.nocionet_Description);
            nocionet_DescriptionTitle = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.nocionet_Description_Title);

        }
    }
}
