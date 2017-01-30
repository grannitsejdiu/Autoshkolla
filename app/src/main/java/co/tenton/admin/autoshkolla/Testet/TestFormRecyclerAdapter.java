package co.tenton.admin.autoshkolla.Testet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import co.tenton.admin.autoshkolla.Models.Question;
import co.tenton.admin.autoshkolla.R;

import com.squareup.picasso.Callback;
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

        final int pos = position;

        final Question q = questions.get(position);

        holder.questionText.setText(q.name);

        holder.questionFirstAlternative.setText(q.alternatives.get(0).name);
        holder.questionSecondAlternative.setText(q.alternatives.get(1).name);
        if (q.alternatives.size() == 3) {
            holder.questionThirdAlternative.setText(q.alternatives.get(2).name);
        }
        else{
            holder.questionThirdAlternative.setVisibility(View.GONE);
        }

        holder.questionImage.setImageResource(R.drawable.imageplaceholder);


        if (q.image != null) {
            if (!q.image.link.equals("")) {
                holder.testFormProgressBar.setVisibility(View.VISIBLE);
                Picasso.with(context).load(q.image.getUrl()).into(holder.questionImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.testFormProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        holder.testFormProgressBar.setVisibility(View.GONE);
                        holder.questionImage.setImageResource(R.drawable.error_image);
                    }
                });
            }
        }

        holder.questionFirstAlternative.setOnCheckedChangeListener(null);
        holder.questionSecondAlternative.setOnCheckedChangeListener(null);
        holder.questionThirdAlternative.setOnCheckedChangeListener(null);
        holder.questionFirstAlternative.setChecked(q.alternatives.get(0).userAnswer);
        holder.questionSecondAlternative.setChecked(q.alternatives.get(1).userAnswer);
        if (q.alternatives.size() == 3) {
            holder.questionThirdAlternative.setChecked(q.alternatives.get(2).userAnswer);
        }

        holder.questionFirstAlternative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q.alternatives.get(0).userAnswer = !q.alternatives.get(0).userAnswer;
            }
        });
        holder.questionSecondAlternative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q.alternatives.get(1).userAnswer = !q.alternatives.get(1).userAnswer;
            }
        });
        holder.questionThirdAlternative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q.alternatives.get(2).userAnswer = !q.alternatives.get(2).userAnswer;
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
        ProgressBar testFormProgressBar;

        public ViewHolder(View itemView) {
            super(itemView);

            questionImage = (ImageView) itemView.findViewById(R.id.questionImage);
            questionText = (TextView) itemView.findViewById(R.id.questionText);
            questionFirstAlternative = (CheckBox) itemView.findViewById(R.id.questionFirstAlternative);
            questionSecondAlternative = (CheckBox) itemView.findViewById(R.id.questionSecondAlternative);
            questionThirdAlternative = (CheckBox) itemView.findViewById(R.id.questionThirdAlternative);
            testFormProgressBar = (ProgressBar) itemView.findViewById(R.id.testProgressBar);
        }
    }

}
