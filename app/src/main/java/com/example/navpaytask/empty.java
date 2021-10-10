package com.example.navpaytask;

import static com.example.navpaytask.MainScreen.current_name;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class empty extends AppCompatActivity {

    TextView emptytextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        getSupportActionBar().hide();
        emptytextview =findViewById(R.id.userName);
        emptytextview.setText(current_name);
    }

    public void backbtn(View view) {
        finish();
    }
}