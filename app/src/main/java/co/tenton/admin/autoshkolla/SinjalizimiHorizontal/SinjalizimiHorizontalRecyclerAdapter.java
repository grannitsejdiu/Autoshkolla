package co.tenton.admin.autoshkolla.SinjalizimiHorizontal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import co.tenton.admin.autoshkolla.Models.Sign;
import co.tenton.admin.autoshkolla.R;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class SinjalizimiHorizontalRecyclerAdapter extends RecyclerView.Adapter<SinjalizimiHorizontalRecyclerAdapter.ViewHolder> {

    private List<Sign> signs = new ArrayList<>();
    private Context context;

    public  SinjalizimiHorizontalRecyclerAdapter(List<Sign> s, Context c){
        signs = s;
        context = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(co.tenton.admin.autoshkolla.R.layout.cardview_sinjalizimi_horizontal, parent,false);
        SinjalizimiHorizontalRecyclerAdapter.ViewHolder sinjalizimiHorizontalviewHolder =
                new SinjalizimiHorizontalRecyclerAdapter.ViewHolder(view);
        return sinjalizimiHorizontalviewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Sign s = signs.get(position);

        holder.sinjalizimiHorizontalDescription.setText(s.description);

        holder.sinjalizimiHorizontalImage.setImageResource(co.tenton.admin.autoshkolla.R.drawable.imageplaceholder);
        if ((s.imager != null) && (!s.imager.link.equals("")))
        {
            holder.shProgressBar.setVisibility(View.VISIBLE);
            Picasso.with(context).load(s.imager.getUrl()).into(holder.sinjalizimiHorizontalImage, new Callback() {
                @Override
                public void onSuccess() {
                    holder.shProgressBar.setVisibility(View.GONE);
                }

                @Override
                public void onError() {
                    holder.shProgressBar.setVisibility(View.GONE);
                    holder.sinjalizimiHorizontalImage.setImageResource(R.drawable.error_image);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return signs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView sinjalizimiHorizontalImage;
        public TextView sinjalizimiHorizontalDescription;
        ProgressBar shProgressBar;

        public ViewHolder(View itemView) {
            super(itemView);

            sinjalizimiHorizontalImage = (ImageView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.sinjalizimitHorizontalImage);
            sinjalizimiHorizontalDescription = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.sinjalizimitHorizontalDescription);
            shProgressBar = (ProgressBar) itemView.findViewById(R.id.shProgressBar);
        }
    }
}
