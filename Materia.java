package com.example.materiasapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Materia implements Parcelable {
    private String nombre;
    private String profesor;
    private int icono;

    public Materia(String nombre, String profesor, int icono) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.icono = icono;
    }

    protected Materia(Parcel in) {
        nombre = in.readString();
        profesor = in.readString();
        icono = in.readInt();
    }

    public static final Creator<Materia> CREATOR = new Creator<Materia>() {
        @Override
        public Materia createFromParcel(Parcel in) {
            return new Materia(in);
        }

        @Override
        public Materia[] newArray(int size) {
            return new Materia[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public int getIcono() {
        return icono;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(profesor);
        parcel.writeInt(icono);
    }
}
