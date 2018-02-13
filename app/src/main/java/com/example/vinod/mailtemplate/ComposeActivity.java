package com.example.vinod.mailtemplate;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * Created by Dell XPS on 1/26/2018.
 */

public class ComposeActivity extends AppCompatActivity implements View.OnClickListener{


    Session session = null;
    ProgressDialog progressDialog = null;
    Context context = null;
    EditText email, subject, msgText;
    String eml, sub, msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        context = this;
        FloatingActionButton login = (FloatingActionButton) findViewById(R.id.fabSend);

        email = (EditText)findViewById(R.id.email);
        subject = (EditText)findViewById(R.id.subject);
        msgText = (EditText)findViewById(R.id.message);

        login.setOnClickListener(this);

}


    @Override
    public void onClick(View v) {
        eml = email.getText().toString();
        sub = subject.getText().toString();
        msg = msgText.getText().toString();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");

        session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mailtemplate30@gmail.com","123456789k");
            }
        });

        progressDialog = ProgressDialog.show(context, "", "Sending Mail...", true);
        RetreiveFeedTask task = new RetreiveFeedTask();
        task.execute();
    }
    class RetreiveFeedTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            try {

                Message message = new MimeMessage(session);

                message.setFrom(new InternetAddress("mailtemplate30@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(eml));
                message.setSubject(sub);
                message.setContent(msg,"text/html; charset=utf-8");
                Transport.send(message);
            }catch (MessagingException e){
                e.printStackTrace();
            }catch (Exception e){
                              String errMsg = e.getMessage();
                Log.d("inBackground", errMsg);

                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();

            email.setText("");
            msgText.setText("");
            subject.setText("");

            Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_LONG).show();
        }
    }
}
