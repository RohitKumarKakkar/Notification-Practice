package com.trojan.notificationpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnNormalView, btnBigTextView, btnBigPicView, btnInboxStyleView, floatingMenuBtn;
    String myText = "This is My Notification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNormalView = findViewById(R.id.btnNormalview);
        btnBigTextView = findViewById(R.id.btnBigText);
        btnBigPicView = findViewById(R.id.btnBigPicview);
        btnInboxStyleView = findViewById(R.id.btnInboxStyleview);
        floatingMenuBtn = findViewById(R.id.floatingMenuBtn);

        registerForContextMenu(floatingMenuBtn);

        floatingMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Please Long Click The Button For Floating menu", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void showNotification(View view) {

        switch (view.getId()) {

            case R.id.btnNormalview:
                ShowNormalNotification();
                break;

            case R.id.btnBigText:
                ShowBigTextNotification();
                break;

            case R.id.btnBigPicview:
                ShowBigPicNotification();
                break;

            case R.id.btnInboxStyleview:
                ShowInboxStyleNotification();
                break;
        }

    }

    public void ShowNormalNotification() {

        //Build The Content Of Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("Normal View Notification");
        builder.setContentText(myText);
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setTicker("hey this is ticker");
        builder.setAutoCancel(true);

        //Intent to Jump On Activity From Notification
        Intent i = new Intent(MainActivity.this, NormalActivity.class);
        //Back Stack Trace to Jump Back to Main Activity
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
        stackBuilder.addParentStack(NormalActivity.class);
        stackBuilder.addNextIntent(i);
        PendingIntent PI = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        //Intent to Jump On SettingsActivity From Notification //Back Stack Trace to Jump Back to Main Activity
        Intent j = new Intent(MainActivity.this, SettingsActivity.class);
        TaskStackBuilder stackBuilder_settings = TaskStackBuilder.create(MainActivity.this);
        stackBuilder_settings.addParentStack(SettingsActivity.class);
        stackBuilder_settings.addNextIntent(j);
        PendingIntent PI_settings = stackBuilder_settings.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        //Intent to Jump On HelpActivity From Notification //Back Stack Trace to Jump Back to Main Activity
        Intent k = new Intent(MainActivity.this, HelpActivity.class);
        TaskStackBuilder stackBuilder_help = TaskStackBuilder.create(MainActivity.this);
        stackBuilder_help.addParentStack(HelpActivity.class);
        stackBuilder_help.addNextIntent(k);
        PendingIntent PI_help = stackBuilder_help.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        //Adding Buttons And Actions In Notification
        builder.addAction(R.drawable.ic_settings_black_24dp, "Settings", PI_settings);
        builder.addAction(R.drawable.ic_help_black_24dp, "Help", PI_help);
        builder.setContentIntent(PI);


        //Notification Through Notification Manager
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1001, notification);

    }

    public void ShowBigTextNotification() {

        //Assign a Style Of Big Text
        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        style.setBigContentTitle("Big Text View Notification");
        style.bigText(myText + "Testing This For Big Text and I have To Write A very Big Text Here For Testing");


        //Build The Content Of Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("Big Text View Notification");
        builder.setContentText(myText + "Testing This For Big Text and I have To Write A very Big Text Here For Testing");
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setTicker("hey this is ticker");
        builder.setAutoCancel(true);
        builder.setStyle(style);

        //Notification Through Notification Manager
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1002, notification);

    }

    public void ShowBigPicNotification() {

        //Assign a Style Of Big Picture
        Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.watchvideo);
        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        style.setBigContentTitle("Big Picture View Notification");
        style.bigPicture(bmp);


        //Build The Content Of Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("Big Picture View Notification");
        builder.setContentText(myText);
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setTicker("hey this is ticker");
        builder.setAutoCancel(true);
        builder.setStyle(style);


        //Intent to Jump On Activity From Notification
        Intent i = new Intent(MainActivity.this, NormalActivity.class);
        //Back Stack Trace to Jump Back to Main Activity
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
        stackBuilder.addParentStack(NormalActivity.class);
        stackBuilder.addNextIntent(i);
        PendingIntent PI = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        //Intent to Jump On SettingsActivity From Notification //Back Stack Trace to Jump Back to Main Activity
        Intent j = new Intent(MainActivity.this, SettingsActivity.class);
        TaskStackBuilder stackBuilder_settings = TaskStackBuilder.create(MainActivity.this);
        stackBuilder_settings.addParentStack(SettingsActivity.class);
        stackBuilder_settings.addNextIntent(j);
        PendingIntent PI_settings = stackBuilder_settings.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        //Intent to Jump On HelpActivity From Notification //Back Stack Trace to Jump Back to Main Activity
        Intent k = new Intent(MainActivity.this, HelpActivity.class);
        TaskStackBuilder stackBuilder_help = TaskStackBuilder.create(MainActivity.this);
        stackBuilder_help.addParentStack(HelpActivity.class);
        stackBuilder_help.addNextIntent(k);
        PendingIntent PI_help = stackBuilder_help.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        //Adding Buttons And Actions In Notification
        builder.addAction(R.drawable.ic_settings_black_24dp, "Settings", PI_settings);
        builder.addAction(R.drawable.ic_help_black_24dp, "Help", PI_help);
        builder.setContentIntent(PI);


        //Notification Through Notification Manager
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1003, notification);

    }

    public void ShowInboxStyleNotification() {

        //Assign a Style Of Inbox Notification
        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        style.setBigContentTitle("Inbox Style View Notification");
        style.addLine("Email One");
        style.addLine("Email Two");
        style.addLine("Email Three");
        style.addLine("Email Four");

        //Build The Content Of Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
        builder.setContentTitle("Inbox Style View Notification");
        builder.setContentText(myText);
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setTicker("hey this is ticker");
        builder.setAutoCancel(true);
        builder.setStyle(style);

        //Notification Through Notification Manager
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1004, notification);

    }


//Context Menu Layout

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.floatingmenu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(this, "Edit Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_delete:
                Toast.makeText(this, "Delete Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_copy:
                Toast.makeText(this, "Copy Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_move:
                Toast.makeText(this, "Move Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_hide:
                Toast.makeText(this, "Hide Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
