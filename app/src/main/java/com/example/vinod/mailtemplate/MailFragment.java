package com.example.vinod.mailtemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Dell XPS on 1/26/2018.
 */

public class MailFragment extends Fragment {
    FloatingActionButton fab;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mail_fragment, container, false);

        fab = (FloatingActionButton) rootView.findViewById(R.id.fabID);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddContact.class));
            }
        });

        Button btnCom = (Button) rootView.findViewById(R.id.compose_id);
        btnCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ComposeActivity.class);
                {
                    startActivity(i);

                }

            }
        });


        return rootView;
    }


}
