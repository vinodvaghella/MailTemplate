package com.example.vinod.mailtemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dell XPS on 1/29/2018.
 */

public class AddContact extends AppCompatActivity {
    private DatabaseHelper MyDataBaseHelper;
    private EditText editFirstName, editLastName, editEmailId;
    private Button btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        MyDataBaseHelper = new DatabaseHelper(this);

        initComponents();
        AddData();



    }

    private void initComponents() {
        editFirstName = (EditText) findViewById(R.id.first_name);
        editLastName = (EditText) findViewById(R.id.last_name);
        editEmailId = (EditText) findViewById(R.id.email_id);
        btnSub = (Button) findViewById(R.id.add_sub);

    }

    private void AddData() {
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Contact contact = new Contact
                            (editFirstName.getText().toString(),editLastName.getText().toString(),editEmailId.getText().toString());
                    MyDataBaseHelper.btnAdd(contact);
                    Toast.makeText(AddContact.this, "Contact added to list successfully", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(AddContact.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}