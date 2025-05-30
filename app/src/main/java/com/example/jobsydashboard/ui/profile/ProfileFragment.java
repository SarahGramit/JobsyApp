package com.example.jobsydashboard.ui.profile;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.jobsydashboard.databinding.FragmentProfileBinding;




public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        profileViewModel.companyName.observe(getViewLifecycleOwner(), name -> {
            binding.companyname.setText(name);
            binding.companyname2.setText(name);
        });

        profileViewModel.description.observe(getViewLifecycleOwner(), desc -> {
            binding.description.setText(desc);
            binding.description2.setText(desc);
        });

        profileViewModel.contactInfo.observe(getViewLifecycleOwner(), info ->
                binding.info.setText(info));

        profileViewModel.ratings.observe(getViewLifecycleOwner(), rate ->
                binding.ratings.setText(rate));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
