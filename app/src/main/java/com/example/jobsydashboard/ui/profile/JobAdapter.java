package com.example.jobsydashboard.ui.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobsydashboard.R;

import java.util.List;

//public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {
//
//    private List<JobItem> jobList;
//
//    public JobAdapter(List<JobItem> jobList) {
//        this.jobList = jobList;
//    }
//
//    public void setJobList(List<JobItem> newJobs) {
//        this.jobList = newJobs;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_item, parent, false);
//        return new JobViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
//        JobItem job = jobList.get(position);
//        holder.jobTitle.setText(job.getTitle());
//        holder.jobPrice.setText(job.getPrice());
//        holder.jobImage.setImageResource(job.getImageResId());
//    }
//
//    @Override
//    public int getItemCount() {
//        return jobList.size();
//    }
//
//    static class JobViewHolder extends RecyclerView.ViewHolder {
//        TextView jobTitle, jobPrice;
//        ImageView jobImage;
//
//        JobViewHolder(View itemView) {
//            super(itemView);
//            jobTitle = itemView.findViewById(R.id.jobTitle);
//            jobPrice = itemView.findViewById(R.id.jobPrice);
//            jobImage = itemView.findViewById(R.id.jobImage);
//        }
//    }
//}
//last code :
//public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {
//    private List<JobItem> jobList;
//
//    public JobAdapter(List<JobItem> jobList) {
//        this.jobList = jobList;
//    }
//
//    public void setJobList(List<JobItem> newList) {
//        this.jobList = newList;
//    }
//
//    @NonNull
//    @Override
//    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_item, parent, false);
//        return new JobViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
//        JobItem job = jobList.get(position);
//        holder.jobTitle.setText(job.getTitle());
//        holder.jobPrice.setText(job.getPrice());
//        holder.jobImage.setImageResource(job.getImageResId());
//    }
//
//    @Override
//    public int getItemCount() {
//        return jobList.size();
//    }
//
//    static class JobViewHolder extends RecyclerView.ViewHolder {
//        TextView jobTitle, jobPrice;
//        ImageView jobImage;
//
//        public JobViewHolder(@NonNull View itemView) {
//            super(itemView);
//            jobTitle = itemView.findViewById(R.id.jobTitle);
//            jobPrice = itemView.findViewById(R.id.jobPrice);
//            jobImage = itemView.findViewById(R.id.jobImage);
//        }
//    }
//}

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.JobViewHolder> {
    private List<Job> jobList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Job job);
    }

    public JobAdapter(List<Job> jobList, OnItemClickListener listener) {
        this.jobList = jobList;
        this.listener = listener;
    }

    public void setJobList(List<Job> newList) {
        this.jobList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_item, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
        Job job = jobList.get(position);
        holder.bind(job, listener);
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    static class JobViewHolder extends RecyclerView.ViewHolder {
        TextView jobTitle, jobPrice;
        ImageView jobImage;

        public JobViewHolder(@NonNull View itemView) {
            super(itemView);
            jobTitle = itemView.findViewById(R.id.jobTitle);
            jobPrice = itemView.findViewById(R.id.jobPrice);
            jobImage = itemView.findViewById(R.id.jobImage);
        }

        public void bind(Job job, OnItemClickListener listener) {
            jobTitle.setText(job.getTitle());
            jobPrice.setText(String.format("Price: $%.2f", job.getPay()));
            jobImage.setImageResource(job.getImageResId());

            itemView.setOnClickListener(v -> listener.onItemClick(job));
        }
    }
}





