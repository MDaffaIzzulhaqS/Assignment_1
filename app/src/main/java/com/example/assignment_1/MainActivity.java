package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comment = findViewById(R.id.comment);
    }


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPrefComment", MODE_PRIVATE);
        String s1 = sh.getString("comment", "");

        comment.setText(s1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPrefComment", MODE_PRIVATE);
        SharedPreferences.Editor se = sharedPreferences.edit();

        se.putString("comment", comment.getText().toString());
        se.apply();
    }

}