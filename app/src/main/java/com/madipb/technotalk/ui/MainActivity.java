package com.madipb.technotalk.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.madipb.technotalk.data.AnggotaEntity;
import com.madipb.technotalk.database.KomunitasDAO;
import com.madipb.technotalk.database.KomunitasDatabase;
import com.madipb.technotalk.database.KomunitasTask;
import com.madipb.technotalk.R;
import com.madipb.technotalk.listener.BasicTaskListener;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private EditText nameET, emailET, komunitasET, angkatanET;
    private Button daftarButton, daftarkanButton;
    private AnggotaEntity anggotaEntity;
    private KomunitasDAO komunitasDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindView();
        initialize();
    }

    private void bindView() {
        this.nameET = findViewById(R.id.nameET);
        this.emailET = findViewById(R.id.emailET);
        this.komunitasET = findViewById(R.id.komunitasET);
        this.angkatanET = findViewById(R.id.angkatanET);
        this.daftarButton = findViewById(R.id.memberListButton);
        this.daftarkanButton = findViewById(R.id.daftarButton);

        this.daftarkanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = nameET.getText().toString();
                String email = emailET.getText().toString();
                String komunitas = komunitasET.getText().toString();
                int angkatan = 0;

                if (!angkatanET.getText().toString().equals("")){
                    angkatan = Integer.parseInt(angkatanET.getText().toString());
                }

                if (nama.equals("")){
                    Toast.makeText(MainActivity.this, "Nama Masih Kosong", Toast.LENGTH_SHORT).show();
                } else if (email.equals("")){
                    Toast.makeText(MainActivity.this, "Email Masih Kosong", Toast.LENGTH_SHORT).show();
                } else if (komunitas.equals("")){
                    Toast.makeText(MainActivity.this, "Komunitas Masih Kosong", Toast.LENGTH_SHORT).show();
                } else if(angkatanET.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Angkatan Masih Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    AnggotaEntity anggotaEntity = new AnggotaEntity(nama, email, komunitas, angkatan);
                    saveToDatabase(anggotaEntity);
                    Log.d(TAG, "onClick: Anggota is: " + anggotaEntity.toString());
                }
            }
        });

        this.daftarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MemberListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initialize() {
        KomunitasDatabase komunitasDatabase = KomunitasDatabase.getDatabase(this);
        komunitasDAO = komunitasDatabase.komunitasDAO();
    }

    private void saveToDatabase(AnggotaEntity anggotaEntity) {
        KomunitasTask.InsertMemberTask insertMemberTask = new KomunitasTask.InsertMemberTask(komunitasDAO, new BasicTaskListener() {
            @Override
            public void onTaskFinished(Boolean aBoolean) {
                if (aBoolean){
                    Toast.makeText(MainActivity.this, "Simpan Berhasil", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Simpan Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

        insertMemberTask.execute(anggotaEntity);
    }
}
