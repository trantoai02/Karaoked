package dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.karaoke.model.BaiHat;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private  static  final  String DATEBASE_NAME="KaraokeList.sqlite";
    private  static  final int DATEBASE_VERSION=1;
    public  static final String TABLE_NAME="BaiHat_TBL";
    public  static final String COLUMN_MBH="MABH";
    public  static final String COLUMN_TENBH="TENBH";
    public static final String COLUMN_LOIBH="LOIBH";
    public static final String COLUMN_TACGIA="TACGIA";
    public static final String COLUMN_THELOAI="THELOAI";
    public static final String COLUMN_YEUTHICH="YEUTHICH";
    public DBHelper(Context context){
        super(context,DATEBASE_NAME,null,DATEBASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public List<BaiHat> getAllBaiHats(){
        List<BaiHat> baiHatList=new ArrayList<>();
        String[] projection={
                DBHelper.COLUMN_MBH,
                DBHelper.COLUMN_TENBH,
                DBHelper.COLUMN_LOIBH,
                DBHelper.COLUMN_TACGIA,
                DBHelper.COLUMN_THELOAI,
                DBHelper.COLUMN_YEUTHICH

        };
        Cursor cursor= getReadableDatabase().query(
                DBHelper.TABLE_NAME,
                projection,null,null,
                null,null,null
        );
        while (cursor.moveToNext()){
            BaiHat baiHat=new BaiHat();
            baiHat.setMaBH(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_MBH)));
            baiHat.setTenBH(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_TENBH)));
            baiHat.setLoiBH(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_LOIBH)));
            baiHat.setTacgia(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_TACGIA)));
            baiHat.setTheloai(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_THELOAI)));
            int yeuthich= cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_YEUTHICH));
            if(yeuthich==0){
                baiHat.setYeuThich(false);
            }else{
                baiHat.setYeuThich(true);
            }
            baiHatList.add(baiHat);
        }
        cursor.close();
        return baiHatList;
    }
    public void delete(String baihat){
        String selecsion=DBHelper.COLUMN_MBH + "=?";
        String[] selecsionArr={baihat};
        int deleterow= getWritableDatabase().delete(DBHelper.TABLE_NAME,selecsion,selecsionArr);
    }
    public void like(int bh){
        BaiHat bhh=new BaiHat();
        String selecsion=DBHelper.COLUMN_YEUTHICH + "=?";
        String[] selecsionArr={String.valueOf(bh)};
        int likes= getWritableDatabase().delete(DBHelper.TABLE_NAME,selecsion,selecsionArr);
        if(likes==1){
            bhh.setYeuThich(true);

        }else { bhh.setYeuThich(false);}
    }
}

