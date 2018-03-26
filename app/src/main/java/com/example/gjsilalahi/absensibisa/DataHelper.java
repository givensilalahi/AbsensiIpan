package com.example.gjsilalahi.absensibisa;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by GJSILALAHI on 24/03/2018.
 */

public class DataHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "absensibisa.db";
    public static final String TABLE_NAME = "absensi";
    public static final String COLUMN_NIM = "nim";
    public static final String COLUMN_NAME = "nama_mahasiswa";
    public static final String COLUMN_CLASS = "kelas";
    public static final String COLUMN_INFO = "keterangan";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String dbCreate = "CREATE TABLE IF NOT EXIST " +
                TABLE_NAME + "(" +
                COLUMN_NIM + " VARCHAR(10) NULL, " +
                COLUMN_NAME + " VARCHAR(30) NULL, " +
                COLUMN_CLASS + " VARCHAR(6) NULL, " +
                COLUMN_INFO + " VARCHAR(4) NULL)" +
                ";";

        Log.d("Data", "onCreate: " + dbCreate);

        sqLiteDatabase.execSQL(dbCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
