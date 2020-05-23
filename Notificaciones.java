package com.example.prototipoanaquel;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Notificaciones extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ListView listV_Alert;

    private List<Alerts> listAlerts = new ArrayList<Alerts>();
    ArrayAdapter<Alerts> arrayAdapterAlerts;

    Alerts notifSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        listV_Alert = findViewById(R.id.lv_datosAlert);
        inicializarFirebase();
        listarDatos();
    }

    private void listarDatos() {
        databaseReference.child("notifications").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("estoy aqui"+databaseReference);
                listAlerts.clear();
                for (DataSnapshot objSnaptshot : dataSnapshot.getChildren()){
                    Alerts aler = objSnaptshot.getValue(Alerts.class);
                    listAlerts.add(aler);
                    arrayAdapterAlerts = new ArrayAdapter<Alerts>(Notificaciones.this, android.R.layout.simple_list_item_1, listAlerts);
                    listV_Alert.setAdapter(arrayAdapterAlerts);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Notificaciones.this, "Opsss.... No hay CONEXION NOTIFICACIONES", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    //menu eliminar notificaciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notifications,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            //boton eliminar Notificaciones
            case R.id.icon_deleteNotif:{
                Alerts notif = new Alerts();
                //notif.setKey(notifSeleccionado.getKey());
                databaseReference.child("notifications").child(notif.getKey()).removeValue();
                Toast.makeText(this,"Notificacion Eliminada", Toast.LENGTH_LONG).show();
                break;
            }
            default:break;
        }
        return true;
    }
}
