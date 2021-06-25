package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SelectionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen1);
        //Tanımlamalar
        Button btnJava = (Button) findViewById(R.id.btnJava);
        Button btnCS = (Button) findViewById(R.id.btnCS);
        Button btnC = (Button) findViewById(R.id.btnC);
        Button btnPyhton = (Button) findViewById(R.id.btnPyhton);
        TextView txtProfile = (TextView) findViewById(R.id.txtYanlisUyari);

        //Java Giriş
        btnJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent javaQuiz = new Intent(SelectionScreen.this,JavaTest1.class);
                startActivity(javaQuiz);
            }
        });
        //C# Giriş
        btnCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent csQuiz = new Intent(SelectionScreen.this,CSTest1.class);
                startActivity(csQuiz);
            }
        });
        //C Giriş
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cQuiz = new Intent(SelectionScreen.this,CTest1.class);
                startActivity(cQuiz);
            }
        });
        //Python Giriş
        btnPyhton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pythonQuiz = new Intent(SelectionScreen.this, PythonTest1.class);
                startActivity(pythonQuiz);
            }
        });

        txtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UserInfo.class));
            }
        });



    }
}