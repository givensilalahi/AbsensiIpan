package com.example.gjsilalahi.absensibisa;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ViewActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dataHelper;
    Button buttonOK, buttonUpdate;
    TextView textView1, textView2, textView3, textView4, textView5;
    private String getDateTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat(

                "yyyy-MM-dd", Locale.getDefault());

        Date date = new Date();

        return dateFormat.format(date);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        textView1 = findViewById(R.id.tvInNama);
        textView2 = findViewById(R.id.tvInNIM);
        textView3 = findViewById(R.id.tvInKelas);
        textView4 = findViewById(R.id.tvInKet);
        textView5 = findViewById(R.id.tvInTgl);
        buttonOK = findViewById(R.id.btnOK);

        dataHelper = new DataHelper(this);

        textView5.setText(getDateTime());

        SQLiteDatabase sqLiteDatabase = dataHelper.getReadableDatabase();
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM " +
                dataHelper.TABLE_NAME +
                " WHERE " +
                dataHelper.COLUMN_NAME +
                " = '" +
                getIntent().getStringExtra(dataHelper.COLUMN_NAME) + "'", null);

        cursor.moveToFirst();

        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            textView1.setText(cursor.getString(1).toString());
            textView2.setText(cursor.getString(0).toString());
            textView3.setText(cursor.getString(2).toString());
            textView4.setText(cursor.getString(3).toString());
        }

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
