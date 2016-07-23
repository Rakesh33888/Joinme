package com.example.bts.joinme;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Screen3a extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    ImageView imageView;
    Button btn6;
    TextView textView3, textView4;
    EditText editText1, editText2, editText3, editText4;
    Bitmap bitmap;
    android.support.v7.app.ActionBar actionBar;

     TextView textView5;
//    DatePickerDialog.OnDateSetListener dd=new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//
//            // Toast.makeText(first.this,"Year"+year+"Month"+monthOfYear+"Day"+dayOfMonth,Toast.LENGTH_SHORT).show();
//            textView5.setText("Day+Month+year");
//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3aa);
        editText1 = (EditText) findViewById(R.id.editText5);
        editText2 = (EditText) findViewById(R.id.editText6);
        editText3 = (EditText) findViewById(R.id.editText7);
        editText4 = (EditText) findViewById(R.id.editText8);
        imageView = (ImageView) findViewById(R.id.imageView2);
        textView5 = (TextView) findViewById(R.id.editText9);

//        textView5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar cal=Calendar.getInstance();
//                new DatePickerDialog(Screen3a.this,dd,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DATE)).show();
//            }
//        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayOptions(actionBar.getDisplayOptions()
                | actionBar.DISPLAY_SHOW_CUSTOM);
        ImageView imageView4 = new ImageView(actionBar.getThemedContext());
        imageView4.setScaleType(ImageView.ScaleType.CENTER);
        imageView4.setImageResource(R.drawable.logoaction);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER_VERTICAL
                | Gravity.CENTER);
        layoutParams.rightMargin = 40;
        imageView4.setLayoutParams(layoutParams);
        actionBar.setCustomView(imageView4);
        imageView.setClickable(true);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

            }
        });
        btn6 = (Button) findViewById(R.id.button3);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), Screen16.class);
                startActivity(a);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);


                ImageView imageView = (ImageView) findViewById(R.id.imageView2);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {

            }
        }

    }}