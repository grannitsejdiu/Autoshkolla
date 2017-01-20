package co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import co.tenton.admin.autoshkolla.Models.Subgroup;
import co.tenton.admin.autoshkolla.Models.This;

public class BlurRecyclerView_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    Button backBtnBlurRecyclerViewForm;
    RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(co.tenton.admin.autoshkolla.R.layout.activity_blur_recycler_view_);

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, co.tenton.admin.autoshkolla.R.color.transparentBackground));
        }

        backBtnBlurRecyclerViewForm = (Button) findViewById(co.tenton.admin.autoshkolla.R.id.backButtonBlurRecyclerView);
        backBtnBlurRecyclerViewForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlurRecyclerView_Activity.super.onBackPressed();
            }
        });

        relativeLayout = (RelativeLayout) findViewById(co.tenton.admin.autoshkolla.R.id.activity_blur_recycler_view_);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlurRecyclerView_Activity.super.onBackPressed();
            }
        });

        recyclerView= (RecyclerView) findViewById(co.tenton.admin.autoshkolla.R.id.recycler_view_Blur);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);


        int index = getIntent().getIntExtra("index", 0);
        Subgroup s = This.groups.get(2).subgroups().get(index);
        int scrollPostion = getIntent().getIntExtra("scrollPosition",0);

        adapter = new BlurRecyclerView_Adapter(s.signs, getApplicationContext(),this);
        recyclerView.setAdapter(adapter);

        recyclerView.scrollToPosition(scrollPostion);

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
