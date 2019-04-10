package com.amad.clubtdsi.Adapters;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.amad.clubtdsi.Models.personne;
import com.amad.clubtdsi.R;

import java.util.ArrayList;

public class ListeParticipants extends BaseAdapter {
    private ArrayList<personne> personnes;
    private FragmentActivity activity;

    public ListeParticipants() {
    }

    public ListeParticipants(ArrayList<personne> personnes, FragmentActivity activity) {
        this.personnes = personnes;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return personnes.size();
    }

    @Override
    public Object getItem(int position) {
        return personnes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view =  LayoutInflater.from(activity.getApplicationContext()).inflate(R.layout.listeparticipants,viewGroup,false);
        ((TextView)view.findViewById(R.id.nom_participant)).setText(personnes.get(position).getNom_complet());
        ((TextView)view.findViewById(R.id.tel_participant)).setText(personnes.get(position).getTelephone());
        return view;
    }
}
