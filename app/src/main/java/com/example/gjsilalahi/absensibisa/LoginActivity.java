package com.example.gjsilalahi.absensibisa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button button;
    EditText editText1, editText2;
    String text1, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1 = findViewById(R.id.etUser);
        editText2 = findViewById(R.id.etPass);
        button = findViewById(R.id.btnLogin);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (editText1.getText().toString().equals("admin") && editText2.getText().toString().equals("admin"))
                {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Login Sukses!", Toast.LENGTH_SHORT).show();
                }

                else if (editText1.getText().equals("") || editText2.getText().equals(""))

                {

                    Toast.makeText(getApplicationContext(), "Isikan Username dan Password", Toast.LENGTH_SHORT).show();

                }

                else {

                    Toast.makeText(getApplicationContext(), "Login Gagal /Username Password Salah", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
