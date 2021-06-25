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

public class CSTest1 extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    Integer[] cozulenSoruFinal = new Integer[1];
    Integer[] cozulenSoruCsFinal = new Integer[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_s_test1);
        //Tanımlamalar
        Button btnBack = findViewById(R.id.btnBack);
        Button btnNext = findViewById(R.id.btnNext);
        Button btnCsA = findViewById(R.id.btnCSA);
        Button btnCsB = findViewById(R.id.btnCSB);
        Button btnCsC = findViewById(R.id.btnCSC);
        Button btnCsD = findViewById(R.id.btnCSD);
        TextView txtSoruSayisi = findViewById(R.id.txtCSSoruSayisi);
        TextView txtCsQ1 = findViewById(R.id.txtCSQ1);
        TextView txtCsQ1_1 = findViewById(R.id.txtCSQ1_1);
        TextView txtYonlendır = findViewById(R.id.txtYonlendir);

        mAuth = FirebaseAuth.getInstance();
        String userId = mAuth.getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(userId);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String userCozulenSoru = snapshot.child("TOPLAM SORU").getValue().toString();
                String userCozulenCsSoru = snapshot.child("TOPLAM CS SORU").getValue().toString();
                cozulenSoruFinal[0] = Integer.parseInt(userCozulenSoru);
                cozulenSoruCsFinal[0] = Integer.parseInt(userCozulenCsSoru);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        txtYonlendır.setVisibility(View.INVISIBLE); //Puanda devreye girecek
        //Seçim ekranına yönlendirici
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userCozulenSoruFinal = cozulenSoruFinal[0].toString();
                String userCozulenSoruCsFinal = cozulenSoruCsFinal[0].toString();
                HashMap hashMap = new HashMap();
                hashMap.put("TOPLAM SORU",userCozulenSoruFinal);
                hashMap.put("TOPLAM CS SORU",userCozulenSoruCsFinal);
                mDatabase.updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(CSTest1.this, "Update Successful", Toast.LENGTH_LONG).show();
                        Intent CsQuiz = new Intent(CSTest1.this, SelectionScreen.class);
                        startActivity(CsQuiz);
                    }
                });
            }
        });
        newQuestion(1, 'D');
        btnNext.setOnClickListener(new View.OnClickListener() { //Sıradaki soruya hazırlıyor
            @Override
            public void onClick(View v)
            {
                cozulenSoruFinal[0]++;
                cozulenSoruCsFinal[0]++;
                buttonsEnable();
                soruHazirla("SORU 2/8","Program içerisinde açıklama yapma ","için hangi karakterler kullanılır?","/**/","{}","()","''");
                newQuestion(2, 'A');
                btnNext.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        cozulenSoruFinal[0]++;
                        cozulenSoruCsFinal[0]++;
                        buttonsEnable();
                        soruHazirla("SORU 3/8","Ve(AND) mantık operatörü için ","aşağıdakilerden hangisi kullanılır?",">","!","&","|");
                        newQuestion(3,'C');
                        btnNext.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                cozulenSoruFinal[0]++;
                                cozulenSoruCsFinal[0]++;
                                buttonsEnable();
                                soruHazirla("SORU 4/8","Hangi keyword C#","dilinde yoktur?","args","ref","out","params");
                                newQuestion(4,'A');
                        btnNext.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                cozulenSoruFinal[0]++;
                                cozulenSoruCsFinal[0]++;
                                buttonsEnable();
                                soruHazirla("SORU 5/8","Aşağıdaki türlerden hangisi en","büyük tamsayı değerini tutar?","Int32","byte","long","ulong");
                                newQuestion(5,'D');
                        btnNext.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                cozulenSoruFinal[0]++;
                                cozulenSoruCsFinal[0]++;
                                buttonsEnable();
                                soruHazirla("SORU 6/8","Garbage Collector tarafından yönetilen",".net kodlarına ne denir?","Assembly Code","Garbage Code","Intermadite Code","Managed Code");
                                newQuestion(6,'D');
                         btnNext.setOnClickListener(new View.OnClickListener()
                         {
                             @Override
                             public void onClick(View v)
                             {
                                 cozulenSoruFinal[0]++;
                                 cozulenSoruCsFinal[0]++;
                                 buttonsEnable();
                                 soruHazirla("SORU 7/8","C# dilinde Sekiller.dll isimli","dosya içerisinde aşağıdakilerden hangisi yoktur?","Makine Dili","Metadata","IL","Manifest");
                                 newQuestion(7,'A');
                         btnNext.setOnClickListener(new View.OnClickListener()
                         {
                             @Override
                             public void onClick(View v)
                             {
                                 cozulenSoruFinal[0]++;
                                 cozulenSoruCsFinal[0]++;
                                 buttonsEnable();
                                 soruHazirla("SORU 8/8","Hangisi C# dilinin etkilediği","dillerden biri değildir?","Dart","Assembly","Swift","Java");
                                 newQuestion(8,'B');
                                 btnNext.setText("==>SEVİYE 2");
                          btnNext.setOnClickListener(new View.OnClickListener()
                          {
                              @Override
                              public void onClick(View v)
                              {
                                  cozulenSoruFinal[0]++;
                                  cozulenSoruCsFinal[0]++;
                                  btnNext.setText("Yeni Soru");
                                  buttonsEnable();
                                  soruHazirla("SORU 1/3","Aşağıdakilerden hangisi sınıf ve nesne","arasındaki ilişkiye bir örnek olabilir?","Araba-Tır","Kuş-Kuş Resmi","Elma-Armut","Kalem-Kalemtraş");
                                  newQuestion(1,'B');
                          btnNext.setOnClickListener(new View.OnClickListener()
                          {
                              @Override
                              public void onClick(View v)
                              {
                                  cozulenSoruFinal[0]++;
                                  cozulenSoruCsFinal[0]++;
                                  buttonsEnable();
                                  soruHazirla("SORU 2/3","C# derleme sürecinde karşımıza","IL ne anlama gelir?","Internal Language","Interactional Language","Interoperability Language","Intermediate Language");
                                  newQuestion(2,'D');
                          btnNext.setOnClickListener(new View.OnClickListener()
                          {
                              @Override
                              public void onClick(View v)
                              {
                                  cozulenSoruFinal[0]++;
                                  cozulenSoruCsFinal[0]++;
                                  buttonsEnable();
                                  soruHazirla("SORU 3/3","Assembly’e ait bilgilerin","tutulduğu alana ne ad verilir?","Metadata","Properties","Information Area","Manifest");
                                  newQuestion(3,'D');
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
        Button btnCsA = findViewById(R.id.btnCSA);
        Button btnCsB = findViewById(R.id.btnCSB);
        Button btnCsC = findViewById(R.id.btnCSC);
        Button btnCsD = findViewById(R.id.btnCSD);
        btnCsA.setEnabled(false);
        btnCsB.setEnabled(false);
        btnCsC.setEnabled(false);
        btnCsD.setEnabled(false);
    }

    public void buttonsEnable() {
        Button btnCsA = findViewById(R.id.btnCSA);
        Button btnCsB = findViewById(R.id.btnCSB);
        Button btnCsC = findViewById(R.id.btnCSC);
        Button btnCsD = findViewById(R.id.btnCSD);
        Button btnNext = findViewById(R.id.btnNext);
        btnCsA.setEnabled(true);
        btnCsB.setEnabled(true);
        btnCsC.setEnabled(true);
        btnCsD.setEnabled(true);
        btnNext.setVisibility(View.INVISIBLE);
        btnCsA.setBackgroundColor(Color.BLUE);
        btnCsB.setBackgroundColor(Color.BLUE);
        btnCsC.setBackgroundColor(Color.BLUE);
        btnCsD.setBackgroundColor(Color.BLUE);
    }

    public void newQuestion(int kacinciSoru, char answer) {
        Button btnCsA = findViewById(R.id.btnCSA);
        Button btnCsB = findViewById(R.id.btnCSB);
        Button btnCsC = findViewById(R.id.btnCSC);
        Button btnCsD = findViewById(R.id.btnCSD);
        Button btnNext = findViewById(R.id.btnNext);
        TextView txtYonlendir = findViewById(R.id.txtYonlendir);
        btnNext.setVisibility(View.INVISIBLE);

        if (answer == 'A') {
            btnCsA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnCsA.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnCsB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsA.setBackgroundColor(Color.GREEN);
                    btnCsB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCsC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsA.setBackgroundColor(Color.GREEN);
                    btnCsC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                }
            });
            btnCsD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsA.setBackgroundColor(Color.GREEN);
                    btnCsD.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                }
            });


        } else if (answer == 'B') {
            btnCsB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnCsB.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnCsA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsB.setBackgroundColor(Color.GREEN);
                    btnCsA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCsC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsB.setBackgroundColor(Color.GREEN);
                    btnCsC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCsD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsB.setBackgroundColor(Color.GREEN);
                    btnCsD.setBackgroundColor(Color.RED);
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
            btnCsC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnCsC.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnCsA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsC.setBackgroundColor(Color.GREEN);
                    btnCsA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCsB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsC.setBackgroundColor(Color.GREEN);
                    btnCsB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCsD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsD.setBackgroundColor(Color.GREEN);
                    btnCsC.setBackgroundColor(Color.RED);
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
            btnCsD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnCsD.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnCsA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsD.setBackgroundColor(Color.GREEN);
                    btnCsA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCsB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsD.setBackgroundColor(Color.GREEN);
                    btnCsB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnCsC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnCsD.setBackgroundColor(Color.GREEN);
                    btnCsC.setBackgroundColor(Color.RED);
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
        Toast.makeText(CSTest1.this, "TEBRİKLER C# TESTİNİ BAŞARIYLA TAMAMLADINIZ", Toast.LENGTH_LONG).show();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent selectionScreen = new Intent(CSTest1.this,SelectionScreen.class);
        startActivity(selectionScreen);
    }
    public void soruHazirla(String soruSayisi,String q1,String q2,String c1,String c2, String c3,String c4)
    {
        Button btnCsA = findViewById(R.id.btnCSA);
        Button btnCsB = findViewById(R.id.btnCSB);
        Button btnCsC = findViewById(R.id.btnCSC);
        Button btnCsD = findViewById(R.id.btnCSD);
        TextView txtSoruSayisi = findViewById(R.id.txtCSSoruSayisi);
        TextView txtCsQ1 = findViewById(R.id.txtCSQ1);
        TextView txtCsQ1_1 = findViewById(R.id.txtCSQ1_1);
        txtSoruSayisi.setText(soruSayisi);
        txtCsQ1.setText(q1);
        txtCsQ1_1.setText(q2);
        btnCsA.setText(c1);
        btnCsB.setText(c2);
        btnCsC.setText(c3);
        btnCsD.setText(c4);
    }

}
