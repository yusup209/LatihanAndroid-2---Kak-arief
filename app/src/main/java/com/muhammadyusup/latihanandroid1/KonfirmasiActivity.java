package com.muhammadyusup.latihanandroid1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KonfirmasiActivity extends AppCompatActivity {

    Button btnConfirmYes, btnConfirmNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);

        btnConfirmYes = (Button) findViewById(R.id.btnConfirmYes);
        btnConfirmNo = (Button) findViewById(R.id.btnConfirmNo);

        btnConfirmYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(4);
                finish();
            }
        });

        btnConfirmNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(5);
                finish();
            }
        });
    }
}
