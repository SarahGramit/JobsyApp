package com.example.jobsydashboard.ui.jobs;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jobsydashboard.R;

import java.util.ArrayList;
import java.util.List;

public class JobsViewModel extends ViewModel {
    private final MutableLiveData<List<Job>> jobList = new MutableLiveData<>();

    public JobsViewModel() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("001", "UI/UX Designer", "emp001", 500.0, R.drawable.uiux));
        jobs.add(new Job("002", "Android Dev", "emp002", 600.0, R.drawable.uiux));
        jobList.setValue(jobs);
    }

    public LiveData<List<Job>> getJobList() {
        return jobList;
    }
}


