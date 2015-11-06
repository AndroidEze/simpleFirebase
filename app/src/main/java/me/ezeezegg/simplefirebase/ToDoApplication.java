package me.ezeezegg.simplefirebase;

import android.app.Application;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ToDoApplication extends Application {
    private String FIREBASE_URL = "https://siplefirebase.firebaseio.com/";
    private String FIREBASE_CHILD = "items";
    //@Bind(R.id.editText) EditText editText;
    Firebase firebase;

    @Override
    public void onCreate() {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        super.onCreate();

        //ButterKnife.bind(this);
        Firebase.setAndroidContext(this);
        Firebase.getDefaultConfig().setPersistenceEnabled(true);//support offline
        firebase = new Firebase(FIREBASE_URL).child(FIREBASE_CHILD);



        /*firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Toast.makeText(ToDoApplication.this, snapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
                Log.e(getLocalClassName(), snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(FirebaseError error) {
            }
        });*/
    }

    /*@OnClick(R.id.button)
    public void writeToFirebase() {
        firebase.setValue(editText.getText().toString());
        editText.setText("");
    }*/
    public Firebase getFirebase(){
        return firebase;
    }
}