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

public class PythonTest1 extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    Integer[] cozulenSoruFinal = new Integer[1];
    Integer[] cozulenSoruPythonFinal = new Integer[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_test1);

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
                String userCozulenPythonSoru = snapshot.child("TOPLAM PYTHON SORU").getValue().toString();
                cozulenSoruFinal[0] = Integer.parseInt(userCozulenSoru);
                cozulenSoruPythonFinal[0] = Integer.parseInt(userCozulenPythonSoru);
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
                String userCozulenSoruPythonFinal = cozulenSoruPythonFinal[0].toString();
                HashMap hashMap = new HashMap();
                hashMap.put("TOPLAM SORU", userCozulenSoruFinal);
                hashMap.put("TOPLAM PYTHON SORU", userCozulenSoruPythonFinal);
                mDatabase.updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(PythonTest1.this, "Update Successful", Toast.LENGTH_LONG).show();
                        Intent PythonQuiz = new Intent(PythonTest1.this, SelectionScreen.class);
                        startActivity(PythonQuiz);
                    }
                });


            }
        });
        newQuestion(1, 'D');
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cozulenSoruFinal[0]++;
                cozulenSoruPythonFinal[0]++;
                buttonsEnable();
                soruHazirla("SORU 2/8","Python'da hangisi","yorum satırı ekler?","#","//","<!-->","/**/");
                newQuestion(2, 'A');
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cozulenSoruFinal[0]++;
                        cozulenSoruPythonFinal[0]++;
                        buttonsEnable();
                        soruHazirla("SORU 3/8","Aşağıdakilerden hangisi","Python dosya uzantısıdır?",".pyth",".pt",".py",".exe");
                        newQuestion(3, 'C');
                        btnNext.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                cozulenSoruFinal[0]++;
                                cozulenSoruPythonFinal[0]++;
                                buttonsEnable();
                                soruHazirla("SORU 4/8","Operatörlerden hangisi üs alma","ifadesinin karşılığıdır?","**","=<","!!","++");
                                newQuestion(4, 'A');
                                btnNext.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        cozulenSoruFinal[0]++;
                                        cozulenSoruPythonFinal[0]++;
                                        buttonsEnable();
                                        soruHazirla("SORU 5/8","Kullanıcıdan veri alınması gerektiğinde","hangisi kullanılmalıdır?","output()","if()","print()","input()");
                                        newQuestion(5, 'D');
                                        btnNext.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                cozulenSoruFinal[0]++;
                                                cozulenSoruPythonFinal[0]++;
                                                buttonsEnable();
                                                soruHazirla("SORU 6/8","Hangisi veri çekmede kullanılan","kütüphanelerden biridir?","Django","numPy","PyGame","BeautifulSoup");
                                                newQuestion(6, 'D');
                                                btnNext.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        cozulenSoruFinal[0]++;
                                                        cozulenSoruPythonFinal[0]++;
                                                        buttonsEnable();
                                                        soruHazirla("SORU 7/8","Hangisi konuşmayı yazıya çeviren","bir kütüphanedir?","PyGame","numPy","Requests","numPy");
                                                        newQuestion(7, 'A');
                                                        btnNext.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                cozulenSoruFinal[0]++;
                                                                cozulenSoruPythonFinal[0]++;
                                                                buttonsEnable();
                                                                soruHazirla("SORU 8/8","Hangisi Python'un","lehçelerinden biridir?","APython","RPython","C++","ASP");
                                                                newQuestion(8, 'B');
                                                                btnNext.setText("==>SEVİYE 2");
                                                                btnNext.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        cozulenSoruFinal[0]++;
                                                                        cozulenSoruPythonFinal[0]++;
                                                                        btnNext.setText("Yeni Soru");
                                                                        buttonsEnable();
                                                                        soruHazirla("SORU 1/3","Hangisi Python'un etkilendiği ","dillerden biri değildir?","ABC","C#","Java","Perl");
                                                                        newQuestion(1, 'B');
                                                                        btnNext.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                cozulenSoruFinal[0]++;
                                                                                cozulenSoruPythonFinal[0]++;
                                                                                buttonsEnable();
                                                                                soruHazirla("SORU 2/3","Hangisi Python'un etkilediği ","dillerden biri değildir?","Boo","D","Cobra","R");
                                                                                newQuestion(2, 'D');
                                                                                btnNext.setOnClickListener(new View.OnClickListener() {
                                                                                    @Override
                                                                                    public void onClick(View v) {
                                                                                        cozulenSoruFinal[0]++;
                                                                                        cozulenSoruPythonFinal[0]++;
                                                                                        buttonsEnable();
                                                                                        soruHazirla("SORU 3/3","Python'un tasarımcısı ","aşağıdakilerden hangisidir?","James Gosling","Steve Jobs","Guido van Rossum","Hiçbiri");
                                                                                        newQuestion(3, 'C');
                                                                                        btnNext.setText("TEST BAŞARILI!");
                                                                                        btnNext.setOnClickListener(new View.OnClickListener() {
                                                                                            @Override
                                                                                            public void onClick(View v) {
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
        Button btnPythonA = findViewById(R.id.btnPythonA);
        Button btnPythonB = findViewById(R.id.btnPythonB);
        Button btnPythonC = findViewById(R.id.btnPythonC);
        Button btnPythonD = findViewById(R.id.btnPythonD);
        btnPythonA.setEnabled(false);
        btnPythonB.setEnabled(false);
        btnPythonC.setEnabled(false);
        btnPythonD.setEnabled(false);
    }

    public void buttonsEnable() {
        Button btnPythonA = findViewById(R.id.btnPythonA);
        Button btnPythonB = findViewById(R.id.btnPythonB);
        Button btnPythonC = findViewById(R.id.btnPythonC);
        Button btnPythonD = findViewById(R.id.btnPythonD);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnPythonA.setEnabled(true);
        btnPythonB.setEnabled(true);
        btnPythonC.setEnabled(true);
        btnPythonD.setEnabled(true);
        btnNext.setVisibility(View.INVISIBLE);
        btnPythonA.setBackgroundColor(Color.BLUE);
        btnPythonB.setBackgroundColor(Color.BLUE);
        btnPythonC.setBackgroundColor(Color.BLUE);
        btnPythonD.setBackgroundColor(Color.BLUE);
    }

    public void newQuestion(int kacinciSoru, char answer) {
        Button btnPythonA = findViewById(R.id.btnPythonA);
        Button btnPythonB = findViewById(R.id.btnPythonB);
        Button btnPythonC = findViewById(R.id.btnPythonC);
        Button btnPythonD = findViewById(R.id.btnPythonD);
        Button btnNext = findViewById(R.id.btnNext);
        TextView txtYonlendir = findViewById(R.id.txtYonlendir);
        btnNext.setVisibility(View.INVISIBLE);
        if (answer == 'A') {
            btnPythonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnPythonA.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnPythonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonA.setBackgroundColor(Color.GREEN);
                    btnPythonB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:" + puan);
                }
            });
            btnPythonC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonA.setBackgroundColor(Color.GREEN);
                    btnPythonC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                }
            });
            btnPythonD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonA.setBackgroundColor(Color.GREEN);
                    btnPythonD.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                }
            });


        } else if (answer == 'B') {
            btnPythonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnPythonB.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnPythonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonB.setBackgroundColor(Color.GREEN);
                    btnPythonA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:" + puan);
                }
            });
            btnPythonC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonB.setBackgroundColor(Color.GREEN);
                    btnPythonC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:" + puan);
                }
            });
            btnPythonD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonB.setBackgroundColor(Color.GREEN);
                    btnPythonD.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:" + puan);
                }
            });
        } else if (answer == 'C') {
            btnPythonC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnPythonC.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnPythonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonC.setBackgroundColor(Color.GREEN);
                    btnPythonA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:" + puan);
                }
            });
            btnPythonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonC.setBackgroundColor(Color.GREEN);
                    btnPythonB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:" + puan);
                }
            });
            btnPythonD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonD.setBackgroundColor(Color.GREEN);
                    btnPythonC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:" + puan);
                }
            });
        } else {
            btnPythonD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnPythonD.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnPythonA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonD.setBackgroundColor(Color.GREEN);
                    btnPythonA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:" + puan);
                }
            });
            btnPythonB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonD.setBackgroundColor(Color.GREEN);
                    btnPythonB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:" + puan);
                }
            });
            btnPythonC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnPythonD.setBackgroundColor(Color.GREEN);
                    btnPythonC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:" + puan);
                }
            });
        }
    }

    public void anaEkranaYonlendir() {
        Toast.makeText(PythonTest1.this, "TEBRİKLER PYTHON TESTİNİ BAŞARIYLA TAMAMLADINIZ", Toast.LENGTH_LONG).show();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent selectionScreen = new Intent(PythonTest1.this, SelectionScreen.class);
        startActivity(selectionScreen);
    }

    public void soruHazirla(String soruSayisi, String q1, String q2, String c1, String c2, String c3, String c4) {
        Button btnPythonA = (Button) findViewById(R.id.btnPythonA);
        Button btnPythonB = (Button) findViewById(R.id.btnPythonB);
        Button btnPythonC = (Button) findViewById(R.id.btnPythonC);
        Button btnPythonD = (Button) findViewById(R.id.btnPythonD);
        TextView txtSoruSayisi = (TextView) findViewById(R.id.txtPythonSoruSayisi);
        TextView txtPythonQ1 = (TextView) findViewById(R.id.txtPythonQ1);
        TextView txtPythonQ1_1 = (TextView) findViewById(R.id.txtPythonQ1_1);
        txtSoruSayisi.setText(soruSayisi);
        txtPythonQ1.setText(q1);
        txtPythonQ1_1.setText(q2);
        btnPythonA.setText(c1);
        btnPythonB.setText(c2);
        btnPythonC.setText(c3);
        btnPythonD.setText(c4);
    }
}
