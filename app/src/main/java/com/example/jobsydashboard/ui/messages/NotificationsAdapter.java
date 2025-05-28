package com.example.jobsydashboard.ui.messages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobsydashboard.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.NotificationViewHolder> {

    private List<Notification> notificationList = new ArrayList<>();

    public void setNotificationList(List<Notification> list) {
        this.notificationList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_item, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        Notification notif = notificationList.get(position);
        holder.title.setText(notif.getTitle());
        holder.description.setText(notif.getDescription());
        holder.time.setText(notif.getTime());
        holder.icon.setImageResource(notif.getIconResId());
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    static class NotificationViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title, description, time;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.notifIcon);
            title = itemView.findViewById(R.id.titleId);
            description = itemView.findViewById(R.id.descId);
            time = itemView.findViewById(R.id.timeId);
        }
    }
}


