package com.example.jobsydashboard.ui.add;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddViewModel extends ViewModel {

    private final MutableLiveData<Job> createdJob = new MutableLiveData<>();

    public void setJob(Job job) {
        createdJob.setValue(job);
    }

    public LiveData<Job> getJob() {
        return createdJob;
    }
}
