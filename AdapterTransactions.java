package com.example.prototipoanaquel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class AdapterTransactions extends RecyclerView.Adapter<AdapterTransactions.MyViewHolder>{

    ArrayList<Transactions> list;
    public AdapterTransactions(ArrayList<Transactions> list){
        this.list=list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder_transactions, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(list.get(i).getTitle());
        myViewHolder.title.setText("Libro: "+list.get(i).getTitle());
        myViewHolder.tag.setText("Codigo Libro: "+list.get(i).getTag_number());
        myViewHolder.loanT.setText("Fecha: "+list.get(i).getLoanTime());
        myViewHolder.cont.setText("Num Prestamos: "+list.get(i).getCounter());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, tag, loanT, cont;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitl);
            tag = itemView.findViewById(R.id.tvTagnumb);
            loanT = itemView.findViewById(R.id.tvLoantim);
            cont = itemView.findViewById(R.id.tvCount);
        }
    }
}
