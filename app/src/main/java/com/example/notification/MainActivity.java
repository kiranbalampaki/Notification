package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private Button btnNotification1, btnNotification2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        btnNotification1 = findViewById(R.id.btnNotification1);
        btnNotification2 = findViewById(R.id.btnNotification2);

        btnNotification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification1();
            }
        });

        btnNotification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification2();
            }
        });
    }

    private void displayNotification1(){
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.Channel_1)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("First Message")
                .setContentText("First message body")
//                .addAction(R.drawable.ic_notifications_black_24dp, "Reply", ) // #0
//                .addAction(R.drawable.ic_message_black_24dp, "Archive", myIntentToButtonTwoScreen)  // #1
//                .addAction(R.drawable.ic_notifications_black_24dp, "Snooze", myIntentToButtonThreeScreen)     // #2
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    private void displayNotification2(){
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.Channel_2)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle("Second Message")
                .setContentText("Second message body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(2, notification);
    }
}
