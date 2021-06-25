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

public class JavaTest1 extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    Integer[] cozulenSoruFinal = new Integer[1];
    Integer[] cozulenSoruJavaFinal = new Integer[1];


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_java_test1);
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
                String userCozulenJavaSoru = snapshot.child("TOPLAM JAVA SORU").getValue().toString();
                cozulenSoruFinal[0] = Integer.parseInt(userCozulenSoru);
                cozulenSoruJavaFinal[0] = Integer.parseInt(userCozulenJavaSoru);
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
                String userCozulenSoruJavaFinal = cozulenSoruJavaFinal[0].toString();
                HashMap hashMap = new HashMap();
                hashMap.put("TOPLAM SORU",userCozulenSoruFinal);
                hashMap.put("TOPLAM JAVA SORU",userCozulenSoruJavaFinal);
                mDatabase.updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(JavaTest1.this, "Update Successful", Toast.LENGTH_LONG).show();
                        Intent CsQuiz = new Intent(JavaTest1.this, SelectionScreen.class);
                        startActivity(CsQuiz);
                        finish();
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
                cozulenSoruJavaFinal[0]++;
                buttonsEnable();
                soruHazirla("SORU 2/8","Aşağıdakilerden hangisi bir Java editor ","programı değildir?","JDK","NetBeans","JCreator","Eclipse");
                newQuestion(2, 'A');
                btnNext.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        cozulenSoruFinal[0]++;
                        cozulenSoruJavaFinal[0]++;
                        buttonsEnable();
                        soruHazirla("SORU 3/8","Java dili günümüzde hangi firma","tarafından geliştirilmektedir?","Microsoft","IEEE","Oracle","Microchip");
                        newQuestion(3,'C');
                        btnNext.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                cozulenSoruFinal[0]++;
                                cozulenSoruJavaFinal[0]++;
                                buttonsEnable();
                                soruHazirla("SORU 4/8","Aşağıda verilen temel veri tiplerinden","hangisi bellekte en az yer kaplar?","Byte","String","Double","Float");
                                newQuestion(4,'A');
                                btnNext.setOnClickListener(new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        cozulenSoruFinal [0]++;
                                        cozulenSoruJavaFinal[0]++;
                                        buttonsEnable();
                                        soruHazirla("SORU 5/8","String il = Sakarya;","System.out.print(il + 5 + 4 ); ?","9Sakarya","Sakarya9","Sakarya549","Sakarya54");
                                        newQuestion(5,'D');
                                        btnNext.setOnClickListener(new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View v)
                                            {
                                                cozulenSoruFinal [0]++;
                                                cozulenSoruJavaFinal[0]++;
                                                buttonsEnable();
                                                soruHazirla("SORU 6/8","Eğer m = −12 ve n = −5, ise","m%n + işleminin sonucu ne olur?","1,2","3","-1","-2");
                                                newQuestion(6,'D');
                                                btnNext.setOnClickListener(new View.OnClickListener()
                                                {
                                                    @Override
                                                    public void onClick(View v)
                                                    {
                                                        cozulenSoruFinal [0]++;
                                                        cozulenSoruJavaFinal[0]++;
                                                        buttonsEnable();
                                                        soruHazirla("SORU 7/8","Klavyeden girilen tüm satırı okuyan","Scanner komutu hangisidir?","nextLine()","nextByte()","nextInt()","next()");
                                                        newQuestion(7,'A');
                                                        btnNext.setOnClickListener(new View.OnClickListener()
                                                        {
                                                            @Override
                                                            public void onClick(View v)
                                                            {
                                                                cozulenSoruFinal [0]++;
                                                                cozulenSoruJavaFinal[0]++;
                                                                buttonsEnable();
                                                                soruHazirla("SORU 8/8","Aşağıdaki komutlardan hangisi A","dizisinin son elemanını verir?","A.length","A.length-1","UBound(A)","A(n-1)");
                                                                newQuestion(8,'B');
                                                                btnNext.setText("==>SEVİYE 2");
                                                                btnNext.setOnClickListener(new View.OnClickListener()
                                                                {
                                                                    @Override
                                                                    public void onClick(View v)
                                                                    {
                                                                        cozulenSoruFinal [0]++;
                                                                        cozulenSoruJavaFinal[0]++;
                                                                        btnNext.setText("Yeni Soru");
                                                                        buttonsEnable();
                                                                        soruHazirla("SORU 1/3","Veritabanında Date nesnesi","nasıl depolanır?","java.util.Date","java.sql.Date","java.sql.Date.Time","java.util.DateTime");
                                                                        newQuestion(1,'B');
                                                                        btnNext.setOnClickListener(new View.OnClickListener()
                                                                        {
                                                                            @Override
                                                                            public void onClick(View v)
                                                                            {
                                                                                cozulenSoruFinal [0]++;
                                                                                cozulenSoruJavaFinal[0]++;
                                                                                buttonsEnable();
                                                                                soruHazirla("SORU 2/3","Bir formdan diğerine tarih","nasıl biçinlendirilir?","DateFormat","SimpleFormat","DateConverter","SimpleDateFormat");
                                                                                newQuestion(2,'D');
                                                                                btnNext.setOnClickListener(new View.OnClickListener()
                                                                                {
                                                                                    @Override
                                                                                    public void onClick(View v)
                                                                                    {
                                                                                        cozulenSoruFinal [0]++;
                                                                                        cozulenSoruJavaFinal[0]++;
                                                                                        buttonsEnable();
                                                                                        soruHazirla("SORU 3/3","Java karakter veri tipleri için","hangi kodlama tipi kullanılır?","ASCII","ISO-LATIN-1","UNICODE","Hiçbiri");
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
        Button btnJavaA = findViewById(R.id.btnJavaA);
        Button btnJavaB = findViewById(R.id.btnJavaB);
        Button btnJavaC = findViewById(R.id.btnJavaC);
        Button btnJavaD = findViewById(R.id.btnJavaD);
        btnJavaA.setEnabled(false);
        btnJavaB.setEnabled(false);
        btnJavaC.setEnabled(false);
        btnJavaD.setEnabled(false);
    }

    public void buttonsEnable() {
        Button btnJavaA = findViewById(R.id.btnJavaA);
        Button btnJavaB = findViewById(R.id.btnJavaB);
        Button btnJavaC = findViewById(R.id.btnJavaC);
        Button btnJavaD = findViewById(R.id.btnJavaD);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnJavaA.setEnabled(true);
        btnJavaB.setEnabled(true);
        btnJavaC.setEnabled(true);
        btnJavaD.setEnabled(true);
        btnNext.setVisibility(View.INVISIBLE);
        btnJavaA.setBackgroundColor(Color.BLUE);
        btnJavaB.setBackgroundColor(Color.BLUE);
        btnJavaC.setBackgroundColor(Color.BLUE);
        btnJavaD.setBackgroundColor(Color.BLUE);
    }

    public void newQuestion(int kacinciSoru, char answer) {
        Button btnJavaA = findViewById(R.id.btnJavaA);
        Button btnJavaB = findViewById(R.id.btnJavaB);
        Button btnJavaC = findViewById(R.id.btnJavaC);
        Button btnJavaD = findViewById(R.id.btnJavaD);
        Button btnNext = findViewById(R.id.btnNext);
        TextView txtYonlendir = findViewById(R.id.txtYonlendir);
        btnNext.setVisibility(View.INVISIBLE);
        if (answer == 'A') {
            btnJavaA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnJavaA.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnJavaB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaA.setBackgroundColor(Color.GREEN);
                    btnJavaB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnJavaC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaA.setBackgroundColor(Color.GREEN);
                    btnJavaC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                }
            });
            btnJavaD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaA.setBackgroundColor(Color.GREEN);
                    btnJavaD.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    } else
                        puan = kacinciSoru * 10;
                }
            });


        } else if (answer == 'B') {
            btnJavaB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnJavaB.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnJavaA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaB.setBackgroundColor(Color.GREEN);
                    btnJavaA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnJavaC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaB.setBackgroundColor(Color.GREEN);
                    btnJavaC.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnJavaD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaB.setBackgroundColor(Color.GREEN);
                    btnJavaD.setBackgroundColor(Color.RED);
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
            btnJavaC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnJavaC.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnJavaA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaC.setBackgroundColor(Color.GREEN);
                    btnJavaA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnJavaB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaC.setBackgroundColor(Color.GREEN);
                    btnJavaB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnJavaD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaD.setBackgroundColor(Color.GREEN);
                    btnJavaC.setBackgroundColor(Color.RED);
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
            btnJavaD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnJavaD.setBackgroundColor(Color.GREEN);
                    btnNext.setVisibility(View.VISIBLE);
                    buttonsdisEnable();
                }
            });
            btnJavaA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaD.setBackgroundColor(Color.GREEN);
                    btnJavaA.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnJavaB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaD.setBackgroundColor(Color.GREEN);
                    btnJavaB.setBackgroundColor(Color.RED);
                    buttonsdisEnable();
                    if (kacinciSoru == 8) {
                        puan = 90;
                    }else
                        puan = kacinciSoru * 10;
                    txtYonlendir.setVisibility(View.VISIBLE);
                    txtYonlendir.setText("PUANINIZ:"+puan);
                }
            });
            btnJavaC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int puan = 0;
                    btnJavaD.setBackgroundColor(Color.GREEN);
                    btnJavaC.setBackgroundColor(Color.RED);
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
        Toast.makeText(JavaTest1.this, "TEBRİKLER JAVA TESTİNİ BAŞARIYLA TAMAMLADINIZ", Toast.LENGTH_LONG).show();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent selectionScreen = new Intent(JavaTest1.this,SelectionScreen.class);
        startActivity(selectionScreen);
    }

    public void soruHazirla(String soruSayisi,String q1,String q2,String c1,String c2, String c3,String c4)
    {
        Button btnJavaA = (Button) findViewById(R.id.btnJavaA);
        Button btnJavaB = (Button) findViewById(R.id.btnJavaB);
        Button btnJavaC = (Button) findViewById(R.id.btnJavaC);
        Button btnJavaD = (Button) findViewById(R.id.btnJavaD);
        TextView txtSoruSayisi = (TextView) findViewById(R.id.txtJavaSoruSayisi);
        TextView txtJavaQ1 = (TextView) findViewById(R.id.txtJavaQ1);
        TextView txtJavaQ1_1 = (TextView) findViewById(R.id.txtJavaQ1_1);
        txtSoruSayisi.setText(soruSayisi);
        txtJavaQ1.setText(q1);
        txtJavaQ1_1.setText(q2);
        btnJavaA.setText(c1);
        btnJavaB.setText(c2);
        btnJavaC.setText(c3);
        btnJavaD.setText(c4);
    }
}