package com.example.mathquestions.math;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mathquestions.R;
import com.example.mathquestions.databinding.ActivityMathOpenTestBinding;
import com.example.mathquestions.english.Eng_Close_Test;
import com.example.mathquestions.english.Eng_select;

public class Math_Open_Test extends AppCompatActivity {

    private int index;
    private int que_count = 1;
    private int nt_t;
    private int nt_x;
    private ActivityMathOpenTestBinding binding;


    private String[] question = {
            "12 × 4 =",
            "45 ÷ 5 =",
            "7² =",
            "√81 =",
            "120 – 45 =",
            "3x = 27 -> x =",
            "P = 2(a + b) qaysi shaklga tegishli?",
            "1 soat nechta daqiqa?",
            "2.5 + 3.75 =",
            "15% ning 200 dan qiymati:"
    };
    private String[] opt_a = {"a) 36", "a) 8", "a) 14", "a) 8", "a) 65", "a) 6", "a) Aylana", "a) 60", "a) 6.25", "a) 15"};
    private String[] opt_b = {"b) 48", "b) 9", "b) 49", "b) 9", "b) 70", "b) 8", "b) To‘g‘ri to‘rtburchak", "b) 90", "b) 5.00", "b) 25"};
    private String[] opt_c = {"c) 52", "c) 10", "c) 56", "c) 10", "c) 75", "c) 9", "c) Uchburchak", "c) 100", "c) 7.00", "c) 30"};
    private String[] opt_d = {"d) 44", "d) 7", "d) 42", "d) 7", "d) 80", "d) 12", "d) Kub", "d) 30", "d) 6.00", "d) 20"};

    private int[] t_j_array = {1, 1, 1, 1, 2, 2, 1, 0, 0, 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        binding = ActivityMathOpenTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        out_que_txt();

        binding.mathClTsA.setOnClickListener(v -> {
            checker(0);
        });
        binding.mathClTsB.setOnClickListener(v -> {
            checker(1);
        });
        binding.mathClTsC.setOnClickListener(v -> {
            checker(2);
        });
        binding.mathClTsD.setOnClickListener(v -> {
            checker(3);
        });
        binding.mathClRes.setOnClickListener(v -> {
            restart();
        });
        binding.mathClTBackBtn.setOnClickListener(v -> finish());



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


        binding.mathClRsT.setVisibility(View.VISIBLE);//math_cl_rs_t
        binding.mathClRsX.setVisibility(View.VISIBLE);
        binding.mathClRs. setVisibility(View.VISIBLE);
        binding.mathClCounter.setText("Tugatildi");
        binding.mathClRs.setText("Natijalar:");
        binding.mathClRsT. setText("To'g'ri javoblar: " + (nt_t));
        binding.mathClRsX.setText("Xato javoblar: " + (nt_x));

        binding.mathClRes.setVisibility(View.VISIBLE);
        binding.mathClQueTx.setVisibility(View.GONE);
        binding.mathClTsA.setVisibility(View.GONE);
        binding.mathClTsB.setVisibility(View.GONE);
        binding.mathClTsC.setVisibility(View.GONE);
        binding.mathClTsD.setVisibility(View.GONE);


    }

    private void out_que_txt() {
        if (que_count == 11) {
            binding.mathClCounter.setText("10/10");
            binding.mathClQueTx.setText(question[index]);
            out_rs();


        } else if (que_count == 11) {
            out_rs();

        } else {
            binding.mathClCounter.setText(que_count + "/10");
        }
        binding.mathClQueTx.setText(question[index]);//math_cl_que_tx

        binding.mathClTsA.setText(opt_a[index]);
        binding.mathClTsB.setText(opt_b[index]);
        binding.mathClTsC.setText(opt_c[index]);
        binding.mathClTsD.setText(opt_d[index]);


    }

    private void restart() {
        index = 0;
        que_count = 1;
        nt_t = 0;
        nt_x = 0;

        binding.mathClQueTx.setVisibility(View.VISIBLE);
        binding.mathClTsA.setVisibility(View.VISIBLE);
        binding.mathClTsB.setVisibility(View.VISIBLE);
        binding.mathClTsC.setVisibility(View.VISIBLE);
        binding.mathClTsD.setVisibility(View.VISIBLE);


        binding.mathClRsT.setVisibility(View.GONE);
        binding.mathClRsX.setVisibility(View.GONE);
        binding.mathClRs.setVisibility(View.GONE);


        binding.mathClRes.setVisibility(View.GONE);

        out_que_txt();
    }
}