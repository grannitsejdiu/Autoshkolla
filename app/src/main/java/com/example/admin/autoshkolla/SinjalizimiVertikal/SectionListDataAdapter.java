package com.example.admin.autoshkolla.SinjalizimiVertikal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.autoshkolla.R;

import java.util.ArrayList;


public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemsList;
    private Context mContext;

    private int[] sectionImages = {R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat,
            R.drawable.ligjeratat,
            R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.questions,
            R.drawable.rregullat,
            R.drawable.autoshkollat};

    private String[] sectionItemTitle = {"Title One", "Title Two", "Title Three", "Title Four", "Title Five",
            "Title Six", "Title Seven","Title Eight" };

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
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
        holder.tvTitle.setText(sectionItemTitle[position]);
        holder.itemImage.setImageResource(sectionImages[position]);

    }

    @Override
    public int getItemCount() {
        return sectionItemTitle.length;
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;
        protected ImageView itemImage;

        public SingleItemRowHolder(View itemView) {
            super(itemView);

            this.tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) itemView.findViewById(R.id.itemImage);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
