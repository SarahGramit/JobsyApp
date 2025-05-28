package com.example.jobsydashboard.ui.messages;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jobsydashboard.R;

import java.util.ArrayList;
import java.util.List;

public class MessagesViewModel extends ViewModel {

    // Liste observable des notifications
    private final MutableLiveData<List<Notification>> notificationsLiveData = new MutableLiveData<>();

    public MessagesViewModel() {
        loadNotifications();
    }

    // Méthode pour charger les notifications (mock data)
    private void loadNotifications() {
        List<Notification> notifList = new ArrayList<>();

        notifList.add(new Notification("Job Alert", "New job posted near you", "7:00 AM", R.drawable.notification));
        notifList.add(new Notification("Interview", "Interview scheduled for Monday", "Yesterday", R.drawable.notification));
        notifList.add(new Notification("Message", "Company replied to your application", "2 days ago", R.drawable.notification));

        notificationsLiveData.setValue(notifList);
    }

    // Getter LiveData
    public LiveData<List<Notification>> getNotifications() {
        return notificationsLiveData;
    }
}
