package com.example.prototipoanaquel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btBusc, btInvent, btPrest, btNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btBusc=findViewById(R.id.bt1);
        btBusc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReg=new Intent(MainActivity.this, Buscador.class);
                MainActivity.this.startActivity(intentReg);

            }
        });

        btInvent=findViewById(R.id.bt3);
        btInvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInvent=new Intent(MainActivity.this, Inventario.class);
                MainActivity.this.startActivity(intentInvent);

            }
        });

        btPrest=findViewById(R.id.bt2);
        btPrest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPrest=new Intent(MainActivity.this, Prestamos.class);
                MainActivity.this.startActivity(intentPrest);

            }
        });

        btNotif=findViewById(R.id.bt4);
        btNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNotif=new Intent(MainActivity.this, Notificaciones.class);
                MainActivity.this.startActivity(intentNotif);

            }
        });
    }
}
