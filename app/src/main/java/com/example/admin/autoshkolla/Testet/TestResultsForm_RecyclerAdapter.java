package com.example.admin.autoshkolla.Testet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.autoshkolla.R;

/**
 * Created by Admin on 11/25/2016.
 */

public class TestResultsForm_RecyclerAdapter extends RecyclerView.Adapter<TestResultsForm_RecyclerAdapter.ViewHolder> {

    public String[] testNumbers = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
    "21","22","23","24","25","26","27","28","29","30"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_test_result, parent,false);
        TestResultsForm_RecyclerAdapter.ViewHolder testFormviewHolder = new TestResultsForm_RecyclerAdapter.ViewHolder(view);
        return testFormviewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.testNumber.setText(testNumbers[position]);
    }

    @Override
    public int getItemCount() {
        return testNumbers.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView testNumber;

        public ViewHolder(final View itemView) {
            super(itemView);

            testNumber = (TextView) itemView.findViewById(R.id.testNumber);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition() + 1;
                    Toast.makeText(view.getContext(),"Question " + position + " clicked", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
