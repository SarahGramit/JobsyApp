package com.example.jobsydashboard.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.jobsydashboard.databinding.FragmentAddBinding;

import android.widget.ArrayAdapter;
import com.example.jobsydashboard.R;

import java.util.UUID;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;



public class AddFragment extends Fragment {

    private FragmentAddBinding binding;
    private AddViewModel addViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAddBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // ViewModels
        addViewModel = new ViewModelProvider(this).get(AddViewModel.class);


        // Spinner
        String[] categories = {"Engineering", "Healthcare", "Education", "Finance", "Retail", "IT"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                categories
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCategory.setAdapter(adapter);

        binding.btnCancel.setOnClickListener(v -> requireActivity().onBackPressed());

        binding.btnCreateJob.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Job created successfully!", Toast.LENGTH_SHORT).show();
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

