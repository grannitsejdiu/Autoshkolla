package co.tenton.admin.autoshkolla;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities.TestUdhezime_Activity;
import co.tenton.admin.autoshkolla.Models.Exam;
import co.tenton.admin.autoshkolla.Models.ExamStatuses;
import co.tenton.admin.autoshkolla.Models.Question;

import java.util.ArrayList;
import java.util.List;

public class ExamsRecyclerAdapter extends RecyclerView.Adapter<ExamsRecyclerAdapter.ViewHolder> {

    public List<Exam> examList = new ArrayList<Exam>();
    private Context context;

    public ExamsRecyclerAdapter(List<Exam> items, Context ctx) {
        examList = items;
        context = ctx;
    }

     class ViewHolder extends RecyclerView.ViewHolder {

         public int currentItem;
         public TextView cardviewItemImage;
         public TextView cardviewItemTitle;
         public TextView getCardviewItemDescription;
         public ImageView testStatus;

         public ViewHolder(final View itemView) {
             super(itemView);

             cardviewItemImage = (TextView) itemView.findViewById(R.id.cardviewItemImage);
             cardviewItemTitle = (TextView) itemView.findViewById(R.id.cardviewTitle);
             getCardviewItemDescription = (TextView) itemView.findViewById(R.id.cardviewDescription);
             testStatus = (ImageView) itemView.findViewById(R.id.testStatus);

             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     int position = getAdapterPosition();


                     Exam selectedExam = examList.get(position);

                     Intent intent = new Intent(itemView.getContext().getApplicationContext(), TestUdhezime_Activity.class);
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

        String s = String.valueOf(position + 1);

        holder.cardviewItemTitle.setText(e.name);
        holder.getCardviewItemDescription.setText(q.name);
        holder.cardviewItemImage.setText(s);

        ExamStatuses examStatus = e.getLastResults(context);
        if (examStatus == ExamStatuses.Passed){
            holder.testStatus.setImageResource(R.drawable.passed);
        }else if (examStatus == ExamStatuses.Failed){
            holder.testStatus.setImageResource(R.drawable.failed);
        }else {
            holder.testStatus.setImageResource(R.drawable.cardviewnext);
        }
    }


    @Override
    public int getItemCount() {

        return examList.size();
        //return titles.length;
    }


}
