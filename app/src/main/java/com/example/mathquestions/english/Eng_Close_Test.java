package com.example.mathquestions.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mathquestions.R;
import com.example.mathquestions.databinding.ActivityEngCloseTestBinding;
import com.example.mathquestions.databinding.ActivityMathCloseTestBinding;
import com.example.mathquestions.databinding.ActivityMathOpenTestBinding;

public class Eng_Close_Test extends AppCompatActivity {
    private int index;
    private int que_count = 1;
    private int nt_t;
    private int nt_x;
    private ActivityEngCloseTestBinding binding;


    private String[] question = {
            "Cold",
            "Happy",
            "Run",
            "Slow",
            "Child",
            "Before",
            "Teacher",
            "Large",
            "Book",
            "Quickly"
    };
    private String[] opt_a = {
            "a) Sovuq",
            "a) Baxtsiz",
            "a) Yugurmoq",
            "a) Tez",
            "a) O‘yinchoq",
            "a) Oldin",
            "a) Haydovchi",
            "a) Kichik",
            "a) Defter",
            "a) Sekin"
    };


    private String[] opt_b = {
            "b) Issiq",
            "b) Hayron",
            "b) Uxlamoq",
            "b) Sekin",
            "b) Katta yoshli",
            "b) Keyin",
            "b) O‘qituvchi",
            "b) Qalin",
            "b) Kitob",
            "b) Juda ko‘p"
    };


    private String[] opt_c = {
            "c) Yengil",
            "c) Baxtli",
            "c) O‘qimoq",
            "c) Uzun",
            "c) Bola",
            "c) Yonida",
            "c) Oshpaz",
            "c) Katta",
            "c) Ruchka",
            "c) Tezda"
    };


    private String[] opt_d = {
            "d) Qalin",
            "d) Og‘ir",
            "d) Yozmoq",
            "d) Past",
            "d) Do‘st",
            "d) Ichida",
            "d) Sotuvchi",
            "d) Arzon",
            "d) Oyna",
            "d) Beozor"
    };

    private int[] t_j_array = {0, 2, 0, 1, 2, 0, 1, 2, 1, 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eng_close_test);
        binding = ActivityEngCloseTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
 int hash = 240;
 String  nn = "Hello World";
 double jj = 12.23;


        out_que_txt();

        binding.engClTsA.setOnClickListener(v -> {
            checker(0);
        });
        binding.engClTsB.setOnClickListener(v -> {
            checker(1);
        });
        binding.engClTsC.setOnClickListener(v -> {
            checker(2);
        });
        binding.engClTsD.setOnClickListener(v -> {
            checker(3);
        });
        binding.engClRes.setOnClickListener(v -> {
            restart();
        });
        binding.engClTBackBtn.setOnClickListener(v -> finish());


    }

    private void checker(int clik_opt) {
        if (clik_opt == t_j_array[index]) {
            nt_t++;
        } else {
            nt_x++;
        }
        next_que();



    }

    private void next_que() {
        index++;
        que_count++;
        if (index < question.length) {
            out_que_txt();
        } else {
            out_rs();
        }

    }

    private void out_rs() {


        binding.enOpRsT.setVisibility(View.VISIBLE);
        binding.engOpRsX.setVisibility(View.VISIBLE);
        binding.enOpRsTxt.setVisibility(View.VISIBLE);
        binding.engClRes.setVisibility(View.VISIBLE);

        binding.engOpTsCounter. setText("Tugatildi");
        binding.enOpRsTxt.setText("Natijalar:");
        binding.enOpRsT. setText("To'g'ri javoblar: " + (nt_t));
        binding.engOpRsX.setText("Xato javoblar: " + (nt_x));


        binding.engOpQueTx.setVisibility(View.GONE);
        binding.engClTsA.setVisibility(View.GONE);
        binding.engClTsB.setVisibility(View.GONE);
        binding.engClTsC.setVisibility(View.GONE);
        binding.engClTsD.setVisibility(View.GONE);


    }

    private void out_que_txt() {
        if (que_count == 11) {
            binding.engOpTsCounter.setText("10/10");
            binding.engOpQueTx.setText(question[index]);
            out_rs();


        } else if (que_count == 11) {
            out_rs();

        } else {
            binding.engOpTsCounter.setText(que_count + "/10");
        }
        binding.engOpQueTx.setText(question[index]);

        binding.engClTsA.setText(opt_a[index]);
        binding.engClTsB.setText(opt_b[index]);
        binding.engClTsC.setText(opt_c[index]);
        binding.engClTsD.setText(opt_d[index]);


    }

    private void restart() {
        index = 0;
        que_count = 1;
        nt_t = 0;
        nt_x = 0;

        binding.engOpQueTx.setVisibility(View.VISIBLE);
        binding.engClTsA.setVisibility(View.VISIBLE);
        binding.engClTsB.setVisibility(View.VISIBLE);
        binding.engClTsC.setVisibility(View.VISIBLE);
        binding.engClTsD.setVisibility(View.VISIBLE);


        binding.enOpRsT.setVisibility(View.GONE);
        binding.engOpRsX.setVisibility(View.GONE);
        binding.enOpRsTxt.setVisibility(View.GONE);


        binding.engClRes.setVisibility(View.GONE);

        out_que_txt();
    }
}