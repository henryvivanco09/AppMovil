package com.example.prototipoanaquel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAlerts extends RecyclerView.Adapter<AdapterAlerts.MyViewHolder> {

    ArrayList<Alerts> list;
    public AdapterAlerts(ArrayList<Alerts> list){
        this.list=list;
    }
    public AdapterAlerts.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder_notifications, viewGroup, false);
        return new AdapterAlerts.MyViewHolder(view);
    }

    public void onBindViewHolder(@NonNull AdapterAlerts.MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(list.get(i).getTitle());
        myViewHolder.messag.setText("Mensaje: "+list.get(i).getMessage());
        myViewHolder.ubicac.setText("Ubicacion: "+list.get(i).getCorrect_location());
        //myViewHolder.etiquet.setText("Etiqueta: "+list.get(i).getTag_number());
        myViewHolder.tipo.setText("Anaquel Pertenece: "+list.get(i).getIdShelf_owner());
        myViewHolder.tipo.setText("Tipo Notificacion: "+list.get(i).getType());
    }
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView anaq, title, ubicac, etiquet, messag, tipo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            messag = itemView.findViewById(R.id.tvMensaj);
            ubicac = itemView.findViewById(R.id.tvUbicac);
            //etiquet = itemView.findViewById(R.id.description);
            anaq = itemView.findViewById(R.id.tvAnaq);
            tipo = itemView.findViewById(R.id.tvTip);
        }
    }
}
