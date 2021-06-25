package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    EditText eTxtEmail,eTxtName,eTxtPassword,eTxtGunlukPlanlanan;
    Button btnRegister;
    TextView txtZatenUyeyim;
    FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    FirebaseDatabase rootNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eTxtEmail = findViewById(R.id.eTxtEmail);
        eTxtName = findViewById(R.id.eTxtName);
        eTxtPassword = findViewById(R.id.eTxtPassword);
        eTxtGunlukPlanlanan = findViewById(R.id.eTxtPlanlananSoru);
        btnRegister = findViewById(R.id.btnRegister);
        txtZatenUyeyim = findViewById(R.id.txtZatenUyeyim);

        mAuth=FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eTxtName.getText().toString();
                String email = eTxtEmail.getText().toString().trim();
                String password = eTxtPassword.getText().toString().trim();
                String planlanan = eTxtGunlukPlanlanan.getText().toString();

                if(TextUtils.isEmpty(email)){
                    eTxtEmail.setError("Email gerekli!");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    eTxtPassword.setError("Şifre gerekli!");
                    return;
                }

                //firebase register

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            String userId = mAuth.getCurrentUser().getUid();
                            Integer toplamSoru = 0,toplamJavaSoru=0,toplamCSSoru=0,toplamCSoru=0,toplamPythonSoru=0;
                            String usertoplamSoru = toplamSoru.toString();
                            String userToplamJavaSoru= toplamJavaSoru.toString();
                            String userToplamCSSoru= toplamCSSoru.toString();
                            String userToplamCSoru= toplamCSoru.toString();
                            String userToplamPythonSoru= toplamPythonSoru.toString();
                            String userSoruOneri="Henüz Öneri Yapılmadı";
                            String userSoruCevap="Henüz Öneri Yapılmadı";
                            mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(userId);
                            HashMap<String,String> userMap = new HashMap<>();
                            userMap.put("NAME",name);
                            userMap.put("TOPLAM SORU",usertoplamSoru);
                            userMap.put("PLANLANAN SORU",planlanan);
                            userMap.put("TOPLAM JAVA SORU",userToplamJavaSoru);
                            userMap.put("TOPLAM CS SORU",userToplamCSSoru);
                            userMap.put("TOPLAM C SORU",userToplamCSoru);
                            userMap.put("TOPLAM PYTHON SORU",userToplamPythonSoru);
                            userMap.put("SORU ÖNERİ",userSoruOneri);
                            userMap.put("SORU CEVAP",userSoruCevap);
                            mDatabase.setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this, "Üyelik tamamlandı!", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    }
                                }
                            });

                        }else{
                            Toast.makeText(RegisterActivity.this, "Hata!"+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

                txtZatenUyeyim.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent loginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(loginIntent);
                        //startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                       // finish();
                    }
                });


    }
}