package com.example.materiasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Materia> listaMaterias;
    private ListView listView;
    private static final int REQUEST_DETALLE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewMaterias);
        listaMaterias = new ArrayList<>();
        listaMaterias.add(new Materia("Matemáticas", "Juan Pérez", R.drawable.icon_math));
        listaMaterias.add(new Materia("Física", "María Gómez", R.drawable.icon_fisica));
        listaMaterias.add(new Materia("Química", "Carlos López", R.drawable.icon_quimica));
        listaMaterias.add(new Materia("Historia", "Ana Torres", R.drawable.icon_historia));
        listaMaterias.add(new Materia("Informática", "Luis Martínez", R.drawable.icon_informatica));

        MateriaAdapter adapter = new MateriaAdapter(this, listaMaterias);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Materia materia = listaMaterias.get(position);
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("nombre", materia.getNombre());
                intent.putExtra("profesor", materia.getProfesor());
                startActivityForResult(intent, REQUEST_DETALLE);
            }
        });

        Button btnRecycler = findViewById(R.id.btnRecycler);
        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                intent.putParcelableArrayListExtra("materias", listaMaterias);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_DETALLE && resultCode == RESULT_OK) {
            String mensaje = data.getStringExtra("respuesta");
            if (mensaje != null) {
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
