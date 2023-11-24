package com.example.karaoke.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.karaoke.R;
import com.example.karaoke.model.BaiHat;

import java.util.List;

import dao.DBHelper;

public class BaiHatAdapter extends ArrayAdapter<BaiHat> {
    Activity context;
    int resource;
    List<BaiHat> objects;
    DBHelper dbHelper;

    public BaiHatAdapter(Activity context, int resource, List<BaiHat> objects,DBHelper dbHelper) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.dbHelper=dbHelper;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource, null);

        TextView txtMaBH = item.findViewById(R.id.txtMaBH);
        TextView txtTenBH = item.findViewById(R.id.txtTenBH);
        TextView txtTacgia = item.findViewById(R.id.txtTacGia);
        final ImageButton btnThich = item.findViewById(R.id.btnThich);
        final ImageButton btnBoThich = item.findViewById(R.id.btnBoThich);
        final ImageButton btnChitiet = item.findViewById(R.id.btnChitiet);
        final ImageButton btnXoa = item.findViewById(R.id.btnXoa);

        final BaiHat baiHat = objects.get(position);
        txtMaBH.setText(baiHat.getMaBH()
        );
        txtTenBH.setText(baiHat.getTenBH());
        txtTacgia.setText(baiHat.getTacgia());

        if (baiHat.isYeuThich()) {
            btnThich.setVisibility(View.INVISIBLE);
            btnBoThich.setVisibility(View.VISIBLE);
        } else {
            btnThich.setVisibility(View.VISIBLE);
            btnBoThich.setVisibility(View.INVISIBLE);
        }

        btnChitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.delete(objects.get(position).getMaBH());
                objects.remove(position);
                        notifyDataSetChanged();
            }
        });
        return item;
    }
    private void xuliChitiet(BaiHat baiHat) {
        //Sinh viên tự viết
    }

    private void xuliXoa(BaiHat baiHat) {
        //Sinh viên tự viết

    }
}

