package com.example.user.anasnmnt18_2;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//creating main activity
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {//onCreate method is called when main activity is created
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the permission for Receiving an sms
        String permission = Manifest.permission.RECEIVE_SMS;
        int grant = ContextCompat.checkSelfPermission(this, permission);
        //if permission greanted it results the permission list
        if ( grant != PackageManager.PERMISSION_GRANTED) {
            String[] permission_list = new String[1];
            permission_list[0] = permission;
            ActivityCompat.requestPermissions(this, permission_list, 1);
        }
//creating an intent object of context mainactivity.this which results the secondactivty.class
        // broadcastIntent to send it to any interested BroadcastReceiver components, and startService(Intent)
        //  or bindService(Intent, ServiceConnection, int) to communicate with a background Service.
        Intent intent = new Intent(MainActivity.this,MyReceiver.class);
        sendBroadcast(intent);

    }

}
