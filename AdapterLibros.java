package com.example.prototipoanaquel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class AdapterLibros extends RecyclerView.Adapter<AdapterLibros.MyViewHolder>{

    ArrayList<Libros> list;
    public AdapterLibros(ArrayList<Libros> list){
        this.list=list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(list.get(i).getTitle());
        myViewHolder.local.setText("Ubicacion: "+list.get(i).getLocation());
        myViewHolder.shelf.setText("Codigo: "+list.get(i).getTag_number());
        myViewHolder.state.setText("Estado: "+this.obtenerEstado(list.get(i).getState()));
        //myViewHolder.state.setText("Estado: "+list.get(i).getState());
        myViewHolder.author.setText("Autor: "+list.get(i).getAuthor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, local, shelf, author, state;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.deaId);
            local = itemView.findViewById(R.id.description);
            shelf = itemView.findViewById(R.id.idAnaquel);
            state = itemView.findViewById(R.id.estad);
            author = itemView.findViewById(R.id.idAuthor);
        }
    }

    public String obtenerEstado(String state) {
        if (state.equals("0")) {
            return "NO DISPONIBLE";
        }
        if (state.equals("1")) {
            return "DISPONIBLE";
        }
        if (state.equals("2")) {
            return "POSICION INCORRECTA";
        }
        return "HOLA :)";
    }
}
