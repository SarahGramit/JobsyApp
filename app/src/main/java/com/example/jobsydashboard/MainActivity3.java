package com.example.jobsydashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NotificationAdapter adapter;
    private List<Notification> notificationList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3); // This should match your XML file name
        recyclerView = findViewById(R.id.notificationsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Données fictives (à remplacer par Firebase si tu veux)
        notificationList = new ArrayList<>();
        notificationList.add(new Notification("baseline_circle_notifications_24", "Nom", "Hello sir , i want.."));
        notificationList.add(new Notification("baseline_circle_notifications_24", "Name", "Vous avez..."));

        adapter = new NotificationAdapter(this, notificationList);
        recyclerView.setAdapter(adapter);
    }
}