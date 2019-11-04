package com.madipb.technotalk.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.madipb.technotalk.data.AnggotaEntity;
import com.madipb.technotalk.database.KomunitasDAO;
import com.madipb.technotalk.database.KomunitasDatabase;
import com.madipb.technotalk.database.KomunitasTask;
import com.madipb.technotalk.components.MemberListRecyclerAdapter;
import com.madipb.technotalk.R;
import com.madipb.technotalk.listener.MultipleDataListener;

import java.util.ArrayList;
import java.util.List;

public class MemberListActivity extends AppCompatActivity {
    private List<AnggotaEntity> anggotaEntityList;
    private RecyclerView memberRV;
    private KomunitasDAO komunitasDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        bindView();
        initialize();
    }

    private void bindView() {
        this.memberRV = findViewById(R.id.memberRV);
    }

    private void initialize() {
        this.anggotaEntityList = new ArrayList<>();
        KomunitasDatabase database = KomunitasDatabase.getDatabase(this);
        komunitasDAO = database.komunitasDAO();
        getMemberFromDatabase();
    }

    private void getMemberFromDatabase() {
        KomunitasTask.GetAllMemberTask getAllMemberTask = new KomunitasTask.GetAllMemberTask(komunitasDAO, new MultipleDataListener<AnggotaEntity>() {
            @Override
            public void onSuccess(List<AnggotaEntity> datas, String successMessage) {
                Toast.makeText(MemberListActivity.this, successMessage, Toast.LENGTH_SHORT).show();
                anggotaEntityList = datas;
                setRV();
            }

            @Override
            public void onFailed(String failedMessage) {
                Toast.makeText(MemberListActivity.this, failedMessage, Toast.LENGTH_SHORT).show();
            }
        });

        getAllMemberTask.execute();
    }

    private void setRV() {
        memberRV.setLayoutManager(new LinearLayoutManager(this));
        MemberListRecyclerAdapter adapter = new MemberListRecyclerAdapter(anggotaEntityList, this);
        memberRV.setAdapter(adapter);
    }
}
