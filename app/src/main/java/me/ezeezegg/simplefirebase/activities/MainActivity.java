package me.ezeezegg.simplefirebase.activities;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

import me.ezeezegg.simplefirebase.R;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void setupUsername() {
        SharedPreferences prefs = getApplication().getSharedPreferences("ToDoPrefs", 0);
        String username = prefs.getString("username", null);
        if (username == null) {
            Random r = new Random();
            username = "AndroidUser" + r.nextInt(100000);
            prefs.edit().putString("username", username).commit();
        }
    }
}
