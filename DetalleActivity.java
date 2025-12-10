package com.example.materiasapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        String nombre = getIntent().getStringExtra("nombre");
        String profesor = getIntent().getStringExtra("profesor");

        TextView tvDetalle = findViewById(R.id.tvDetalle);
        tvDetalle.setText("Bienvenido a la materia de " + nombre + ", dictada por el profesor " + profesor + ".");

        Button btnCerrar = findViewById(R.id.btnCerrar);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra("respuesta", "Has visto la materia de " + nombre);
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}
