package com.example.materiasapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MateriaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Materia> lista;

    public MateriaAdapter(Context context, ArrayList<Materia> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_materia, parent, false);
        }

        Materia materia = lista.get(position);

        ImageView imgIcono = view.findViewById(R.id.imgIcono);
        TextView tvNombre = view.findViewById(R.id.tvNombre);
        TextView tvProfesor = view.findViewById(R.id.tvProfesor);

        imgIcono.setImageResource(materia.getIcono());
        tvNombre.setText(materia.getNombre());
        tvProfesor.setText(materia.getProfesor());

        return view;
    }
}
