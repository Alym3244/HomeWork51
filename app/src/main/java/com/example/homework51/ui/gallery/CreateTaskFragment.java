package com.example.homework51.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.homework51.R;
import com.example.homework51.databinding.FragmentCreateTaskBinding;
import com.example.homework51.ui.gallery.utils.Constance;

import org.jetbrains.annotations.NotNull;


public class CreateTaskFragment extends Fragment {
    private FragmentCreateTaskBinding binding;
    String userTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTask = binding.taskEd.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString(Constance.USER_TASK, userTask);
                navController.popBackStack();
                navController.navigate(R.id.nav_home, bundle);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}