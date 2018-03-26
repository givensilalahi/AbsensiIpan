package com.example.gjsilalahi.absensibisa;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dataHelper;


    private Button mBtnInsertData, mBtnViewData;
    private TextView mTVNIM, mTVDate;
    private Spinner mSPKelas, mSPKet, mSPNamaMhs;

    private String[] arrayNama1 ={
            "ADITIYA GUNANTA",
            "VAREZA SELIN",
            "ABDUL ROHMAN",
            "ELIN SUNSA MAYULIANI",
            "DWI SINTA",
            "JUANDA FAHRIZAL",
            "BANGUN SUDRAJAT",
            "NADYA DAMAYANTI",
            "MUHAMMAD FAJAR PUTRA",
            "VARINDO OCKTA KENEDDI P",
            "DONNY GIOVANNA KARO KARO",
            "YANUARI EKA FITRI",
            "PUTRA SUNAN AGUNG",
            "ABDUL WAHID SEMPURNA",
            "FERLITA PRATIWI ARISANTI",
            "ANASTASYA SEMBIRING",
            "KMS. M. SHOFUAN KHOIRI",
            "SYUKRAN RIZKI",
            "KEFIN PRATAMA",
            "RIDHO ILHAM RENALDO",
            "FITRIAH WULANDARI",
            "DINAR AGUSTINA",
            "ANGGY TIAS KURNIAWAN",
            "ANDRE HERVIANT JULIANO",
            "RICHO ANNAJMAWAN",
            "TIO ARTHA NUGRAHA",
            "YENI ANGGRAINI",
            "YENI LARASWATI",
            "STEVANUS CHRISTIVAN PANJAITAN",
            "HETA UTARI",
            "TOMI KIYATMOKO"
    };

    private String[] arrayNama2 ={
            "TEMEN IPAN",
            "MUSUH IPAN",
            "MANTAN IPAN",
            "PACAR IPAN",
            "SIMPANAN IPAN"
    };

    private String[] arrayNama3 ={
            "ADE INDRIANI SIAGIAN",
            "CINDY APRILYANTI PAKPAHAN",
            "APRILYANTI TAMPUBOLON",
            "DEWI SIAGIAN",
            "GATAU LAGI"
    };


    private String[] arrayNIM1 = {

            "09011181520001",
            "09011181520002",
            "09011181520003",
            "09011181520004",
            "09011181520005",
            "09011181520006",
            "09011181520007",
            "09011181520008",
            "09011181520009",
            "09011181520010",
            "09011181520011",
            "09011181520012",
            "09011181520013",
            "09011181520014",
            "09011181520015",
            "09011181520017",
            "09011181520018",
            "09011181520019",
            "09011181520020",
            "09011181520021",
            "09011181520022",
            "09011181520023",
            "09011181520024",
            "09011181520025",
            "09011181520026",
            "09011181520027",
            "09011181520028",
            "09011181520029",
            "09011181520030",
            "09011181520032",
            "09011381520076"
    };

    private String[] arrayNIM2 ={
            "1234567890",
            "0987654321",
            "1357924680",
            "2468013579",
            "0864213579"
    };

    private String[] arrayNIM3 ={
            "1111111111",
            "2222222222",
            "3333333333",
            "4444444444",
            "5555555555"
    };


    private String[] arrayKelas = {
            "SK6A",
            "SK6B",
            "SK6C"
    };

    private String[] arrayKet = {
            "Masuk",
            "Sakit",
            "Izin",
            "Alfa"
    };

    private String getDateTime() {

        SimpleDateFormat dateFormat = new SimpleDateFormat(

                "yyyy-MM-dd", Locale.getDefault());

        Date date = new Date();

        return dateFormat.format(date);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnInsertData = findViewById(R.id.btnInsertData);
        mBtnViewData = findViewById(R.id.btnView);
        mTVNIM = findViewById(R.id.tvNIMbaru);
        mSPKelas = findViewById(R.id.spKelas);
        mSPKet = findViewById(R.id.spKet);
        mSPNamaMhs = findViewById(R.id.spNamaMhs);
        mTVDate = findViewById(R.id.tvTanggal);

        dataHelper = new DataHelper(this);

        mTVDate.setText(getDateTime());


        final ArrayAdapter<String> adapterKelas = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, arrayKelas);
        adapterKelas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSPKelas.setAdapter(adapterKelas);


        final ArrayAdapter<String> adapterNama1 = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, arrayNama1);
        adapterNama1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        final ArrayAdapter<String> adapterNama2 = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, arrayNama2);
        adapterNama2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        final ArrayAdapter<String> adapterNama3 = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, arrayNama3);
        adapterNama3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSPKelas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int index = mSPKelas.getSelectedItemPosition();
                switch (index){
                    case 0 :
                        mSPNamaMhs.setAdapter(adapterNama1);
                        break;
                    case 1:
                        mSPNamaMhs.setAdapter(adapterNama2);
                        break;
                    case 2:
                        mSPNamaMhs.setAdapter(adapterNama3);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mSPNamaMhs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int index = mSPNamaMhs.getSelectedItemPosition();
                int in = mSPKelas.getSelectedItemPosition();
                switch (in){
                    case 0 :
                        mTVNIM.setText(arrayNIM1[index]);
                        break;
                    case 1 :
                        mTVNIM.setText(arrayNIM2[index]);
                        break;
                    case 2 :
                        mTVNIM.setText(arrayNIM3[index]);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });


        final ArrayAdapter<String> adapterKet = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, arrayKet);
        adapterKet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSPKet.setAdapter(adapterKet);

        mBtnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase sqLiteDatabase = dataHelper.getWritableDatabase();

                String dbInsert = "INSERT INTO " +
                        dataHelper.TABLE_NAME +
                        "(" +
                        dataHelper.COLUMN_NIM +
                        ", " +
                        dataHelper.COLUMN_NAME +
                        ", " +
                        dataHelper.COLUMN_CLASS +
                        "," +
                        dataHelper.COLUMN_INFO +

                        ") VALUES('" +
                        mTVNIM.getText().toString() +
                        "', '" +
                        mSPNamaMhs.getSelectedItem().toString() +
                        "', '" +
                        mSPKelas.getSelectedItem().toString() +
                        "', '" +
                        mSPKet.getSelectedItem().toString() +

                        "');";

                sqLiteDatabase.execSQL(dbInsert);

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();


            }
        });

        mBtnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReadActivity.class);
                startActivity(intent);

            }
        });


    }

}
