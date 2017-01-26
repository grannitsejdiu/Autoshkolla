package co.tenton.admin.autoshkolla.Ilustrimet;

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


public class Ilustrimet_RecyclerAdapter extends RecyclerView.Adapter<Ilustrimet_RecyclerAdapter.ViewHolder> {

    private List<Sign> signs = new ArrayList<>();
    private Context context;
    public Ilustrimet_RecyclerAdapter(List<Sign> ss, Context ctx){
        signs = ss;
        context = ctx;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(co.tenton.admin.autoshkolla.R.layout.cardview_ilustrimet, parent,false);
        Ilustrimet_RecyclerAdapter.ViewHolder ilustrimetViewHolder =
                new Ilustrimet_RecyclerAdapter.ViewHolder(view);
        return ilustrimetViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Sign s = signs.get(position);

        holder.cardviewItemTitle.setText(s.name);
        holder.getCardviewItemDescription.setText("https://youtu.be/" +  s.description);
        holder.cardviewItemImage.setImageResource(co.tenton.admin.autoshkolla.R.color.titleColor);

        if (s.imager != null) {
            if (!s.imager.link.equals("")) {
                Picasso.with(context).load(s.imager.getUrl()).into(holder.cardviewItemImage);
            }
        }
    }

    @Override
    public int getItemCount() {
        return signs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardviewItemImage;
        public TextView cardviewItemTitle;
        public TextView getCardviewItemDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            cardviewItemImage = (ImageView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.ilustrimet_Image);
            cardviewItemTitle = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.ilustrimet_Title);
            getCardviewItemDescription = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.ilustrimet_Description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(view.getContext().getApplicationContext(), Ilustrimet_Webview.class);
                    intent.putExtra("index", getAdapterPosition());
                    view.getContext().startActivity(intent);

//                   view.getContext().startActivity(new Intent(Intent.ACTION_VIEW,
//                           Uri.parse("https://www.youtube.com/watch?v=N7VCLNBNJQs")));
                }
            });
        }
    }
}
