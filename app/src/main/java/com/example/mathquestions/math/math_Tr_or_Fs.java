package com.example.mathquestions.math;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mathquestions.R;
import com.example.mathquestions.databinding.ActivityMathTrOrFsBinding;

public class math_Tr_or_Fs extends AppCompatActivity {
    private ActivityMathTrOrFsBinding binding;
    private int index;
    private int que_count = 1;
    private int nt_t;
    private int nt_x;
    private String[] question = {
            "9 × 9 = 81",
            "20 ÷ 4 = 6",
            "1 km = 1000 m",
            "2/3 > 3/4",
            "10² = 100",
            "500 − 2 = 225",
            "66 + 44 = 100",
            "0 musbat son",
            "5! = 120",
            "50% bu yarim"
    };

    private int[] t_j_array = {0, 1, 0, 1, 0, 1, 1, 1, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_math_tr_or_fs);
        binding = ActivityMathTrOrFsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        out_que_txt();

        binding.mathTfT.setOnClickListener(v -> checker(0));
        binding.mathTfF.setOnClickListener(v -> checker(0));
        binding.mathTfBackBtn.setOnClickListener(v -> finish());
        binding.mathTfRes.setOnClickListener(v -> restart());

    }

    private void restart() {
        binding.mathTfRes.setVisibility(View.GONE);
        binding.mathTfRs.setVisibility(View.GONE);
        binding.mathTfRsT.setVisibility(View.GONE);
        binding.mathTfRsX.setVisibility(View.GONE);

        binding.mathTfQueTx.setVisibility(View.VISIBLE);
        binding.mathTfT.setVisibility(View.VISIBLE);
        binding.mathTfF.setVisibility(View.VISIBLE);

        index = 0;
        que_count = 1;
        nt_t = 0;
        nt_x = 0;
        out_que_txt();
    }

    private void checker(int clivk_tf) {
        if (clivk_tf == t_j_array[index]) {
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

    private void out_que_txt() {
        if (que_count == 11) {
            binding.mathTfCounter.setText("10/10");
            binding.mathTfQueTx.setText(question[index]);
            out_rs();
        } else {
            binding.mathTfCounter.setText(que_count + "/10");
        }
        binding.mathTfQueTx.setText(question[index]);
    }

    private void out_rs() {
        binding.mathTfQueTx.setVisibility(View.GONE);
        binding.mathTfT.setVisibility(View.GONE);
        binding.mathTfF.setVisibility(View.GONE);


        binding.mathTfRs.setVisibility(View.VISIBLE);
        binding.mathTfRsT.setVisibility(View.VISIBLE);
        binding.mathTfRsX.setVisibility(View.VISIBLE);
        binding.mathTfRes.setVisibility(View.VISIBLE);

        binding.mathTfCounter.setText("Tugatildi");
        binding.mathTfRs.setText("Natijlar:");
        binding.mathTfRsT.setText("To'gri javoblar: " + (nt_t));
        binding.mathTfRsX.setText("Xato javoblar: " + (nt_x));
    }
}