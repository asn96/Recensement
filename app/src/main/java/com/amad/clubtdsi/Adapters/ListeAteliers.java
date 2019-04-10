package com.amad.clubtdsi.Adapters;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.amad.clubtdsi.Models.Atelier;
import com.amad.clubtdsi.Models.personne;
import com.amad.clubtdsi.R;

import java.util.ArrayList;

public class ListeAteliers extends BaseAdapter {
    private ArrayList<Atelier> ateliers;
    private FragmentActivity activity;

    public ListeAteliers() {
    }

    public ListeAteliers(ArrayList<Atelier> ateliers, FragmentActivity activity) {
        this.ateliers = ateliers;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return ateliers.size();
    }

    @Override
    public Object getItem(int position) {
        return ateliers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view =  LayoutInflater.from(activity.getApplicationContext()).inflate(R.layout.listeateliers,viewGroup,false);
        ((TextView)view.findViewById(R.id.nom_atelier)).setText(ateliers.get(position).getSujet());
        ((TextView)view.findViewById(R.id.lieu_atelier)).setText(ateliers.get(position).getLieu());
        return view;
    }
}
