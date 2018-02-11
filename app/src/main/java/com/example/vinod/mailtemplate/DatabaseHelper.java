package com.example.vinod.mailtemplate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Dell XPS on 1/29/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = " Contact.ContactDb ";
    public static final String TABLE_CONTACT = " Contact ";
    public static final int DB_VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists" + TABLE_CONTACT + " " +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, First_Name TEXT, Last_Name TEXT, Email_Id TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CONTACT);
        onCreate(db);
    }

    public void btnAdd(Contact contact) {
        Log.d("DBResult", "Step 1 Enter into add method");

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("First_Name",contact.getFirstName());
        contentValues.put("Last_Name",contact.getLastName());
        contentValues.put("Email_Id",contact.getEmailId());
        db.insert(TABLE_CONTACT, null, contentValues);

        Log.d("DBResult", "Step 2 LEaving");
        db.close();
    }

    public ArrayList<Contact> viewContact() {
        Log.d("DBResult", "Step 3 LEaving");

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_CONTACT, null);

        Log.d("DBResult", "Step 4 LEaving");

        ArrayList<Contact> contacts = new ArrayList<Contact>();
        while (cursor.moveToNext()) {

            Log.d("DBResult", "Step 5 LEaving");

            int id = cursor.getInt(0);
            String firstName = cursor.getString(1);
            String lastName = cursor.getString(2);
            String emailId = cursor.getString(3);



            contacts.add(new Contact(id, firstName, lastName, emailId));
            Log.d("DBResult", "Id = "+id +" - First Name = "+firstName+" - Last Name = "+lastName+" - Email Id = "+emailId);
        }
        Log.d("DBResult", "Step 6 LEaving");
            db.close();

            return contacts;
    }
}
