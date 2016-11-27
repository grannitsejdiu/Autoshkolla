package com.example.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.admin.autoshkolla.R;
import com.example.admin.autoshkolla.ShenjatPolicit.Shenjat_Policit_RecyclerAdapter;

public class BlurRecyclerView_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button backBtnBlurRecyclerViewForm;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blur_recycler_view_);

        backBtnBlurRecyclerViewForm = (Button) findViewById(R.id.backButtonBlurRecyclerView);
        backBtnBlurRecyclerViewForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlurRecyclerView_Activity.super.onBackPressed();
            }
        });

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_blur_recycler_view_);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlurRecyclerView_Activity.super.onBackPressed();
            }
        });

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view_Blur);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BlurRecyclerView_Adapter();
        recyclerView.setAdapter(adapter);

        recyclerView.scrollToPosition(0);

        final LinearSnapHelper helper = new LinearSnapHelper(){
            @Override
            public int findTargetSnapPosition(final RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                final View centerView = findSnapView(layoutManager);
                if (centerView == null) {
                    return RecyclerView.NO_POSITION;
                }

                final int position = layoutManager.getPosition(centerView);
                int targetPosition = -1;
                if (layoutManager.canScrollHorizontally()) {
                    if (velocityX < 0) {
                        targetPosition = position - 1;
                    } else {
                        targetPosition = position + 1;
                    }
                }
                final int firstItem = 0;
                final int lastItem = layoutManager.getItemCount() - 1;
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));

                return targetPosition;

            }
        };
        helper.attachToRecyclerView(recyclerView);
    }
}
