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


//
//public class AddFragment extends Fragment {
//
//    private FragmentAddBinding binding;
//    private AddViewModel addViewModel;
//
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//
//        binding = FragmentAddBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        // ViewModels
//        addViewModel = new ViewModelProvider(this).get(AddViewModel.class);
//
//
//        // Spinner
//        String[] categories = {"Engineering", "Healthcare", "Education", "Finance", "Retail", "IT"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                requireContext(),
//                android.R.layout.simple_spinner_item,
//                categories
//        );
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        binding.spinnerCategory.setAdapter(adapter);
//
//        binding.btnCancel.setOnClickListener(v -> requireActivity().onBackPressed());
//
//        binding.btnCreateJob.setOnClickListener(v -> {
//            Toast.makeText(getContext(), "Job created successfully!", Toast.LENGTH_SHORT).show();
//        });
//
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
public class AddFragment extends Fragment {

    private FragmentAddBinding binding;
    private AddViewModel addViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAddBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        addViewModel = new ViewModelProvider(requireActivity()).get(AddViewModel.class);

        // Spinner : catégories
        String[] categories = {"Engineering", "Healthcare", "Education", "Finance", "Retail", "IT"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                categories
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCategory.setAdapter(adapter);

        // Bouton Annuler
        binding.btnCancel.setOnClickListener(v -> requireActivity().onBackPressed());

        // Bouton Créer
        binding.btnCreateJob.setOnClickListener(v -> {
            String id = UUID.randomUUID().toString();
            String title = binding.editTitle.getText().toString();
            String description = binding.editDescription.getText().toString();
            String location = binding.editLocation.getText().toString();
            String payStr = binding.editPayRate.getText().toString();
            String companyName = binding.editCompanyName.getText().toString();
            String duration = binding.editDuration.getText().toString();
            String category = binding.spinnerCategory.getSelectedItem().toString();
            double companyRating = binding.ratingBarCompany.getRating();

            if (title.isEmpty() || description.isEmpty() || location.isEmpty() || payStr.isEmpty()) {
                Toast.makeText(getContext(), "Please fill in all required fields", Toast.LENGTH_SHORT).show();
                return;
            }

            double pay;
            try {
                pay = Double.parseDouble(payStr);
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Invalid pay rate", Toast.LENGTH_SHORT).show();
                return;
            }

            String employerId = "EMP123"; // à remplacer si tu veux
            int imageResId = R.drawable.uiux; // Icône par défaut, à adapter

            Job newJob = new Job(id, title, employerId, pay, imageResId);
            newJob.setDescription(description);
            newJob.setLocation(location);
            newJob.setCategory(category);
            newJob.setCompanyName(companyName);
            newJob.setDuration(duration);
            newJob.setCompanyRating(companyRating);

            addViewModel.setJob(newJob);

            Toast.makeText(getContext(), "Job created!", Toast.LENGTH_SHORT).show();
            requireActivity().onBackPressed();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}



