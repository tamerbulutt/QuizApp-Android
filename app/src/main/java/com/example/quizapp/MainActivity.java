package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();



        if(mAuth.getCurrentUser()==null)
        {
            Toast.makeText(this, "Lütfen giriş yapınız", Toast.LENGTH_SHORT).show();
            Intent loginIntent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(loginIntent);
        }

        Button btnLogin = (Button) this.findViewById(R.id.btnLogin);
        Button btnExit = (Button) this.findViewById(R.id.btnExit);
        Button btnUserInfo = (Button) this.findViewById(R.id.btnUserInfo);
        Button btnSoruOner = (Button) this.findViewById(R.id.btnSoruOnerisi);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Hoşgeldiniz.. Hadi başlayalım", Toast.LENGTH_SHORT).show();
                Intent selectionScreen = new Intent(MainActivity.this,SelectionScreen.class);
                startActivity(selectionScreen);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
                /*mAuth.signOut();
                Toast.makeText(MainActivity.this, "Oturum Kapatılıyor..", Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(loginIntent);*/
            }
        });

        btnUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UserInfo.class));
            }
        });

        btnSoruOner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SoruOnerme.class));
            }
        });
    }
}