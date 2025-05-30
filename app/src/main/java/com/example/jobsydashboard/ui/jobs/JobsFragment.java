package com.example.jobsydashboard.ui.jobs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobsydashboard.MainActivity2;
import com.example.jobsydashboard.R;

import java.util.ArrayList;
import java.util.List;

//public class ProfileFragment extends Fragment {
//
//    private FragmentProfileBinding binding;
//    private JobAdapter jobAdapter;
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//
//        ProfileViewModel viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
//
//        binding = FragmentProfileBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        // Setup RecyclerView
//        binding.jobRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        jobAdapter = new JobAdapter(new ArrayList<>());
//        binding.jobRecyclerView.setAdapter(jobAdapter);
//
//        // Observe job list
//        viewModel.getJobList().observe(getViewLifecycleOwner(), jobs -> jobAdapter.setJobList(jobs));
//
//        return root;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
//}
// old

import androidx.annotation.Nullable;

//public class ProfileFragment extends Fragment {
//
//    private RecyclerView jobRecyclerView;
//    private JobAdapter jobAdapter;
//    private List<Job> fullJobList;
//    private TextView seeAllText;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        View root = inflater.inflate(R.layout.fragment_profile, container, false);
//
//        jobRecyclerView = root.findViewById(R.id.jobRecyclerView);
////        seeAllText = root.findViewById(R.id.seeAllText);
//
//        fullJobList = getAllJobs();
//
//        // Show only the first 2 jobs initially
//        List<Job> limitedList = fullJobList.subList(0, Math.min(2, fullJobList.size()));
//
//        jobAdapter = new JobAdapter(limitedList, job -> {
//            Intent intent = new Intent(getContext(), MainActivity2.class);
//            intent.putExtra("job_data", job);
//            startActivity(intent);
//        });
//
//        jobRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        jobRecyclerView.setAdapter(jobAdapter);
//
//        seeAllText.setOnClickListener(v -> {
//            // Replace the adapter with the full list when "See All" is clicked
//            jobAdapter = new JobAdapter(fullJobList, job -> {
//                Intent intent = new Intent(getContext(), MainActivity2.class);
//                intent.putExtra("job_data", job);
//                startActivity(intent);
//            });
//            jobRecyclerView.setAdapter(jobAdapter);
//            seeAllText.setVisibility(View.GONE);
//        });
//
//        return root;
//    }
//
//    private List<Job> getAllJobs() {
//        List<Job> jobs = new ArrayList<>();
//        jobs.add(new Job("123", "Développeur Android", "001", 200.0, R.drawable.uiux));
//        jobs.add(new Job("124", "UI/UX Designer", "002", 500.0, R.drawable.uiux));
//        jobs.add(new Job("125", "Backend Engineer", "003", 450.0, R.drawable.uiux));
//        jobs.add(new Job("126", "Data Analyst", "004", 300.0, R.drawable.uiux));
//        return jobs;
//    }
//}
//
//
//
public class JobsFragment extends Fragment {

    private RecyclerView jobRecyclerView;
    private JobAdapter jobAdapter;
    private List<Job> fullJobList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_jobs, container, false);

        jobRecyclerView = root.findViewById(R.id.jobRecyclerView);

        fullJobList = getAllJobs();

        // Affiche uniquement les 2 premiers jobs
        List<Job> limitedList = fullJobList.subList(0, Math.min(2, fullJobList.size()));

        jobAdapter = new JobAdapter(limitedList, job -> {
            Intent intent = new Intent(getContext(), MainActivity2.class);
            intent.putExtra("job_data", job);
            startActivity(intent);
        });

        jobRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        jobRecyclerView.setAdapter(jobAdapter);

        return root;
    }

    private List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("123", "Développeur Android", "001", 200.0, R.drawable.uiux));
        jobs.add(new Job("124", "UI/UX Designer", "002", 500.0, R.drawable.uiux));
        jobs.add(new Job("125", "Backend Engineer", "003", 450.0, R.drawable.uiux));
        jobs.add(new Job("126", "Data Analyst", "004", 300.0, R.drawable.uiux));
        return jobs;
    }
}






//public class ProfileFragment extends Fragment {
//
//    private RecyclerView jobRecyclerView;
//    private JobAdapter jobAdapter;
//    private List<JobItem> fullJobList;
//    private TextView seeAllText;
//    private boolean isShowingAll = false;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View root = inflater.inflate(R.layout.fragment_profile, container, false);
//
//        jobRecyclerView = root.findViewById(R.id.jobRecyclerView);
//        seeAllText = root.findViewById(R.id.seeAllText);
//        jobRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        fullJobList = getJobData(); // your method to load all jobs
//
//        // Initially show only first 3 jobs
//        List<JobItem> initialList = new ArrayList<>(fullJobList.subList(0, Math.min(3, fullJobList.size())));
//        jobAdapter = new JobAdapter(initialList);
//        jobRecyclerView.setAdapter(jobAdapter);
//
//        seeAllText.setOnClickListener(v -> {
//            if (!isShowingAll) {
//                jobAdapter.setJobList(fullJobList);
//                jobAdapter.notifyDataSetChanged();
//                isShowingAll = true;
//            }
//        });
//
//        return root;
//    }
//
//    private List<JobItem> getJobData() {
//        List<JobItem> jobs = new ArrayList<>();
//        jobs.add(new JobItem("Designer", "$50/hr", R.drawable.uiux));
//        jobs.add(new JobItem("Web Developer", "$40/hr", R.drawable.uiux));
//        jobs.add(new JobItem("Data Analyst", "$45/hr", R.drawable.uiux));
//        jobs.add(new JobItem("Engineer", "$55/hr", R.drawable.uiux));
//        // Add more jobs as needed
//        return jobs;
//    }
//}


