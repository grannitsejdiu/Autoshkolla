package com.example.admin.autoshkolla;


import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.autoshkolla.Testet.TestFormActivity;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    //region private String[] titles = {"Testi #1, ... , "Testi #n"}
    private String[] titles = {"Testi #1",
            "Testi #2",
            "Testi #3",
            "Testi #4",
            "Testi #5",
            "Testi #6",
            "Testi #7",
            "Testi #8",
            "Testi #9",
            "Testi #10",
            "Testi #11",
            "Testi #12",
            "Testi #13",
            "Testi #14",
            "Testi #15",
            "Testi #16",
            "Testi #17",
            "Testi #18",
            "Testi #19",
            "Testi #20",
            "Testi #21",
            "Testi #22",
            "Testi #23",
            "Testi #24",
            "Testi #25",
            "Testi #26",
            "Testi #27",
            "Testi #28",
            "Testi #29",
            "Testi #30",
            "Testi #31",
            "Testi #32",
            "Testi #33",
            "Testi #34",
            "Testi #35",
            "Testi #36",
            "Testi #37",
            "Testi #38",
            "Testi #39",
            "Testi #40",
            "Testi #41",
            "Testi #42",
            "Testi #43",
            "Testi #44",
            "Testi #45",
            "Testi #46",
            "Testi #47",
            "Testi #48",
            "Testi #49",
            "Testi #50",
            "Testi #51",
            "Testi #52",
            "Testi #53",
            "Testi #54",
            "Testi #55"};
    //endregion

    //region private String[] descriptions = {"Test 1 description", ... , "Test n description"}
    private String[] descriptions = {"Test 1 description",
            "Test 2 description",
            "Test 3 description",
            "Test 4 description",
            "Test 5 description",
            "Test 6 description",
            "Test 7 description",
            "Test 8 description",
            "Test 9 description",
            "Test 10 description",
            "Test 11 description",
            "Test 12 description",
            "Test 13 description",
            "Test 14 description",
            "Test 15 description",
            "Test 16 description",
            "Test 17 description",
            "Test 18 description",
            "Test 19 description",
            "Test 20 description",
            "Test 21 description",
            "Test 22 description",
            "Test 23 description",
            "Test 24 description",
            "Test 25 description",
            "Test 26 description",
            "Test 27 description",
            "Test 28 description",
            "Test 29 description",
            "Test 30 description",
            "Test 31 description",
            "Test 32 description",
            "Test 33 description",
            "Test 34 description",
            "Test 35 description",
            "Test 36 description",
            "Test 37 description",
            "Test 38 description",
            "Test 39 description",
            "Test 40 description",
            "Test 41 description",
            "Test 42 description",
            "Test 43 description",
            "Test 44 description",
            "Test 45 description",
            "Test 46 description",
            "Test 47 description",
            "Test 48 description",
            "Test 49 description",
            "Test 50 description",
            "Test 51 description",
            "Test 52 description",
            "Test 53 description",
            "Test 54 description",
            "Test 55 description"};
    //endregion

    //region private int[] images = {R.drawable.questions, ... , n R.drawable.questions}
    private int[] images = {R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.questions };
    //endregion

     class ViewHolder extends RecyclerView.ViewHolder {

         public int currentItem;
         public ImageView cardviewItemImage;
         public TextView cardviewItemTitle;
         public TextView getCardviewItemDescription;

        public ViewHolder(final View itemView) {
            super(itemView);

            cardviewItemImage = (ImageView) itemView.findViewById(R.id.cardviewItemImage);
            cardviewItemTitle = (TextView) itemView.findViewById(R.id.cardviewTitle);
            getCardviewItemDescription = (TextView) itemView.findViewById(R.id.cardviewDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    Snackbar.make(view,"Click detected on Item " + position,
                            Snackbar.LENGTH_SHORT).show();

                    Intent intent = new Intent(itemView.getContext().getApplicationContext(), TestFormActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
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


}

