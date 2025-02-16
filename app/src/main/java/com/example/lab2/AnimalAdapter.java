package com.example.lab2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;



public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private List<Animal> animalList;
    private List<Animal> filteredList;

    public AnimalAdapter(List<Animal> animalList) {
        this.animalList = animalList;
        this.filteredList = new ArrayList<>(animalList);
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal animal = filteredList.get(position);

        holder.nameTextView.setText(animal.getName());
        holder.descriptionTextView.setText(animal.getDescription());
    }



    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void filterByType(String type) {
        filteredList.clear();
        for (Animal animal : animalList) {
            if (animal.getType().equalsIgnoreCase(type)) {
                filteredList.add(animal);
            }
        }

        notifyDataSetChanged();
    }


    class AnimalViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView descriptionTextView;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_animal_name);
            descriptionTextView = itemView.findViewById(R.id.tv_animal_description);
        }
    }

}
