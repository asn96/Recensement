package com.amad.clubtdsi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.amad.clubtdsi.Adapters.ListeParticipants;
import com.amad.clubtdsi.Metiers.clubmetier;
import com.amad.clubtdsi.Models.personne;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;



public class participant extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    static ArrayList<personne> participants;
    private ListView listView;
    private TextView nombre;

    public participant() {
        // Required empty public constructor
    }
/*

    */
/*
    // TODO: Rename and change types and number of parameters
    public static participant newInstance(String param1, String param2) {
        participant fragment = new participant();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_participant, container, false);

        participants = new ArrayList<>();
        listView = (ListView)view.findViewById(R.id.list_participants);
        nombre = (TextView)view.findViewById(R.id.list_participants_nombre);
        participants.clear();
        clubmetier.myRefp.keepSynced(true);
        clubmetier.myRefp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                while ((iterator.hasNext())) {
                    personne p = iterator.next().getValue(personne.class);
                        participants.add(p);
                }
                ((ListeParticipants)(((ListView)view.findViewById(R.id.list_participants)).getAdapter())).notifyDataSetChanged();
                int total_participant = participants.size();

                nombre.setText(total_participant+"");
                total_participant = 0;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ((ListView)view.findViewById(R.id.list_participants)).setAdapter(new ListeParticipants(participants, getActivity()));


        return view;
    }

}
