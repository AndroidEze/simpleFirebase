package me.ezeezegg.simplefirebase.activities;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.firebase.client.Firebase;

import java.util.Random;

import me.ezeezegg.simplefirebase.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setupUsername(){
        SharedPreferences prefs =  getApplication().getSharedPreferences("ToDoPrefs", 0);
        String username = prefs.getString("username", null);
        if (username == null){
            Random r = new Random();
            username = "AndroidUser" + r.nextInt(10000);
            prefs.edit().putString("username", username).commit();
        }
    }
}