package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;

public class UserInfo extends AppCompatActivity {

    TextView txtUserCozulenSoru , txtUserAd,txtPlanlanan,txtJavaToplam,txtCSToplam,txtCToplam,txtPythonToplam,txtHedef,txtDahaCok;
    Button btnGeri;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        txtUserCozulenSoru=(TextView) findViewById(R.id.txtUserCozulenSoru);
        txtUserAd = (TextView) findViewById(R.id.txtUserAd);
        txtPlanlanan = (TextView) findViewById(R.id.txtPlanlanan);
        txtJavaToplam = (TextView) findViewById(R.id.txtJavaToplam);
        txtCSToplam = (TextView) findViewById(R.id.txtCSToplam);
        txtCToplam = (TextView) findViewById(R.id.txtCToplam);
        txtPythonToplam = (TextView) findViewById(R.id.txtPythonToplam);
        txtHedef = (TextView) findViewById(R.id.txtHedefYapmalisin);
        txtDahaCok = (TextView) findViewById(R.id.txtDahaCokCoz);

        btnGeri = (Button) findViewById(R.id.btnGeri);

        mAuth = FirebaseAuth.getInstance();
        String userId = mAuth.getCurrentUser().getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(userId);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String userName = snapshot.child("NAME").getValue().toString();
                String userCozulenSoru = snapshot.child("TOPLAM SORU").getValue().toString();
                String userCozulenJavaSoru = snapshot.child("TOPLAM JAVA SORU").getValue().toString();
                String userCozulenCSoru = snapshot.child("TOPLAM C SORU").getValue().toString();
                String userCozulenCSSoru = snapshot.child("TOPLAM CS SORU").getValue().toString();
                String userCozulenPythonSoru = snapshot.child("TOPLAM PYTHON SORU").getValue().toString();
                String userPlanlananSoru = snapshot.child("PLANLANAN SORU").getValue().toString();

                txtUserAd.setText(userName);
                txtUserCozulenSoru.setText(userCozulenSoru);
                txtCSToplam.setText(userCozulenCSSoru);
                txtJavaToplam.setText(userCozulenJavaSoru);
                txtCToplam.setText(userCozulenCSoru);
                txtPythonToplam.setText(userCozulenPythonSoru);
                txtPlanlanan.setText(userPlanlananSoru);

                Integer cozulen = Integer.parseInt(userCozulenSoru);
                Integer planlanan = Integer.parseInt(userPlanlananSoru);

                Integer JavaCozulen = Integer.parseInt(userCozulenJavaSoru);
                Integer CsCozulen = Integer.parseInt(userCozulenCSSoru);
                Integer CCozulen = Integer.parseInt(userCozulenCSoru);
                Integer PythonCozulen = Integer.parseInt(userCozulenPythonSoru);


                if (planlanan-cozulen > 0 )
                    txtHedef.setText("G??nl??k planlamanlamandan daha az soru ????zd??n daha fazla ??abalamal??s??n!");
                else
                    txtHedef.setText("Tebrikler planlanandan daha fazla soru ????zd??n!");

                if(JavaCozulen>CCozulen && JavaCozulen>CsCozulen && JavaCozulen>PythonCozulen)
                    txtDahaCok.setText("Di??erlerine oranla daha fazla Java ????zd??n,di??erlerine de a????rl??k g??stermelisin.");
                else if(CsCozulen>JavaCozulen && CsCozulen>CCozulen && CsCozulen> PythonCozulen)
                    txtDahaCok.setText("Di??erlerine oranla daha fazla C# ????zd??n,di??erlerine de a????rl??k g??stermelisin.");
                else if(CCozulen>JavaCozulen && CCozulen>CsCozulen && CCozulen>PythonCozulen)
                    txtDahaCok.setText("Di??erlerine oranla daha fazla C ????zd??n,di??erlerine de a????rl??k g??stermelisin.");
                else if(PythonCozulen>JavaCozulen && PythonCozulen>CsCozulen && PythonCozulen>CCozulen)
                    txtDahaCok.setText("Di??erlerine oranla daha fazla Python ????zd??n,di??erlerine de a????rl??k g??stermelisin.");
                else
                    txtDahaCok.setText("Hen??z hi?? soru ????zmedin soru ????zmeye ba??lamal??s??n!");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
}