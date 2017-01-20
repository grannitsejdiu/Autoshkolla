package co.tenton.admin.autoshkolla;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.tenton.admin.autoshkolla.BlurryBackgrounds_Activities.BlurRecyclerView_Activity;
import co.tenton.admin.autoshkolla.Ligjeratat.Ligjeratat_Activity;
import co.tenton.admin.autoshkolla.Testet.TestResultsFormActivity;


public class HomeTabActivity extends android.support.v4.app.Fragment{

    private CardView cardViewLiteratura;
    private CardView cardViewTeste, cardViewAutoshkollat, ligjet;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(container==null){
            return null;
        }
        //Returning the layout file after inflating
        //Change R.layout.hometab in you classes
        return inflater.inflate(R.layout.hometab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        cardViewLiteratura = (CardView) getView().findViewById(R.id.cardViewLiteratura);
        cardViewLiteratura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Ligjeratat_Activity.class);
                startActivity(intent);
            }
        });

        cardViewTeste = (CardView) getView().findViewById(R.id.cardViewTeste);
        cardViewTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TestetActivity.class);
                startActivity(intent);
            }
        });

        cardViewAutoshkollat = (CardView) getView().findViewById(R.id.cardViewAutoshkollat);
        cardViewAutoshkollat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TestResultsFormActivity.class);
                startActivity(intent);
            }
        });

        ligjet = (CardView) getView().findViewById(R.id.cardViewLigjet);
        ligjet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BlurRecyclerView_Activity.class);
                startActivity(intent);
            }
        });

    }
}
