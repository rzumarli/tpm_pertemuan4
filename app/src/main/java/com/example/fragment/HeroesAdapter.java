package com.example.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fragment.DetailHeroes;
import com.example.fragment.R;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    private ArrayList<Heroes> heroesList = new ArrayList<>();
    private Context context;

    public HeroesAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Heroes> getHeroesList() {
        return heroesList;
    }

    public void setHeroesList(ArrayList<Heroes> heroesList) {
        this.heroesList = heroesList;
    }

    @NonNull
    @Override
    // Menentukan mau memakai template item yang mana
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    // Proses untuk memasukkan ke list view/tampilan
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder holder, final int position) {
        holder.tvName.setText(getHeroesList().get(position).getHeroName());
//        holder.tvDetail.setText(getHeroesList().get(position).getHeroDetail());
        Glide.with(context).load(getHeroesList().get(position).getHeroImage()).into(holder.ivHero);
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailHeroes.class);
                intent.putExtra("Name",getHeroesList().get(position).getHeroName());
                intent.putExtra("Image",getHeroesList().get(position).getHeroImage());
                intent.putExtra("Des",getHeroesList().get(position).getHeroDetail());
                context.startActivity(intent);

            }
        });

    }

    @Override
    // Untuk Menghitung Data
    public int getItemCount() {
        return heroesList.size();
    }

    // Untuk mengambil id pada tampilan
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivHero;
        private TextView tvName, tvDetail;
        private Button btnDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivHero = itemView.findViewById(R.id.itemhero_iv);
            tvName = itemView.findViewById(R.id.itemhero_tv_name);
            btnDetail = itemView.findViewById(R.id.itemhero_btn);

        }
    }
}
