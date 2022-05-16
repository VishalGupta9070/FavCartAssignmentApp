package com.example.assignmentapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.assignmentapp.FruitAdapter;
import com.example.assignmentapp.R;
import com.example.assignmentapp.databinding.FragmentHomeBinding;
import com.example.assignmentapp.ui.FruitModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ArrayList<FruitModel> models = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater);
        models.add(new FruitModel("Tomato", "45", "60", "15", 1, getResources().getDrawable(R.drawable.tomate)));
        models.add(new FruitModel("Apple", "45", "60", "15", 1, getResources().getDrawable(R.drawable.apple)));
        models.add(new FruitModel("Oats", "45", "60", "15", 1, getResources().getDrawable(R.drawable.oats)));
        models.add(new FruitModel("Barley", "45", "60", "15", 1, getResources().getDrawable(R.drawable.grains)));
        FruitAdapter adapter = new FruitAdapter(getContext(),models);
        binding.fruitRV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.fruitRV.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}