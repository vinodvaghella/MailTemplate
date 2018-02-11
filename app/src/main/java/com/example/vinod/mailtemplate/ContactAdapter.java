package com.example.vinod.mailtemplate;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by Dell XPS on 1/29/2018.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(@NonNull Context context, ArrayList<Contact> contactArrayList) {
        super(context, 0, contactArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.contact_list_view, parent, false );
        Log.d("DBResult", "Step 7 LEaving");

        TextView conFirstName = (TextView) view.findViewById(R.id.con_firstName);
        TextView conLastName = (TextView) view.findViewById(R.id.con_lastName);
        TextView conEmailId = (TextView) view.findViewById(R.id.con_emailId);
        TextView conId = (TextView) view.findViewById(R.id.con_idView);

        Contact contact = getItem(position);
        conId.setText(String.valueOf(contact.getId()));
        conFirstName.setText(String.valueOf(contact.getFirstName()));
        conLastName.setText(String.valueOf(contact.getLastName()));
        conEmailId.setText(String.valueOf(contact.getEmailId()));


        return view;
    }
}
