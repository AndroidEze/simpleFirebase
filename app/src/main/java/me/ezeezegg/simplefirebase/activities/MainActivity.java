package me.ezeezegg.simplefirebase.activities;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseRecyclerViewAdapter;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.ezeezegg.simplefirebase.R;
import me.ezeezegg.simplefirebase.ToDoApplication;

public class MainActivity extends ActionBarActivity {

    @Bind(R.id.recycler_view_items) RecyclerView recyclerView;
    @Bind(R.id.editTextItem) EditText editTestItem;

    private ChildEventListener toDoItemListener;
    private FirebaseRecyclerViewAdapter adapter;
    private Firebase dataReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUsername();
        SharedPreferences prefs = getApplication().getSharedPreferences("ToDoPrefs", 0);
        String username = prefs.getString("username", null);
        setTitle(username);
        ToDoApplication app = (ToDoApplication)getApplicationContext();
        dataReference = app.getFirebase();
    }

    public class ToDoItemViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.txtItem) TextView txtItem;
        @Bind(R.id.txtUser) TextView txtUser;
        @Bind(R.id.imgDone) ImageView imgDone;
        public ToDoItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
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
