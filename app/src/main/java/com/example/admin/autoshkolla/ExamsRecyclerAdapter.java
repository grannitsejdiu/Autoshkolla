package com.example.admin.autoshkolla;


import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.admin.autoshkolla.Models.Exam;
import com.example.admin.autoshkolla.Models.Question;
import com.example.admin.autoshkolla.Testet.TestFormActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ExamsRecyclerAdapter extends RecyclerView.Adapter<ExamsRecyclerAdapter.ViewHolder> {

    public List<Exam> examList = new ArrayList<Exam>();

    public ExamsRecyclerAdapter(List<Exam> items) {
        examList = items;
    }

     class ViewHolder extends RecyclerView.ViewHolder {

         public int currentItem;
         public TextView cardviewItemImage;
         public TextView cardviewItemTitle;
         public TextView getCardviewItemDescription;

         public ViewHolder(final View itemView) {
             super(itemView);

             cardviewItemImage = (TextView) itemView.findViewById(R.id.cardviewItemImage);
             cardviewItemTitle = (TextView) itemView.findViewById(R.id.cardviewTitle);
             getCardviewItemDescription = (TextView) itemView.findViewById(R.id.cardviewDescription);

             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     int position = getAdapterPosition();

//                     Snackbar.make(view, "Click detected on Item " + position,
//                             Snackbar.LENGTH_SHORT).show();

                     Exam selectedExam = examList.get(position);

                     Intent intent = new Intent(itemView.getContext().getApplicationContext(), TestFormActivity.class);

//                     Gson gson = new Gson();

//                     intent.putExtra("selectedExam",gson.toJson(selectedExam));

                     intent.putExtra("selectExamIndex", position);

                     itemView.getContext().startActivity(intent);
                 }
             });
         }
     }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_test_list, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Exam e = examList.get(position);

        Question q = e.questions.get(0);

        String s = String.valueOf(position);

        holder.cardviewItemTitle.setText(e.name);
        holder.getCardviewItemDescription.setText(q.name);
        holder.cardviewItemImage.setText(s);

    }


    @Override
    public int getItemCount() {

        return examList.size();
        //return titles.length;
    }


}
