package com.example.gjsilalahi.absensibisa;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ReadActivity extends AppCompatActivity {

    String[] daftar;
    String[] info;
    ListView mListAbsensi;
    Button mBtnFinish;

    protected Cursor cursor;

    DataHelper dataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        mBtnFinish = findViewById(R.id.btnFinish);

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        dataHelper = new DataHelper(this);
        RefreshList();

    }

    public void RefreshList() {
        SQLiteDatabase sqLiteDatabase = dataHelper.getReadableDatabase();
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + dataHelper.TABLE_NAME, null);
        daftar = new String[cursor.getCount()];
        info = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(1).toString();
            info[i] = cursor.getString(3).toString();
        }
        mListAbsensi = findViewById(R.id.lvAbsensi);


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, daftar) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text2 = view.findViewById(android.R.id.text2);

                text2.setText(info[position]);
                return view;
            }
        };



        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar);

        mListAbsensi.setAdapter(adapter);

        mListAbsensi.setSelected(true);


        mListAbsensi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selection = daftar[i];
                final CharSequence[] dialogItem = {
                        "Lihat Data",
                        "Hapus Data"
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(ReadActivity.this);

                builder.setTitle("Pilihan");

                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i){
                            case 0 :
                                Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
                                intent.putExtra(dataHelper.COLUMN_NAME, selection);
                                startActivity(intent);
                                break;
                            case 1 :
                                SQLiteDatabase sqLiteDatabase1 = dataHelper.getWritableDatabase();

                                String dbDelete = "DELETE FROM " +
                                        dataHelper.TABLE_NAME +
                                        " WHERE " +
                                        dataHelper.COLUMN_NAME +
                                        " = '" + selection + "';";

                                sqLiteDatabase1.execSQL(dbDelete);
                                RefreshList();
                                break;
                        }

                    }
                });

                builder.create().show();

            }
        });

        //((ArrayAdapter)mListAbsensi.getAdapter()).notifyDataSetInvalidated();

    }
}
