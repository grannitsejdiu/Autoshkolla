package co.tenton.admin.autoshkolla.Ligjeratat;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import co.tenton.admin.autoshkolla.Models.Group;
import co.tenton.admin.autoshkolla.Nocionet.Nocionet_Activity;
import co.tenton.admin.autoshkolla.R;
import co.tenton.admin.autoshkolla.Rregullat_Komunikacionit_Siguria_MjetetMotorike.SiguriaDheMjetet_Activity;
import co.tenton.admin.autoshkolla.Shenjat_tabeles_Ilustrimeve.Shenjat_tbl_IlustrimeveActivity;
import co.tenton.admin.autoshkolla.SinjalizimiHorizontal.SinjalizimiHorizontalActivity;
import co.tenton.admin.autoshkolla.SinjalizimiVertikal.Sinjalizimi_Vertikal_Activity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Admin on 11/22/2016.
 */

public class Ligjeratat_RecyclerAdapter extends RecyclerView.Adapter<Ligjeratat_RecyclerAdapter.ViewHolder> {

    public List<Group> groups = new ArrayList<Group>();

    int[]  images = {R.drawable.lit_one,R.drawable.lit_two,R.drawable.lit_three,R.drawable.lit_four,
            R.drawable.lit_five,R.drawable.lit_six};

    public Ligjeratat_RecyclerAdapter(List<Group> g){
        groups = g;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_ligjeratat, parent,false);
        Ligjeratat_RecyclerAdapter.ViewHolder viewHolder = new Ligjeratat_RecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Group g = groups.get(position);

        holder.cardviewItemTitle.setText(g.name.toUpperCase());
        holder.getCardviewItemDescription.setText(g.description);
        holder.cardviewItemImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardviewItemImage;
        public TextView cardviewItemTitle;
        public TextView getCardviewItemDescription;

        public ViewHolder(final View itemView) {
            super(itemView);

            cardviewItemImage = (ImageView) itemView.findViewById(R.id.ligjeratat_CardviewItemImage);
            cardviewItemTitle = (TextView) itemView.findViewById(R.id.ligjeratat_CardViewTitle);
            getCardviewItemDescription = (TextView) itemView.findViewById(R.id.ligjeratat_CardviewDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    switch (position){
                        case 0:
                            Intent intent = new Intent(itemView.getContext().getApplicationContext(), Nocionet_Activity.class);
                            intent.putExtra("index", position);
                            itemView.getContext().startActivity(intent);
                            break;
                        case 2:
                            Intent intent3 = new Intent(itemView.getContext().getApplicationContext(), Sinjalizimi_Vertikal_Activity.class);
                            intent3.putExtra("index", position);
                            itemView.getContext().startActivity(intent3);
                            break;
                        case 1:
                            Intent intent1 = new Intent(itemView.getContext().getApplicationContext(), SinjalizimiHorizontalActivity.class);
                            intent1.putExtra("index", position);
                            itemView.getContext().startActivity(intent1);
                            break;
                        case 3:
                            Intent intent2 = new Intent(itemView.getContext().getApplicationContext(), SinjalizimiHorizontalActivity.class);
                            intent2.putExtra("index", position);
                            itemView.getContext().startActivity(intent2);
                            break;
                        case 4:
                            Intent intent4 = new Intent(itemView.getContext().getApplicationContext(), SiguriaDheMjetet_Activity.class);
                            intent4.putExtra("index", position);
                            itemView.getContext().startActivity(intent4);
                            break;

                        case 5:
                            Intent intent5 = new Intent(itemView.getContext().getApplicationContext(), Shenjat_tbl_IlustrimeveActivity.class);
                            intent5.putExtra("index", position);
                            itemView.getContext().startActivity(intent5);
                       default:
                           return;
                    }
                }
            });
        }
    }


}
