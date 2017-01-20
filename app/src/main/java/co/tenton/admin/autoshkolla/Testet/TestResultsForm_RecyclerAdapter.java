package co.tenton.admin.autoshkolla.Testet;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.tenton.admin.autoshkolla.Models.Constants;
import co.tenton.admin.autoshkolla.Models.Question;
import co.tenton.admin.autoshkolla.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/25/2016.
 */

public class TestResultsForm_RecyclerAdapter extends RecyclerView.Adapter<TestResultsForm_RecyclerAdapter.ViewHolder> {

    public List<Question> questions = new ArrayList<Question>();
    public int examId;

    public TestResultsForm_RecyclerAdapter(List<Question> qs, int eId)
    {
        questions = qs;
        examId = eId;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_test_result, parent,false);
        TestResultsForm_RecyclerAdapter.ViewHolder testFormviewHolder = new TestResultsForm_RecyclerAdapter.ViewHolder(view);
        return testFormviewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Question q = questions.get(position);

        holder.testNumber.setText(String.valueOf(position + 1));

        if (q.correct()){
            holder.testNumber.setTextColor(Constants.successColor);
        }else{
            holder.testNumber.setTextColor(Constants.failedColor);
        }
        //holder.testNumber.setText(testNumbers[position]);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView testNumber;

        public ViewHolder(final View itemView) {
            super(itemView);

            testNumber = (TextView) itemView.findViewById(R.id.testNumber);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext().getApplicationContext(),TestQuestionResultActivity.class);
                    intent.putExtra("examIndex", examId);
                    intent.putExtra("questionIndex", getAdapterPosition());
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }
}
