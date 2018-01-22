package com.example.user.anasnmnt18_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;

//creating a class called Myreceiver which extends BroadcastReceiver
public class MyReceiver extends BroadcastReceiver {

    //creating a method called onReceive taking the parameters as context  and intent
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //Cursor is an interface which is used as a collection to represent data it gets the data  the uri has given.
        Cursor cursor = context.getContentResolver().query(Uri.parse("content://sms/inbox"),null,null,null,null);
        //if cusor not equals to null it Cursor is like ResultSet in java, it has rows returned by some queries with its pointer.
        // moveToFirst(), moveToNext() and moveToPosition(position) sets the pointer to desired postion.
        if (cursor != null){
            cursor.moveToFirst();
            //When you invokes moveToFirst() method on the Cursor, it takes the cursor pointer to the first location.
            // Now you can access the data present in the first record it  get the data of the column index

            String num=cursor.getString(cursor.getColumnIndex("address"));
            Toast.makeText(context, " "+num, Toast.LENGTH_LONG).show();
            String body =cursor.getString(cursor.getColumnIndex("body"));
            Toast.makeText(context, " "+body, Toast.LENGTH_LONG).show();
        }

    }
}