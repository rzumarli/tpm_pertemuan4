package com.example.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeroesFragment extends Fragment {

    private RecyclerView rvHero;

    public HeroesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_heroes, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvHero = view.findViewById(R.id.activitymain_rv);
        rvHero.setHasFixedSize(true);

        rvHero.setLayoutManager(new LinearLayoutManager(view.getContext())); // Memilih tipe Layout
        HeroesAdapter heroesAdapter = new HeroesAdapter(view.getContext()); // Memnaggil Class Adapter

        heroesAdapter.setHeroesList(HeroesData.getHeroList()); // Mengambil data yang ada pada adapter

        rvHero.setAdapter(heroesAdapter);
    }
}
