package co.tenton.admin.autoshkolla.MainActivitiy;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import co.tenton.admin.autoshkolla.Autoshkolla_Profile.Autoshkolla_Profile;
import co.tenton.admin.autoshkolla.Ilustrimet.Ilustrimet_Activity;
import co.tenton.admin.autoshkolla.Ligjeratat.Ligjeratat_Activity;
import co.tenton.admin.autoshkolla.Procedurat.Procedurat_Activity;
import co.tenton.admin.autoshkolla.TestetActivity;

/**
 * Created by Admin on 12/5/2016.
 */

public class Autoshkolla_MainRecyclerAdapter extends RecyclerView.Adapter<Autoshkolla_MainRecyclerAdapter.ViewHolder> {

    private String[] title = {"TESTE", "LIGJERATA","PROCEDURAT","ILUSTRIMET","AUTOSHKOLLAT"};
    private String[] description = {"Teste teorike për përgaditjen e provimit final për patent shofer, kategoria A dhe B",
    "Literatura dhe shembuj të ndryshëm në lidhje me Rregullat e Sigurisë  dhe të Komunikacionit.",
    "Dokumentet e nevojshme për regjistrim të patent shoferit.",
    "Lorem ipsum is simply dummy text of the printin and typesetting",
    "Autoshkolla të ndryshme në vendin tonë, zgjedhe autoshkollen tënde!"};

    private int[] images = {co.tenton.admin.autoshkolla.R.drawable.a_questionicon, co.tenton.admin.autoshkolla.R.drawable.a_learningicon,
    co.tenton.admin.autoshkolla.R.drawable.a_procedureicon, co.tenton.admin.autoshkolla.R.drawable.a_ilustrimeicon,
    co.tenton.admin.autoshkolla.R.drawable.a_mapsicon};


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(co.tenton.admin.autoshkolla.R.layout.cardview_ligjeratat, parent,false);
        Autoshkolla_MainRecyclerAdapter.ViewHolder viewHolder = new Autoshkolla_MainRecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cardviewItemTitle.setText(title[position]);
        holder.getCardviewItemDescription.setText(description[position]);
        holder.cardviewItemImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardviewItemImage;
        public TextView cardviewItemTitle;
        public TextView getCardviewItemDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            cardviewItemImage = (ImageView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.ligjeratat_CardviewItemImage);
            cardviewItemTitle = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.ligjeratat_CardViewTitle);
            getCardviewItemDescription = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.ligjeratat_CardviewDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    switch (position){
                        case 0:
                            Intent intent = new Intent(view.getContext().getApplicationContext(), TestetActivity.class);
                            view.getContext().startActivity(intent);
                            break;
                        case 1:
                            Intent intent2 = new Intent(view.getContext().getApplicationContext(), Ligjeratat_Activity.class);
                            view.getContext().startActivity(intent2);
                            break;
                        case 2:
                            Intent intent3 = new Intent(view.getContext().getApplicationContext(), Procedurat_Activity.class);
                            view.getContext().startActivity(intent3);
                            break;
                        case 3:
                            Intent intent4 = new Intent(view.getContext().getApplicationContext(), Ilustrimet_Activity.class);
                            view.getContext().startActivity(intent4);
                            break;
                        case 4:
                            Intent intent5 = new Intent(view.getContext().getApplicationContext(), Autoshkolla_Profile.class);
                            view.getContext().startActivity(intent5);
                            break;
                        default:
                            return;
                    }
                }
            });

        }
    }
}
