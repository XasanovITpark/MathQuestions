package com.example.mathquestions.math;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mathquestions.R;
import com.example.mathquestions.databinding.ActivityMathCloseTestBinding;

public class Math_Close_Test extends AppCompatActivity {
    private int index;
    private int que_count = 1;
    private int nt_t;
    private int nt_x;
    private String[] question = {
            "15 + 27 = ?",
            "2.5 + 3.7 = ?",
            "48 - 19 = ?",
            "7.2 - 4.8 = ?",
            "6 × 9 = ?",
            "6.4 ÷ 2 = ?",
            "81 ÷ 9 = ?",
            "5.5 × 1.2 = ?",
            "7² = ?",
            "3.75 + 0.25 = ?"
    };
    private double[] t_j_array = {42, 6.2, 29, 2.4, 54, 3.2, 9, 7, 49, 4};
    private View toastLayout;
    private ActivityMathCloseTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        binding = ActivityMathCloseTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LayoutInflater inflater = getLayoutInflater();
        toastLayout = inflater.inflate(com.example.mathquestions.R.layout.toast_bg, null);
        out_que_txt();
        binding.mathClTsNext.setOnClickListener(v -> {
            check_ans();
            binding.mathOpAnsText.setText("");
        });
        binding.mathClTBackBtn.setOnClickListener(v -> finish());
        binding.mathOpRest.setOnClickListener(v -> restart());

    }

    private void restart() {
        binding.mathOpAnsText.setVisibility(View.VISIBLE);
        binding.mathOpAnsTxt.setVisibility(View.VISIBLE);
        binding.mathClTsNext.setVisibility(View.VISIBLE);

        binding.mathOpRest.setVisibility(View.GONE);


        index = 0;
        que_count = 1;
        nt_t = 0;
        nt_x = 0;

        out_que_txt();


    }

    private void check_ans() {
        String user_ans = binding.mathOpAnsText.getText().toString().trim();
        if (user_ans.isEmpty()) {
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(toastLayout);
            toast.show();
            return;
        }
        double change_db = Double.parseDouble(user_ans);
        if (change_db == t_j_array[index]) {
            nt_t++;
        } else {
            nt_x++;
        }
        next_que();

    }

    private void next_que() {
        index++;
        que_count++;
        if (index < t_j_array.length) {
            out_que_txt();
        } else {
            out_rs();
        }
    }


    private void out_que_txt() {
        if (que_count == 11) {

            binding.mathOpCounter.setText("10/10");
            binding.mathOpAnsTxt.setText(question[index]);
            out_rs();


        } else if (que_count == 11) {
            out_rs();

        } else {
            binding.mathOpCounter.setText(que_count + "/10");
        }
        binding.mathOpAnsTxt.setText(question[index]);


    }

    private void out_rs() {
        binding.mathOpAnsText.setVisibility(View.GONE);
        binding.mathOpAnsTxt.setVisibility(View.GONE);
        binding.mathClTsNext.setVisibility(View.GONE);

        binding.mathOpRest.setVisibility(View.VISIBLE);


        binding.mathClRsT.setText(nt_t);
        binding.mathClRsX.setText(nt_x);

    }
}