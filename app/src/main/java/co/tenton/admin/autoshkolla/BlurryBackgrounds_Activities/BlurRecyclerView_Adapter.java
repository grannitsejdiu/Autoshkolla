package co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import co.tenton.admin.autoshkolla.Models.Sign;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class BlurRecyclerView_Adapter extends RecyclerView.Adapter<BlurRecyclerView_Adapter.ViewHolder> {

    public List<Sign> signs = new ArrayList<>();
    public Context context;
    BlurRecyclerView_Activity activity;

    public  BlurRecyclerView_Adapter(List<Sign> ss, Context c,BlurRecyclerView_Activity activity){
        signs = ss;
        context = c;
        this.activity = activity;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(co.tenton.admin.autoshkolla.R.layout.cardview_shenjat_policit, parent,false);
        BlurRecyclerView_Adapter.ViewHolder blurViewHolder = new BlurRecyclerView_Adapter.ViewHolder(view);
        return blurViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Sign s = signs.get(position);
        if(holder.title == null){
            holder.title.setVisibility(View.GONE);
        }else {
            holder.title.setText(s.name);
        }

        holder.imageView.setImageResource(co.tenton.admin.autoshkolla.R.drawable.imageplaceholder);
        if(holder.description == null){
            holder.description.setText(" ");
        }else {
            holder.description.setText(s.description);
        }

        if (s.imager != null){
            Picasso.with(context).load(s.imager.getUrl()).into(holder.imageView);
        }

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onBackPressed();
            }
        });
    }

    @Override
    public int getItemCount() {
        return signs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout parent;
        public ImageView imageView;
        public TextView title;
        public TextView description;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.shenjat_Policit_Image);
            title = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.shenjat_Policit_Title);
            description = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.shenjat_Policit_Description);
            parent = (LinearLayout) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.card_view_parent);
        }
    }
}
