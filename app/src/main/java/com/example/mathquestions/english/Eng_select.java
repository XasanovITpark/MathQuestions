package com.example.mathquestions.english;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mathquestions.R;

public class Eng_select extends AppCompatActivity {
    ConstraintLayout cl_test_card_eng, op_test_card_eng, en_tf_card;
    ImageView cl_test_img_eng, op_test_img_eng, en_tf_img , eng_sc_back;
    TextView cl_test_txt_eng, op_test_txt_eng, en_tf_txt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eng_select);

        eng_sc_back = findViewById(R.id.eng_sct_back);

        cl_test_card_eng = findViewById(R.id.eng_card_option);
        cl_test_img_eng = findViewById(R.id.eng_option_png);
        cl_test_txt_eng = findViewById(R.id.math_card_txt);

        op_test_card_eng = findViewById(R.id.eng_openTest_card);
        op_test_img_eng = findViewById(R.id.math_openTest_png);
        op_test_txt_eng = findViewById(R.id.math_card_txt1);

        en_tf_card = findViewById(R.id.eng_checking_ct);// xato bor endi
        en_tf_img = findViewById(R.id.math_checking_png);
        en_tf_txt = findViewById(R.id.math_checking_txt);


        eng_sc_back.setOnClickListener(v -> finish());

        cl_test_card_eng.setOnClickListener(v -> {
            Intent intent = new Intent(Eng_select.this, Eng_Open_Test.class);
            startActivity(intent);
        });
        cl_test_img_eng.setOnClickListener(v -> {
            Intent intent = new Intent(Eng_select.this, Eng_Open_Test.class);
            startActivity(intent);
        });
        cl_test_txt_eng.setOnClickListener(v -> {
            Intent intent = new Intent(Eng_select.this, Eng_Open_Test.class);
            startActivity(intent);
        });

//
        en_tf_card.setOnClickListener(v -> {
            Intent intent = new Intent(Eng_select.this, eng_Tr_or_Fs.class);
            startActivity(intent);
        });
        en_tf_img.setOnClickListener(v -> {
            Intent intent = new Intent(Eng_select.this, eng_Tr_or_Fs.class);
            startActivity(intent);
        });
//
        en_tf_txt.setOnClickListener(v -> {
            Intent intent = new Intent(Eng_select.this, eng_Tr_or_Fs.class);
            startActivity(intent);
        });
//
//
        op_test_card_eng.setOnClickListener(v -> {
            Intent intent = new Intent(Eng_select.this, Eng_Close_Test.class);
            startActivity(intent);
        });
        op_test_img_eng.setOnClickListener(v -> {
            Intent intent = new Intent(Eng_select.this, Eng_Close_Test.class);
            startActivity(intent);
        });
        op_test_txt_eng.setOnClickListener(v -> {
            Intent intent = new Intent(Eng_select.this, Eng_Close_Test.class);
            startActivity(intent);
        });

    }
}