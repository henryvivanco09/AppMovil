package com.example.prototipoanaquel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseApp;
import android.widget.ListView;

import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import android.view.Menu;
import android.view.MenuItem;


public class Inventario extends AppCompatActivity {

    EditText idS, tagNum, aut, tit, editNum, estat, locat, loadT, returT;
    ListView listV_Libros;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private List<Libros> listLibros = new ArrayList<Libros>();
    ArrayAdapter<Libros> arrayAdapterLibros;

    Libros libroSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario2);

        idS = findViewById(R.id.txt_idAnaquel);
        tagNum = findViewById(R.id.txt_tagNum);
        aut = findViewById(R.id.txt_author);
        tit = findViewById(R.id.txt_title);
        estat = findViewById(R.id.txt_estado);
        editNum = findViewById(R.id.txt_numEdicion);
        locat = findViewById(R.id.txt_ubicacion);

        listV_Libros = findViewById(R.id.lv_datosLibros);
        inicializarFirebase();
        listarDatos();

        listV_Libros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                libroSeleccionado = (Libros) parent.getItemAtPosition(position);

                idS.setText(libroSeleccionado.getIdShelf());
                tagNum.setText(libroSeleccionado.getTag_number());
                aut.setText(libroSeleccionado.getAuthor());
                tit.setText(libroSeleccionado.getTitle());
                estat.setText(libroSeleccionado.getState());
                editNum.setText(libroSeleccionado.getEdition_number());
                locat.setText(libroSeleccionado.getLocation());
            }
        });
    }

    private void listarDatos() {
        databaseReference.child("libros").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listLibros.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    Libros p = objSnaptshot.getValue(Libros.class);
                    listLibros.add(p);

                    arrayAdapterLibros = new ArrayAdapter<Libros>(Inventario.this, android.R.layout.simple_list_item_1, listLibros);
                    listV_Libros.setAdapter(arrayAdapterLibros);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Inventario.this, "Opsss.... No hay CONEXION INVENTARIO", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String edition_number = editNum.getText().toString();
        String idShelf = idS.getText().toString();
        String location = locat.getText().toString();
        String author = aut.getText().toString();
        String state = estat.getText().toString();
        String tag_number = tagNum.getText().toString();
        String title = tit.getText().toString();

        switch (item.getItemId()){
            //boton guardar libros
            case R.id.icon_add:{
                //Toast.makeText(this,"Agregar", Toast.LENGTH_LONG).show();
                if (idShelf.equals("")||tag_number.equals("")||author.equals("")||title.equals("")||edition_number.equals("")||state.equals("")||location.equals("")){
                    validacion();
                }
                else {
                    Libros lib = new Libros();
                    lib.setKey(UUID.randomUUID().toString());
                    lib.setEdition_number(edition_number);
                    lib.setIdShelf(idShelf);
                    lib.setLoanTime("");
                    lib.setLocation(location);
                    lib.setAuthor(author);
                    lib.setReturnTime("");
                    //lib.setState(1);
                    lib.setState(state);
                    lib.setTag_number(tag_number);
                    lib.setTitle(title);
                    databaseReference.child("libros").child(lib.getKey()).setValue(lib);
                    Toast.makeText(this, "Agregado", Toast.LENGTH_LONG).show();
                    limpiarCajas();
                    //guardar en tabla anaqueles
                    System.out.println("VOY POR AQUI");
                    Anaquels anaq = new Anaquels();
                    System.out.println("ESTOY AQUI");
                    anaq.setState("true");
                    anaq.setTag_number(tag_number);
                    if (idShelf.equals("1")) {
                        System.out.println("INGRESE AQUI");
                        databaseReference.child("shelfs").child("shelf01").child(lib.getKey()).setValue(anaq);
                    }
                    if (idShelf.equals("2")) {
                        databaseReference.child("shelfs").child("shelf02").child(lib.getKey()).setValue(anaq);
                    }

                }
                break;
            }
            //boton actualizar libros
            case R.id.icon_save:{
                Libros lib = new Libros();
                lib.setKey(libroSeleccionado.getKey());
                lib.setEdition_number(editNum.getText().toString().trim());
                lib.setIdShelf(idS.getText().toString().trim());
                lib.setLoanTime("");
                lib.setLocation(locat.getText().toString().trim());
                lib.setAuthor(aut.getText().toString().trim());
                lib.setReturnTime("");
                //lib.setState(1);
                lib.setState(estat.getText().toString().trim());
                lib.setTag_number(tagNum.getText().toString().trim());
                lib.setTitle(tit.getText().toString().trim());
                databaseReference.child("libros").child(lib.getKey()).setValue(lib);
                Toast.makeText(this,"Actualizado", Toast.LENGTH_LONG).show();
                limpiarCajas();
                //actualizar etiqueta de libros en anaqueles
                //guardar en tabla anaqueles
                System.out.println("VOY POR AQUI2");
                Anaquels anaq = new Anaquels();
                System.out.println("ESTOY AQUI2");
                anaq.setState(estat.getText().toString().trim());
                anaq.setTag_number(tagNum.getText().toString().trim());
                if (idS.equals("1")) {
                    System.out.println("INGRESE AQUI2");
                    databaseReference.child("shelfs").child("shelf01").child(lib.getKey()).setValue(anaq);
                }
                if (idS.equals("2")) {
                    databaseReference.child("shelfs").child("shelf02").child(lib.getKey()).setValue(anaq);
                }
                break;
            }
            //boton eliminar libros
            case R.id.icon_delete:{
                Libros lib = new Libros();
                lib.setKey(libroSeleccionado.getKey());
                databaseReference.child("libros").child(lib.getKey()).removeValue();
                Toast.makeText(this,"Eliminado", Toast.LENGTH_LONG).show();
                limpiarCajas();
                //eliminar libro en anaquel
                System.out.println("INGRESE AQUI3");
                databaseReference.child("shelfs").child("shelf01").child(lib.getKey()).removeValue();
                databaseReference.child("shelfs").child("shelf02").child(lib.getKey()).removeValue();
                break;
            }
            default:break;
        }
        return true;
    }

    private void limpiarCajas() {
        idS.setText("");
        estat.setText("");
        editNum.setText("");
        tit.setText("");
        tagNum.setText("");
        aut.setText("");
        locat.setText("");
    }

    private void validacion() {
        String idShelf = idS.getText().toString();
        String title = tit.getText().toString();
        String state = estat.getText().toString();
        String tag_number = tagNum.getText().toString();
        String edition_number = editNum.getText().toString();
        String location = locat.getText().toString();
        String author = aut.getText().toString();
        if (idShelf.equals("")){
            idS.setError("Required");
        }
        else if (title.equals("")){
            tit.setError("Required");
        }
        else if (state.equals("")){
            estat.setError("Required");
        }
        else if (location.equals("")){
            locat.setError("Required");
        }
        else if (tag_number.equals("")){
            tagNum.setError("Required");
        }
        else if (edition_number.equals("")){
            editNum.setError("Required");
        }
        else if (author.equals("")){
            aut.setError("Required");
        }
    }
}


        /*ref = FirebaseDatabase.getInstance().getReference().child("libros");
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
                        AdapterLibros adapterLibros = new AdapterLibros(list);
                        recyclerView.setAdapter(adapterLibros);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(Inventario.this, "Opsss.... No hay CONEXION", Toast.LENGTH_SHORT).show();
                }
            });
        }*/


