package co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import co.tenton.admin.autoshkolla.Models.Sign;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class SinjalizimiVertikalGrid_Adapter extends RecyclerView.Adapter<SinjalizimiVertikalGrid_Adapter.ViewHolder> {


    public List<Sign> signs = new ArrayList<>();
    public Context context;
    public int sgIndex = 0;
    public int gIndex = 0;

    public SinjalizimiVertikalGrid_Adapter(List<Sign> ss, Context c, int subgroupIndex, int groupIndex){
        signs = ss;
        context = c;
        sgIndex = subgroupIndex;
        gIndex = groupIndex;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(co.tenton.admin.autoshkolla.R.layout.cardview_list_single, null);
        SinjalizimiVertikalGrid_Adapter.ViewHolder mh = new SinjalizimiVertikalGrid_Adapter.ViewHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Sign s = signs.get(position);

        holder.tvTitle.setText(s.name);
        holder.itemImage.setImageResource(co.tenton.admin.autoshkolla.R.drawable.imageplaceholder);
        if (s.imager != null) {
            Picasso.with(context).load(s.imager.getUrl()).into(holder.itemImage);
        }
    }

    @Override
    public int getItemCount() {
        return signs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView tvTitle;
         ImageView itemImage;
        public ViewHolder(final View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.tvTitle);
            itemImage = (ImageView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.itemImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext().getApplicationContext(),BlurRecyclerView_Activity.class);
                    intent.putExtra("index", sgIndex);
                    intent.putExtra("groupIndex", gIndex);
                    intent.putExtra("scrollPosition", getAdapterPosition());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
