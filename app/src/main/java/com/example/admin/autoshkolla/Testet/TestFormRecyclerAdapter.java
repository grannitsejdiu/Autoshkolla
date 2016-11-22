package com.example.admin.autoshkolla.Testet;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.autoshkolla.R;


public class TestFormRecyclerAdapter extends RecyclerView.Adapter<TestFormRecyclerAdapter.ViewHolder>{

    private String[] questionText = {"1. PYETJA E PARE","2. PYETJA E DYTE","3. PYETJA E TRETE",
            "4. PYETJA E KATERT","5.PYETJA E PESTE", "6. PYETJA E GJASHTE"};

    private String[] questionFirstAlternative = {"FirstAlternative","FirstAlternative",
            "FirstAlternative","FirstAlternative","FirstAlternative","FirstAlternative"};

    private String[] questionSecondAlternative = {"SecondAlternative","SecondAlternative",
            "SecondAlternative","SecondAlternative","SecondAlternative","SecondAlternative"};

    private String[] questionThirdAlternative = {"ThirdAlternative","ThirdAlternative",
            "ThirdAlternative","ThirdAlternative","ThirdAlternative","ThirdAlternative"};

    private int[] questiomImage = {R.drawable.imageplaceholder ,R.drawable.imageplaceholder,
            R.drawable.imageplaceholder,R.drawable.imageplaceholder,R.drawable.imageplaceholder,R.drawable.imageplaceholder};


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_testform, parent,false);
        TestFormRecyclerAdapter.ViewHolder testFormviewHolder = new TestFormRecyclerAdapter.ViewHolder(view);
        return testFormviewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.questionText.setText(questionText[position]);
        holder.questionImage.setImageResource(questiomImage[position]);
        holder.questionFirstAlternative.setText(questionFirstAlternative[position]);
        holder.questionSecondAlternative.setText(questionSecondAlternative[position]);
        holder.questionThirdAlternative.setText(questionThirdAlternative[position]);
    }



    @Override
    public int getItemCount() {
        return questionText.length;
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
