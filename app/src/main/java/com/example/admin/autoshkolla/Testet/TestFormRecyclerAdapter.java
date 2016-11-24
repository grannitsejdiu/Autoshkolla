package com.example.admin.autoshkolla.Testet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.autoshkolla.Models.Question;
import com.example.admin.autoshkolla.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class TestFormRecyclerAdapter extends RecyclerView.Adapter<TestFormRecyclerAdapter.ViewHolder>{

    private Context context;
    private List<Question> questions = new ArrayList<Question>();


    public TestFormRecyclerAdapter(List<Question> qs, Context cx){
        questions = qs;
        context = cx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_testform, parent,false);
        TestFormRecyclerAdapter.ViewHolder testFormviewHolder = new TestFormRecyclerAdapter.ViewHolder(view);
        return testFormviewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Question q = questions.get(position);

        holder.questionText.setText(q.name);
        holder.questionFirstAlternative.setText(q.alternatives.get(0).name);
        holder.questionSecondAlternative.setText(q.alternatives.get(1).name);
        holder.questionThirdAlternative.setText(q.alternatives.get(2).name);
        holder.questionImage.setImageResource(R.drawable.imageplaceholder);

        if (q.image != null) {
            if (q.image.link != "") {
                Picasso.with(context).load(q.image.getUrl()).into(holder.questionImage);
            }
        }

        q.alternatives.get(0).userAnswer = holder.questionFirstAlternative.isChecked();
        Log.e("Alt 0 User Answer: ", q.alternatives.get(0).userAnswer.toString());

        holder.questionFirstAlternative.setOnCheckedChangeListener(null);

        holder.questionFirstAlternative.setChecked(q.alternatives.get(0).userAnswer);

        holder.questionFirstAlternative.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                q.alternatives.get(0).userAnswer = isChecked;
            }
        });



    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView questionImage;
        public TextView questionText;
        public CheckBox questionFirstAlternative,questionSecondAlternative, questionThirdAlternative;

        public ViewHolder(View itemView) {
            super(itemView);

            questionImage = (ImageView) itemView.findViewById(R.id.questionImage);
            questionText = (TextView) itemView.findViewById(R.id.questionText);
            questionFirstAlternative = (CheckBox) itemView.findViewById(R.id.questionFirstAlternative);
            questionSecondAlternative = (CheckBox) itemView.findViewById(R.id.questionSecondAlternative);
            questionThirdAlternative = (CheckBox) itemView.findViewById(R.id.questionThirdAlternative);

        }
    }

}
