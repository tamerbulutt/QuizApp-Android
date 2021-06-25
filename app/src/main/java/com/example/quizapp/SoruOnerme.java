package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SoruOnerme extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    EditText soruOnerme,cevapOnerme;
    Button btnSoruOner,btnGerii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru_onerme);

        soruOnerme = (EditText) findViewById(R.id.eTxtSoruOneri);
        cevapOnerme = (EditText) findViewById(R.id.eTxtCevap);
        btnSoruOner = (Button) findViewById(R.id.btnSoruOneri);
        btnGerii = (Button) findViewById(R.id.btnGerii);

        mAuth = FirebaseAuth.getInstance();
        String userId = mAuth.getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(userId);

        btnSoruOner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = soruOnerme.getText().toString();
                String answer = cevapOnerme.getText().toString();

                HashMap hashMap = new HashMap();
                hashMap.put("SORU ÖNERİ",question);
                hashMap.put("SORU CEVAP",answer);

                mDatabase.updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(SoruOnerme.this, "Soru Öneriniz Alınmıştır..", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                });
            }
        });

        btnGerii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}