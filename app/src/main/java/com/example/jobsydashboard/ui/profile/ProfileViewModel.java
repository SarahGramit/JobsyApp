package com.example.jobsydashboard.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jobsydashboard.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileViewModel extends ViewModel {
    private final MutableLiveData<List<JobItem>> jobList = new MutableLiveData<>();

    public ProfileViewModel() {
        List<JobItem> jobs = new ArrayList<>();
        jobs.add(new JobItem("UI/UX Designer", "$500", R.drawable.uiux));
        jobs.add(new JobItem("Android Dev", "$600", R.drawable.uiux));
        jobList.setValue(jobs);
    }

    public LiveData<List<JobItem>> getJobList() {
        return jobList;
    }
}

