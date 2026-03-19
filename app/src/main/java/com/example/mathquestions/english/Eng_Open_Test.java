package com.example.mathquestions.english;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mathquestions.R;
import com.example.mathquestions.databinding.ActivityEngCloseTestBinding;
import com.example.mathquestions.databinding.ActivityEngOpenTestBinding;

public class Eng_Open_Test extends AppCompatActivity {
    private View layout;
    private int index;
    private int que_count = 1;
    private int nt_t;
    private int nt_x;
    private String[] question = {
            "Beautiful",
            "Quick",
            "Travel",
            "Strong",
            "Future",
            "Come",
            "Knowledge",
            "Improve",
            "Important",
            "Lucky"
    };


    private String[] t_j_array = {
            "Chiroyli",
            "Tez",
            "Sayohat",
            "Kuchli",
            "Kelajak",
            "Bormoq",
            "Bilim",
            "Yaxshilamoq",
            "Muhim",
            "Omadli"
    };
    private ActivityEngOpenTestBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eng_open_test);
        binding = ActivityEngOpenTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        out_que_txt();
//        binding.engOpEditText.setOnClickListener(v -> finish());
//        binding.engClTsNext.setOnClickListener(v -> check_ans());
//        binding.engOpRes.setOnClickListener(v->finish());
        binding.engClTsNext.setOnClickListener(v -> {
            check_ans();
            binding.engOpEditText.setText("");
        });
        binding.engClTBackBtn.setOnClickListener(v -> finish());
        binding.engOpRes.setOnClickListener(v -> restart());

    }

    private void restart() {


        binding.engOpEditText.setVisibility(View.VISIBLE);
        binding.enOpAnsEdtx.setVisibility(View.VISIBLE);
        binding.engClTsNext.setVisibility(View.VISIBLE);

        binding.engOpRes.setVisibility(View.GONE);


        binding.engRsTxt.setVisibility(View.GONE);
        binding.engClRsT.setVisibility(View.GONE);
        binding.engClRsX.setVisibility(View.GONE);


        index = 0;
        que_count = 1;
        nt_t = 0;
        nt_x = 0;
        out_que_txt();


    }

    private void check_ans() {

        String user_ans = binding.engOpEditText.getText().toString();
        if (user_ans.isEmpty()) {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast_bg, null);
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
            // XATO MAVJUD BOLGAN JOY layout da xatolik toast.show();
            return;
        }
        if (user_ans.equalsIgnoreCase(t_j_array[index])) { // to'g'ri massiv
            nt_t++;
        } else {
            nt_x++;
        }

        next_que(); // index shu yerda oshadi
    }

    private void next_que() {
        index++;
        que_count++;
        if (index < question.length) { // index hali massivdan chiqmagan
            out_que_txt();
        } else {
            out_rs();
        }
    }


//    private void check_ans() {
//        String user_ans = binding.engOpEditText.getText().toString().trim();
//        if (user_ans.isEmpty()) {
//            Toast toast = new Toast(getApplicationContext());
//            toast.setDuration(Toast.LENGTH_SHORT);
//            toast.setView(layout);// XATO MAVJUD BOLGAN JOY
//            toast.show();
//            return;
//        }
//        if (user_ans.equalsIgnoreCase(question[index])) {
//            nt_t++;
//        } else {
//            nt_x++;
    // hello my name is I
//        }
//        index++;
//        if (index < question.length) {
//            out_que_txt();
//        }
//
//        next_que();
//
//    }
//
//    private void next_que() {
//        index++;
//        que_count++;
//        if (index < t_j_array.length) {
//            out_que_txt();
//        } else {
//            out_rs();
//        }
//    }


    private void out_que_txt() {
        if (que_count == 11) {
            binding.engClTsCounter.setText("10/10");
            binding.enOpAnsEdtx.setText(question[index]);
            out_rs();
        } else if (que_count == 11) {
            out_rs();

        } else {
            binding.engClTsCounter.setText(que_count + "/10");
        }
        binding.enOpAnsEdtx.setText(question[index]);

        binding.engOpEditText.setText("");

    }

    private void out_rs() {

        binding.engRsTxt.setVisibility(View.VISIBLE);
        binding.engClRsT.setVisibility(View.VISIBLE);
        binding.engClRsX.setVisibility(View.VISIBLE);

        binding.engOpEditText.setVisibility(View.GONE);
        binding.enOpAnsEdtx.setVisibility(View.GONE);
        binding.engClTsNext.setVisibility(View.GONE);

        binding.engOpRes.setVisibility(View.VISIBLE);
        binding.engClTsCounter.setText("Tugatildi");

        binding.engRsTxt.setText("Natijalar:");
        binding.engClRsT.setText("To'g'ri javoblar: " + nt_t);
        binding.engClRsX.setText("Xato javoblar: " + nt_x);

    }
}