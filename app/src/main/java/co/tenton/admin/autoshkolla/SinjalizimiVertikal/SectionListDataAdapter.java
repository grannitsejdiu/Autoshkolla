package co.tenton.admin.autoshkolla.SinjalizimiVertikal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities.BlurRecyclerView_Activity;
import co.tenton.admin.autoshkolla.Models.Sign;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    public List<Sign> signs = new ArrayList<Sign>();
    public Context context;
    public int sgIndex = 0;

    public SectionListDataAdapter(List<Sign> ss, Context c, int subgroupIndex) {
        signs = ss;
        context = c;
        sgIndex = subgroupIndex;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(co.tenton.admin.autoshkolla.R.layout.cardview_list_single, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int position) {
//        SingleItemModel singleItem = itemsList.get(position);

        Sign s = signs.get(position);
        holder.tvTitle.setText(s.name);
//        holder.itemImage.setImageResource(sectionImages[position]);
        Picasso.with(context).load(s.imager.getUrl()).into(holder.itemImage);

    }

    @Override
    public int getItemCount() {
        return signs.size() >= 10 ? 10 : signs.size();
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;
        protected ImageView itemImage;

        public SingleItemRowHolder(final View itemView) {
            super(itemView);

            this.tvTitle = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.tvTitle);
            this.itemImage = (ImageView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.itemImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext().getApplicationContext(), BlurRecyclerView_Activity.class);
                    intent.putExtra("index", sgIndex);
                    intent.putExtra("scrollPosition", getAdapterPosition());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}