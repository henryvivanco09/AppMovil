package com.example.prototipoanaquel;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class Buscador extends AppCompatActivity {
    DatabaseReference ref;
    ArrayList<Libros> list;
    RecyclerView recyclerView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);

        ref = FirebaseDatabase.getInstance().getReference().child("libros");
        System.out.println("Extraendo datos firebase: "+ref);
        recyclerView = findViewById(R.id.rv);
        searchView = (SearchView) findViewById(R.id.searchView);
    }

    @Override
    protected void onStart(){
        super.onStart();
        if (ref != null){
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()){
                        list= new ArrayList<>();
                        for (DataSnapshot ds: dataSnapshot.getChildren()){
                            list.add(ds.getValue(Libros.class));
                        }
                        //AdapterLibros adapterLibros = new AdapterLibros(list);
                        //recyclerView.setAdapter(adapterLibros);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Buscador.this, "Opsss.... No hay CONEXION BUSCADOR", Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (searchView != null){
            //Toast.makeText(this, "NO HAY RESULTADOS", Toast.LENGTH_LONG).show();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String next) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String next) {
                    search(next);
                    return true;
                }
            });
        }
        }
    private void search(String str){
        ArrayList<Libros> myList = new ArrayList<>();
        for (Libros object : list){
            if (object.getTitle().toLowerCase().contains(str.toLowerCase())){
                myList.add(object);
            }
        }
        AdapterLibros adapterLibros = new AdapterLibros(myList);
        recyclerView.setAdapter(adapterLibros);
    }

}
