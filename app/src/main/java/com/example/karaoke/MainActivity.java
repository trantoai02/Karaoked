package com.example.karaoke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.example.karaoke.adapter.BaiHatAdapter;
import com.example.karaoke.model.BaiHat;
import com.example.karaoke.utils.DBConfigUtil;

import java.util.ArrayList;

import dao.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText txtTimKiem;
    ListView lvBaiHat;
    ArrayList<BaiHat> dsBaiHat = new ArrayList<>();
    BaiHatAdapter adapter;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBConfigUtil.copyDatabaseFromAssets(MainActivity.this);
        dbHelper=new DBHelper(MainActivity.this);
        addControls();
        randomData();
        hienthiDanhsachBaiHat();
    }

    private void randomData() {
        for(int i=0;i< 10;i++){
            dsBaiHat.add(new BaiHat("MBH " +i, "TBH " +i, "LBH " +i, "Tacgia " +i, "TheLoai " +i, false));
        }
    }

    private void hienthiDanhsachBaiHat() {

        dsBaiHat = (ArrayList<BaiHat>) dbHelper.getAllBaiHats();
        adapter = new BaiHatAdapter(
                MainActivity.this,
                R.layout.item_baihat,
                dsBaiHat,dbHelper
        );
        lvBaiHat.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void addControls() {
        lvBaiHat = findViewById(R.id.lvBaiHat);
    }


}