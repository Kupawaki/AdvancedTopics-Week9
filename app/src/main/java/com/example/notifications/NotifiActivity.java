package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NotifiActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifi);

        TextView notifiTV = findViewById(R.id.notifiTV);

        String message = getIntent().getStringExtra("message");

        notifiTV.setText(message);
    }
}