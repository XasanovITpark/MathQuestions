package com.example.mathquestions.english;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mathquestions.R;
import com.example.mathquestions.databinding.ActivityEngTrOrFsBinding;

public class eng_Tr_or_Fs extends AppCompatActivity {
    private ActivityEngTrOrFsBinding binding;
    private int index;
    private int que_count = 1;
    private int nt_t;
    private int nt_x;
    private String[] question = {
            "Dog — bu it.",
            "Blue — rang emas.",
            "Old — yangi degani.",
            "Teacher — kasb nomi.",
            "Strong — kuchli.",
            "Run — uxlamoq.",
            "City — shahar.",
            "A Hour — to'gri so'z",
            "Short — uzun.",
            "Smile — kulmoq."
    };
    private int[] t_j_array = {0, 1, 1, 0, 0, 1, 0, 1, 1, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eng_tr_or_fs);

        binding = ActivityEngTrOrFsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        out_que_txt();

        binding.enTfT.setOnClickListener(v -> checker(0));
        binding.enTfF.setOnClickListener(v -> checker(1));

        binding.engTfRes.setOnClickListener(v -> restart());
        binding.engTfBackBtn.setOnClickListener(v -> finish());


    }

    private void restart() {
        binding.engTfQueTx.setVisibility(View.VISIBLE);
        binding.enTfT.setVisibility(View.VISIBLE);
        binding.enTfF.setVisibility(View.VISIBLE);

        binding.engTfRes.setVisibility(View.GONE);
        binding.enTfRsT.setVisibility(View.GONE);
        binding.enTfRsX.setVisibility(View.GONE);
        binding.enTfRs.setVisibility(View.GONE);

        index = 0;
        que_count = 1;
        nt_t = 0;
        nt_x = 0;
        out_que_txt();


    }

    private void checker(int click_tf) {
        if (click_tf == t_j_array[index]) {
            nt_x++;
        } else {
            nt_t++;
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

        binding.engTfQueTx.setVisibility(View.GONE);
        binding.enTfT.setVisibility(View.GONE);
        binding.enTfF.setVisibility(View.GONE);





        binding.engTfRes.setVisibility(View.VISIBLE);
        binding.enTfRsT.setVisibility(View.VISIBLE);
        binding.enTfRsX.setVisibility(View.VISIBLE);
        binding.enTfRs.setVisibility(View.VISIBLE);

        binding.enTfCounter.setText("Tugatildi");
        binding.enTfRs.setText("Natijlar:");
        binding.enTfRsX.setText("To'gri javoblar: " + (nt_t));
        binding.enTfRsT.setText("Xato javoblar: " + (nt_x));


    }

    private void out_que_txt() {
        if (que_count == 11) {
            binding.enTfCounter.setText("10/10");
            binding.engTfQueTx.setText(question[index]);
            out_rs();
        } else {
            binding.enTfCounter.setText(que_count + "/10");
        }
        binding.engTfQueTx.setText(question[index]);
    }
}