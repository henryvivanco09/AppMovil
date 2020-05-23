package com.example.prototipoanaquel;

import com.google.firebase.database.FirebaseDatabase;

public class MyFireAppPersistencia extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
