package com.example.lab2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnimalAdapter animalAdapter;
    private List<Animal> animalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        animalList = new ArrayList<>();
        animalList.add(new Animal("CAt 1", "description", "Cat"));
        animalList.add(new Animal("Dog 1", "description", "Dog"));
        animalList.add(new Animal("Rabbit 1", "description", "Rabbit"));
        animalList.add(new Animal("CAt 2", "description", "Cat"));
        animalList.add(new Animal("Dog 2", "description", "Dog"));
        animalList.add(new Animal("Rabbit 2", "description", "Rabbit"));
        animalList.add(new Animal("CAt 3", "description", "Cat"));
        animalList.add(new Animal("Dog 3", "description", "Dog"));
        animalList.add(new Animal("Rabbit 3", "description", "Rabbit"));
        animalList.add(new Animal("CAt 4", "description", "Cat"));
        animalList.add(new Animal("Dog 4", "description", "Dog"));
        animalList.add(new Animal("Rabbit 4", "description", "Rabbit"));
        animalList.add(new Animal("CAt 5", "description", "Cat"));
        animalList.add(new Animal("Dog 5", "description", "Dog"));
        animalList.add(new Animal("Rabbit 5", "description", "Rabbit"));


        animalAdapter = new AnimalAdapter(animalList);
        recyclerView.setAdapter(animalAdapter);

        ChipGroup chipGroup = findViewById(R.id.chipGroup);

        chipGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.chip_cat) {
                animalAdapter.filterByType("Cat");
            } else if (checkedId == R.id.chip_dog) {
                animalAdapter.filterByType("Dog");
            } else if (checkedId == R.id.chip_rabbit) {
                animalAdapter.filterByType("Rabbit");
            }
        });
    }
}
