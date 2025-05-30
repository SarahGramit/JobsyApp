package com.example.jobsydashboard.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.*;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

public class ProfileViewModel extends AndroidViewModel {

    public MutableLiveData<String> companyName = new MutableLiveData<>();
    public MutableLiveData<String> description = new MutableLiveData<>();
    public MutableLiveData<String> contactInfo = new MutableLiveData<>();
    public MutableLiveData<String> ratings = new MutableLiveData<>();

    private final DatabaseReference databaseReference;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();

        if (currentUser == null) {
            auth.signInAnonymously().addOnCompleteListener(task -> {
                if (task.isSuccessful() && auth.getCurrentUser() != null) {
                    loadUserData(auth.getCurrentUser().getUid());
                } else {
                    Toast.makeText(application, "Erreur connexion anonyme", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            loadUserData(currentUser.getUid());
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("users");
    }

    private void loadUserData(String uid) {
        DatabaseReference userRef = databaseReference.child(uid);

        // Tu peux désactiver cette partie si les données sont déjà écrites
        Map<String, String> userData = new HashMap<>();
        userData.put("Company name ", "NAFTAL");
        userData.put("Description", "Entreprise pétrolière algérienne");
        userData.put("contact info ", "kkkkkk");
        userData.put("ratings", "★★★★");

        userRef.setValue(userData).addOnSuccessListener(aVoid -> {
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    companyName.setValue(snapshot.child("Company name ").getValue(String.class));
                    description.setValue(snapshot.child("Description").getValue(String.class));
                    contactInfo.setValue(snapshot.child("contact info ").getValue(String.class));
                    ratings.setValue(snapshot.child("ratings").getValue(String.class));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getApplication(), "Erreur de lecture", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}

