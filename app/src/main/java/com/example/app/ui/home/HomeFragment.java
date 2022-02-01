package com.example.app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.databinding.FragmentHomeBinding;
import com.example.app.network.AnnounceCardRecyclerAdapter;
import com.example.app.network.AnnounceEntry;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //Recycler
        RecyclerView recyclerView = view.findViewById(R.id.announces_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        AnnounceCardRecyclerAdapter adapter = new AnnounceCardRecyclerAdapter(
                AnnounceEntry.initAnnounceEntryList(getResources()));
        recyclerView.setAdapter(adapter);

        int largePadding = getResources().getDimensionPixelSize(R.dimen.announce_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.announce_grid_spacing_small);
        recyclerView.addItemDecoration(new AnnounceGridItemDecoration(largePadding, smallPadding));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}