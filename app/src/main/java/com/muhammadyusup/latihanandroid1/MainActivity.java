package com.muhammadyusup.latihanandroid1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, editPassing, editTitle;
    Button btnShowMsg, btnPassing, btnGantiTitle, btnCapturePicture, btnKonfirmasi;
    ImageView imageView;

    private static final int REQUEST_CODE = 1,
                             RESULT_YES = 4,
                             RESULT_NO = 5,
                             REQUEST_IMAGE_CAPTURE = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.editText);
        editPassing = (EditText) findViewById(R.id.editPassing);
        editTitle = (EditText) findViewById(R.id.editTitle);

        btnShowMsg = (Button) findViewById(R.id.btnShowMsg);
        btnPassing = (Button) findViewById(R.id.btnPassingMsg);
        btnGantiTitle = (Button) findViewById(R.id.btnGantiTitle);
        btnCapturePicture = (Button) findViewById(R.id.btnCapturePicture);
        btnKonfirmasi = (Button) findViewById(R.id.btnKonfirmasi);

        imageView = (ImageView) findViewById(R.id.imageView);


        btnShowMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, edit1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btnPassing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PassingActivity.class);
                intent.putExtra("name", editPassing.getText().toString());
                startActivity(intent);
            }
        });

        btnGantiTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTitle(editTitle.getText().toString());
            }
        });

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, KonfirmasiActivity.class), REQUEST_CODE);
            }
        });

        btnCapturePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ambilFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (ambilFoto.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(ambilFoto, REQUEST_IMAGE_CAPTURE);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_YES){
                Toast.makeText(this, "Confirmed", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_NO){
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_IMAGE_CAPTURE){
            if (resultCode == RESULT_OK){
                Bundle extra = data.getExtras();
                Bitmap bmp = (Bitmap) extra.get("data");
                imageView.setImageBitmap(bmp);
            } else {
                Toast.makeText(this, "Image capture failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
