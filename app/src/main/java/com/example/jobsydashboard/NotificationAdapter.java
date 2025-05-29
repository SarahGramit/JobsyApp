package com.example.jobsydashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private Context context;
    private List<Notification> notificationList;

    public NotificationAdapter(Context context, List<Notification> notificationList) {
        this.context = context;
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Notification notif = notificationList.get(position);

        int iconResId = context.getResources().getIdentifier(notif.getNotifIcon(), "drawable", context.getPackageName());
        if (iconResId != 0) {
            holder.icon.setImageResource(iconResId);
        } else {
            holder.icon.setImageResource(R.drawable.ic_launcher_foreground); // fallback
        }

        holder.title.setText(notif.getTitle());
        holder.description.setText(notif.getDescription());

        // Gestion des clics
        holder.acceptButton.setOnClickListener(v -> {
            // Action d'acceptation
        });

        holder.refuseButton.setOnClickListener(v -> {
            // Action de refus
        });
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title, description;
        Button acceptButton, refuseButton;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.notifIcon);
            title = itemView.findViewById(R.id.titleId);
            description = itemView.findViewById(R.id.descId);
            acceptButton = itemView.findViewById(R.id.btn_1);
            refuseButton = itemView.findViewById(R.id.btn_2);
        }
    }
}
