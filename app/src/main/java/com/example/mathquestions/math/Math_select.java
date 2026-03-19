package com.example.mathquestions.math;

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

public class Math_select extends AppCompatActivity {
    ConstraintLayout cl_test_card, op_test_card, tf_test_card;
    ImageView cl_test_img, op_test_img, tf_test_img, math_sc_back;
    TextView cl_test_txt, op_test_txt, tf_test_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_math_select);

       math_sc_back = findViewById(R.id.math_sct_back1);

        cl_test_card = findViewById(R.id.math_card_option);
        cl_test_img = findViewById(R.id.math_option_png);
        cl_test_txt = findViewById(R.id.math_card_txt);

        op_test_card = findViewById(R.id.math_openTest_card);
        op_test_img = findViewById(R.id.math_openTest_png);
        op_test_txt = findViewById(R.id.math_card_txt1);

        tf_test_card = findViewById(R.id.math_checking_ct);
        tf_test_img = findViewById(R.id.math_checking_png);
        tf_test_txt = findViewById(R.id.math_checking_txt);

        math_sc_back.setOnClickListener(v -> finish());

        cl_test_card.setOnClickListener(v -> {
            Intent intent = new Intent(Math_select.this, Math_Open_Test.class);
            startActivity(intent);
        });
        cl_test_img.setOnClickListener(v -> {
            Intent intent = new Intent(Math_select.this, Math_Open_Test.class);
            startActivity(intent);
        });
        cl_test_txt.setOnClickListener(v -> {
            Intent intent = new Intent(Math_select.this, Math_Open_Test.class);
            startActivity(intent);
        });


        tf_test_card.setOnClickListener(v -> {
            Intent intent = new Intent(Math_select.this, math_Tr_or_Fs.class);
            startActivity(intent);
        });
        tf_test_img.setOnClickListener(v -> {
            Intent intent = new Intent(Math_select.this, math_Tr_or_Fs.class);
            startActivity(intent);
        });
        tf_test_txt.setOnClickListener(v -> {
            Intent intent = new Intent(Math_select.this, math_Tr_or_Fs.class);
            startActivity(intent);
        });


        op_test_card.setOnClickListener(v -> {
            Intent intent = new Intent(Math_select.this, Math_Close_Test.class);
            startActivity(intent);
        });
        op_test_img.setOnClickListener(v -> {
            Intent intent = new Intent(Math_select.this, Math_Close_Test.class);
            startActivity(intent);
        });
        op_test_txt.setOnClickListener(v -> {
            Intent intent = new Intent(Math_select.this, Math_Close_Test.class);
            startActivity(intent);
        });


    }
}