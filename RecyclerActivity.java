package com.example.materiasapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Materia> listaMaterias = getIntent().getParcelableArrayListExtra("materias");
        if (listaMaterias == null) listaMaterias = new ArrayList<>();

        MateriaRecyclerAdapter adapter = new MateriaRecyclerAdapter(listaMaterias);
        recyclerView.setAdapter(adapter);
    }
}
