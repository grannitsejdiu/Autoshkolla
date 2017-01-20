package co.tenton.admin.autoshkolla.ShenjatPolicit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Shenjat_Policit_RecyclerAdapter extends RecyclerView.Adapter<Shenjat_Policit_RecyclerAdapter.ViewHolder> {

    private String[] shenjat_Policit_Description = {"1. Pershkrimi i pare","2. Pershkrimi i dyte","3. Pershkrimi i trete",
            "4. Pershkrimi i katert","5.Pershkrimi i peste", "6. Pershkrimi i gjaste"};

    private int[] shenjat_Policit_Image = {co.tenton.admin.autoshkolla.R.drawable.imageplaceholder , co.tenton.admin.autoshkolla.R.drawable.imageplaceholder,
            co.tenton.admin.autoshkolla.R.drawable.imageplaceholder, co.tenton.admin.autoshkolla.R.drawable.imageplaceholder, co.tenton.admin.autoshkolla.R.drawable.imageplaceholder, co.tenton.admin.autoshkolla.R.drawable.imageplaceholder};


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(co.tenton.admin.autoshkolla.R.layout.cardview_shenjat_policit, parent,false);
        Shenjat_Policit_RecyclerAdapter.ViewHolder shenjat_PolicitViewHolder =
                new Shenjat_Policit_RecyclerAdapter.ViewHolder(view);
        return shenjat_PolicitViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.shenjat_Policit_Image.setImageResource(shenjat_Policit_Image[position]);
        holder.shenjat_Policit_Description.setText(shenjat_Policit_Description[position]);
    }

    @Override
    public int getItemCount() {
        return shenjat_Policit_Description.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView shenjat_Policit_Image;
        public TextView shenjat_Policit_Description;

        public ViewHolder(View itemView) {
            super(itemView);

            shenjat_Policit_Image = (ImageView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.shenjat_Policit_Image);
            shenjat_Policit_Description = (TextView) itemView.findViewById(co.tenton.admin.autoshkolla.R.id.shenjat_Policit_Description);
        }
    }
}
