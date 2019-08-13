package com.example.catetin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.catetin.auth.SignInActivity;

public class PreIntroActivity extends AppCompatActivity {

    private Button btnReady;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_intro);


        btnReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PreIntroActivity.this, SignInActivity.class));
            }
        });
    }
}
