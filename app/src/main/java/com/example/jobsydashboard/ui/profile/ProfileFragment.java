package com.example.jobsydashboard.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobsydashboard.R;
import com.example.jobsydashboard.databinding.FragmentAddBinding;
import com.example.jobsydashboard.databinding.FragmentProfileBinding;
import com.example.jobsydashboard.ui.add.AddViewModel;

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
public class ProfileFragment extends Fragment {

    private RecyclerView jobRecyclerView;
    private JobAdapter jobAdapter;
    private List<JobItem> fullJobList;
    private TextView seeAllText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        jobRecyclerView = root.findViewById(R.id.jobRecyclerView);
        seeAllText = root.findViewById(R.id.seeAllText);

        // Liste complète
        fullJobList = getAllJobs();

        // Affichage limité au départ
        List<JobItem> limitedList = fullJobList.subList(0, Math.min(2, fullJobList.size()));

        jobAdapter = new JobAdapter(limitedList);
        jobRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        jobRecyclerView.setAdapter(jobAdapter);

        // Click sur "See All"
        seeAllText.setOnClickListener(v -> {
            jobAdapter.setJobList(fullJobList);
            jobAdapter.notifyDataSetChanged();
            seeAllText.setVisibility(View.GONE);
        });

        return root;
    }

    private List<JobItem> getAllJobs() {
        List<JobItem> jobs = new ArrayList<>();
        jobs.add(new JobItem("Développeur Android", "$1000", R.drawable.uiux));
        jobs.add(new JobItem("UI/UX Designer", "$800", R.drawable.uiux));
        jobs.add(new JobItem("Backend Engineer", "$1200", R.drawable.uiux));
        jobs.add(new JobItem("Data Analyst", "$950", R.drawable.uiux));
        // Ajoute autant de jobs que tu veux
        return jobs;
    }
}

