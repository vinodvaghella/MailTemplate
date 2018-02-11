package com.example.vinod.mailtemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Dell XPS on 1/31/2018.
 */

public class ContactList extends AppCompatActivity {

    private DatabaseHelper MyDatabaseHelper;
    private ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        MyDatabaseHelper = new DatabaseHelper(this);
        Log.d("DBResult", "Step 7 LEaving");

        contactListView = (ListView)findViewById(R.id.mail_contact);

        Log.d("DBResult", "Step 9 LEaving");
        ViewData();

    }

    private void ViewData(){
        ArrayList<Contact> list = MyDatabaseHelper.viewContact();
        ContactAdapter contactAdapter = new ContactAdapter(this, list);
        contactListView.setAdapter(contactAdapter);
        Log.d("DBResult", "Step 8 LEaving");
    }
}