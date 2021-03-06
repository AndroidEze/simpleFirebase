package me.ezeezegg.simplefirebase;

import android.app.Application;

import com.firebase.client.Firebase;

public class ToDoApplication extends Application {
    private String FIREBASE_CHILD = "items";
    private String FIREBASE_URL = "https://siplefirebase.firebaseio.com/";

    Firebase firebase;

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
        firebase = new Firebase(FIREBASE_URL).child(FIREBASE_CHILD);
    }

    public Firebase getFirebase() {
        return firebase;
    }
}