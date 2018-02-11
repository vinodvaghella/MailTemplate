package com.example.vinod.mailtemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Dell XPS on 1/26/2018.
 */

public class ContactFragment extends Fragment {
    FloatingActionButton fab1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.contact_fragment, container, false);
        fab1 = (FloatingActionButton) rootView.findViewById(R.id.fabMail);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ComposeActivity.class));
            }
        });


        Button btnContact = (Button) rootView.findViewById(R.id.contact_view);
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DBResult", "Step 8 LEaving");
                Intent i = new Intent(getActivity(), ContactList.class);
                {
                    startActivity(i);
                }
            }
        });




        return rootView;
    }

}
