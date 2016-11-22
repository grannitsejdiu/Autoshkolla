package com.example.admin.autoshkolla.Ligjeratat;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.autoshkolla.Nocionet.Nocionet_Activity;
import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.ShenjatPolicit.Shenjat_Policit_Activity;
import com.example.admin.autoshkolla.SinjalizimiHorizontal.SinjalizimiHorizontalActivity;
import com.example.admin.autoshkolla.SinjalizimiVertikal.Sinjalizimi_Vertikal_Activity;


/**
 * Created by Admin on 11/22/2016.
 */

public class Ligjeratat_RecyclerAdapter extends RecyclerView.Adapter<Ligjeratat_RecyclerAdapter.ViewHolder> {

    //region private String[] titles = {"Testi #1, ... , "Testi #n"}
    private String[] titles = {"NOCIONET",
            "SINJALIZIMI VERTIKAL",
            "SINJALIZIMI HORIZONTAL",
            "SHENJAT E POLICIT",
            "SINJALIZIMET NDRICUESE",
            "SIGURIA NE RRUGE"};
    //endregion

    //region private String[] descriptions = {"Test 1 description", ... , "Test n description"}
    private String[] descriptions = {"Njohja e nocioneve eshte e nevojshme per te kuptuar sa me mire komunikacionin",
            "Shenjat e komunikacionit dhe tabelat plotesuese",
            "Shenjat gjatesore te terthorta dhe shenjat tjera",
            "Shenjat e personit te autorizuar",
            "Shenjat ndriquese te semaforit per automjete dhe cikliste",
            "Leksione te nevojshme per rregulla dhe siguri ne rruge"};
    //endregion

    //region private int[] images = {R.drawable.questions, ... , n R.drawable.questions}
    private int[] images = {R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.questions,
            R.drawable.rregullat };
    //endregion

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_ligjeratat, parent,false);
        Ligjeratat_RecyclerAdapter.ViewHolder viewHolder = new Ligjeratat_RecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cardviewItemTitle.setText(titles[position]);
        holder.getCardviewItemDescription.setText(descriptions[position]);
        holder.cardviewItemImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
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
                            itemView.getContext().startActivity(intent);
                            break;
                        case 1:
                            Intent intent3 = new Intent(itemView.getContext().getApplicationContext(), Sinjalizimi_Vertikal_Activity.class);
                            itemView.getContext().startActivity(intent3);
                            break;
                        case 2:
                            Intent intent1 = new Intent(itemView.getContext().getApplicationContext(), SinjalizimiHorizontalActivity.class);
                            itemView.getContext().startActivity(intent1);
                            break;
                        case 3:
                            Intent intent2 = new Intent(itemView.getContext().getApplicationContext(), Shenjat_Policit_Activity.class);
                            itemView.getContext().startActivity(intent2);
                            break;
                       default:
                           return;
                    }
                }
            });
        }
    }


}
