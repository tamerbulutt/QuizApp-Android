package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class CTest1 extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    Integer[] cozulenSoruFinal = new Integer[1];
    Integer[] cozulenSoruCFinal = new Integer[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_test1);

        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        TextView txtYonlendır = (TextView) findViewById(R.id.txtYonlendir);

        mAuth = FirebaseAuth.getInstance();
        String userId = mAuth.getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(userId);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String userCozulenSoru = snapshot.child("TOPLAM SORU").getValue().toString();
                String userCozulenCSoru = snapshot.child("TOPLAM C SORU").getValue().toString();
                cozulenSoruFinal[0] = Integer.parseInt(userCozulenSoru);
                cozulenSoruCFinal[0] = Integer.parseInt(userCozulenCSoru);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        txtYonlendır.setVisibility(View.INVISIBLE);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userCozulenSoruFinal = cozulenSoruFinal[0].toString();
                String userCozulenSoruCFinal = cozulenSoruCFinal[0].toString();
                HashMap hashMap = new HashMap();
                hashMap.put("TOPLAM SORU",userCozulenSoruFinal);
                hashMap.put("TOPLAM C SORU",userCozulenSoruCFinal);
                mDatabase.updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(CTest1.this, "Update Successful", Toast.LENGTH_LONG).show();
                        Intent CQuiz = new Intent(CTest1.this, SelectionScreen.class);
                        startActivity(CQuiz);
                    }
                });


            }
        });
        newQuestion(1, 'D');
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                cozulenSoruFinal[0]++;
                cozulenSoruCFinal[0]++;
                buttonsEnable();
                soruHazirla("SORU 2/8","C dilinin temelleri","kim tarafından geliştirilmiştir?","Martin Richards","James Gosling","Steve Jobs","Emily Curnham");
                newQuestion(2, 'A');
                btnNext.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        cozulenSoruFinal[0]++;
                        cozulenSoruCFinal[0]++;
                        buttonsEnable();
                        soruHazirla("SORU 3/8","Aşağıdakilerden hangisi bir","C anahtar kelimelerinden değildir?","auto","extern","args","for");
                        newQuestion(3,'C');
                        btnNext.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                cozulenSoruFinal[0]++;
                                cozulenSoruCFinal[0]++;
                                buttonsEnable();
                                soruHazirla("SORU 4/8","C dili ile aşağıdaki programlama","türlerinden hangisini yapamazsınız?","Mobil","Masaüstü","Gömülü Sistem","Dosyaya Yazdırma");
                                newQuestion(4,'A');
                                btnNext.setOnClickListener(new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        cozulenSoruFinal[0]++;
                                        cozulenSoruCFinal[0]++;
                                        buttonsEnable();
                                        soruHazirla("SORU 5/8","Aşağıdakilerden hangisi kütüphane","dahil eder?","//include","<>include","#include studio","#include<stdio.h>");
                                        newQuestion(5,'D');
                                        btnNext.setOnClickListener(new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View v)
                                            {
                                                cozulenSoruFinal[0]++;
                                                cozulenSoruCFinal[0]++;
                                                buttonsEnable();
                                                soruHazirla("SORU 6/8","Hangisi C'nin etkilendiği","dillerden biri değildir?","Fortran","B","Algol68","C++");
                                                newQuestion(6,'D');
                                                btnNext.setOnClickListener(new View.OnClickListener()
                                                {
                                                    @Override
                                                    public void onClick(View v)
                                                    {
                                                        cozulenSoruFinal[0]++;
                                                        cozulenSoruCFinal[0]++;
                                                        buttonsEnable();
                                                        soruHazirla("SORU 7/8","C dilinin çıkış tarihi","aşağıdakilerden hangisidir?","1972","1975","1978","1979");
                                                        newQuestion(7,'A');
                                                        btnNext.setOnClickListener(new View.OnClickListener()
                                                        {
                                                            @Override
                                                            public void onClick(View v)
                                                            {
                                                                cozulenSoruFinal[0]++;
                                                                cozulenSoruCFinal[0]++;
                                                                buttonsEnable();
                                                                soruHazirla("SORU 8/8","Aşağıdakilerden hangisi C dilinin","önemli uygulamalarından değildir?","Clang","Delphi","Msvc","Turbo C");
                                                                newQuestion(8,'B');
                                                                btnNext.setText("==>SEVİYE 2");
                                                                btnNext.setOnClickListener(new View.OnClickListener()
                                                                {
                                                                    @Override
                                                                    public void onClick(View v)
                                                                    {
                                                                        cozulenSoruFinal[0]++;
                                                                        cozulenSoruCFinal[0]++;
                                                                        btnNext.setText("Yeni Soru");
                                                                        buttonsEnable();
                                                                        soruHazirla("SORU 1/3","Aşağıdakilerden hangisi C dilinin","lehçelerinden değildir?","Cyclone","ASP","Cilk","Split-C");
                                                                        newQuestion(1,'B');
                                                                        btnNext.setOnClickListener(new View.OnClickListener()
                                                                        {
                                                                            @Override
                                                                            public void onClick(View v)
                                                                            {
                                                                                cozulenSoruFinal[0]++;
                                                                                cozulenSoruCFinal[0]++;
                                                                                buttonsEnable();
                                                                                soruHazirla("SORU 2/3","C aşağıdaki dillerden hangilerini","etkilemememiştir?","C#","Objective-C","GO","Assembly");
                                                                                newQuestion(2,'D');
                                                                                btnNext.setOnClickListener(new View.OnClickListener()
                                                                                {
                                                                                    @Override
                                                                                    public void onClick(View v)
                                                                                    {
                                                                                        cozulenSoruFinal[0]++;
                                                                                        cozulenSoruCFinal[0]++;
                                                                                        buttonsEnable();
                                                                                        soruHazirla("SORU 3/3","C dilinin geliştirilmeleri","hangi laboratuvarda gerçekleşmiştir??","Auther Lab","C-Lab","AT&T Bell","Hiçbiri");
                                                                                        newQuestion(3,'C');
                                                                                        btnNext.setText("TEST BAŞARILI!");
                                                                                        btnNext.setOnClickListener(new View.OnClickListener()
                                                                                        {
                                                                                            @Override
                                                                                            public void onClick(View v)
                                                                                            {
                                                                                                txtYonlendır.setVisibility(View.VISIBLE);
                                                                                                anaEkranaYonlendir();
                                                                                            }
                                                                                        });

                                                                                    }
                                                                                });
                                                                            }
                                                                        });
                                                                    }
                                                                });
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    ///////// FONKSİYONLAR /////////// FONKSİYONLAR //////// FONKSİYONLAR /////////// FONKSİYONLAR ////////

    public void buttonsdisEnable() {
        Button btnCA = findViewById(R.id.btnCA);
        Button btnCB = findViewById(R.id.btnCB);
        Button btnCC = findViewById(R.id.btnCC);
        Button btnCD = findViewById(R.id.btnCD);
        btnCA.setEnabled(false);
        btnCB.setEnabled(false);
        btnCC.setEnabled(false);
        btnCD.setEnabled(false);
    }

    public void buttonsEnable() {
        Button btnCA = findViewById(R.id.btnCA);
        Button btnCB = findViewById(R.id.btnCB);
        Button btnCC = findViewById(R.id.btnCC);
        Button btnCD = findViewById(R.id.btnCD);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnCA.setEnabled(true);
        btnCB.setEnabled(true);
        btnCC.setEnabled(true);
        btnCD.setEnabled(true);
        btnNext.setVisibility(View.INVISIBLE);
        btnCA.setBackgroundColor(Color.BLUE);
        btnCB.setBackgroundColor(Color.BLUE);
        btnCC.setBackgroundColor(Color.BLUE);
        btnCD.setBackgroundColor(Color.BLUE);
    }

    public void newQuestion(int kacinciSoru, char answer) {
        Button btnCA = findViewById(R.id.btnCA);
        Button btnCB = findViewById(R.id.btnCB);
        Button btnCC = findViewById(R.id.btnCC);
        Button btnCD = findViewById(R.id.btnCD);
        Button btnNext = findViewById(R.id.btnNext);
        TextView txtYonlendir = findViewById(R.id.txtYonlendir);
        btnNext.setVisibility(View.INVISIBLE);
        if (answer == 'A') {
            btnCA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnCA.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnCB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCA.setBackgroundColor(Color.GREEN);
                    btnCB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCA.setBackgroundColor(Color.GREEN);
                    btnCC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                }
            });
            btnCD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCA.setBackgroundColor(Color.GREEN);
                    btnCD.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                }
            });


        } else if (answer == 'B') {
            btnCB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnCB.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnCA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCB.setBackgroundColor(Color.GREEN);
                    btnCA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCB.setBackgroundColor(Color.GREEN);
                    btnCC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCB.setBackgroundColor(Color.GREEN);
                    btnCD.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
        } else if (answer == 'C') {
            btnCC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnCC.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnCA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCC.setBackgroundColor(Color.GREEN);
                    btnCA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCC.setBackgroundColor(Color.GREEN);
                    btnCB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCD.setBackgroundColor(Color.GREEN);
                    btnCC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
        } else {
            btnCD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnCD.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnCA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCD.setBackgroundColor(Color.GREEN);
                    btnCA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCD.setBackgroundColor(Color.GREEN);
                    btnCB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCD.setBackgroundColor(Color.GREEN);
                    btnCC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
        }
    }

    public void anaEkranaYonlendir()
    {
        Toast.makeText(CTest1.this, "TEBRİKLER C TESTİNİ BAŞARIYLA TAMAMLADINIZ", Toast.LENGTH_LONG).show();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent selectionScreen = new Intent(CTest1.this,SelectionScreen.class);
        startActivity(selectionScreen);
    }

    public void soruHazirla(String soruSayisi,String q1,String q2,String c1,String c2, String c3,String c4)
    {
        Button btnCA = (Button) findViewById(R.id.btnCA);
        Button btnCB = (Button) findViewById(R.id.btnCB);
        Button btnCC = (Button) findViewById(R.id.btnCC);
        Button btnCD = (Button) findViewById(R.id.btnCD);
        TextView txtSoruSayisi = (TextView) findViewById(R.id.txtCSoruSayisi);
        TextView txtCQ1 = (TextView) findViewById(R.id.txtCQ1);
        TextView txtCQ1_1 = (TextView) findViewById(R.id.txtCQ1_1);
        txtSoruSayisi.setText(soruSayisi);
        txtCQ1.setText(q1);
        txtCQ1_1.setText(q2);
        btnCA.setText(c1);
        btnCB.setText(c2);
        btnCC.setText(c3);
        btnCD.setText(c4);
    }
    }
