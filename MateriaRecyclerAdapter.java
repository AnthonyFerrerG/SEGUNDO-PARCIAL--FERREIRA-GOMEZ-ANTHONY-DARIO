package com.example.materiasapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MateriaRecyclerAdapter extends RecyclerView.Adapter<MateriaRecyclerAdapter.MateriaViewHolder> {

    private ArrayList<Materia> lista;

    public MateriaRecyclerAdapter(ArrayList<Materia> lista) {
        this.lista = lista;
    }

    public static class MateriaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcono;
        TextView tvNombre, tvProfesor;

        public MateriaViewHolder(View itemView) {
            super(itemView);
            imgIcono = itemView.findViewById(R.id.imgIcono);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvProfesor = itemView.findViewById(R.id.tvProfesor);
        }
    }

    @Override
    public MateriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materia, parent, false);
        return new MateriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MateriaViewHolder holder, int position) {
        Materia materia = lista.get(position);
        holder.imgIcono.setImageResource(materia.getIcono());
        holder.tvNombre.setText(materia.getNombre());
        holder.tvProfesor.setText(materia.getProfesor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Materia: " + materia.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
