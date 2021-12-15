package com.amad.clubtdsi.Metiers;


import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayDeque;

public class clubmetier {

    static final FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static final DatabaseReference myRefp = database.getReferenceFromUrl("https://clubtdsi.firebaseio.com/club_participant_jls_e3");
    public static final DatabaseReference myRefa = database.getReferenceFromUrl("https://clubtdsi.firebaseio.com/club_atelier_jls_e3");


}
