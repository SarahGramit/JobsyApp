package com.example.jobsydashboard.ui.messages;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jobsydashboard.R;

import java.util.List;

public class MessagesFragment extends Fragment {

    private MessagesViewModel messagesViewModel;
    private RecyclerView recyclerView;
    private NotificationsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_messages, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewNotifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new NotificationsAdapter();
        recyclerView.setAdapter(adapter);

        // Obtenir ViewModel
        messagesViewModel = new ViewModelProvider(this).get(MessagesViewModel.class);

        // Observer les données
        messagesViewModel.getNotifications().observe(getViewLifecycleOwner(), new Observer<List<Notification>>() {
            @Override
            public void onChanged(List<Notification> notifications) {
                adapter.setNotificationList(notifications);
            }
        });

        return root;
    }
}

