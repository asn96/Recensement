package com.amad.clubtdsi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.amad.clubtdsi.Adapters.ListeAteliers;
import com.amad.clubtdsi.Metiers.clubmetier;
import com.amad.clubtdsi.Models.Atelier;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;


public class atelier extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    static ArrayList<Atelier> ateliers;
    private ListView listView;
    private TextView nombre;


    public atelier() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_atelier, container, false);

        ateliers = new ArrayList<>();
        listView = (ListView)view.findViewById(R.id.list_ateliers);
        nombre = (TextView)view.findViewById(R.id.list_atelier_nombre);
        ateliers.clear();
        clubmetier.myRefa.keepSynced(true);
        clubmetier.myRefa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                while ((iterator.hasNext())) {
                    Atelier a = iterator.next().getValue(Atelier.class);
                    ateliers.add(a);
                }
                ((ListeAteliers)(((ListView)view.findViewById(R.id.list_ateliers)).getAdapter())).notifyDataSetChanged();
                int total_atelier = ateliers.size();

                nombre.setText(total_atelier+"");
                total_atelier = 0;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ((ListView)view.findViewById(R.id.list_ateliers)).setAdapter(new ListeAteliers( ateliers, getActivity()));


        return view;
    }

}
