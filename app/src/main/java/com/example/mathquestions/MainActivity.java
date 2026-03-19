package com.example.mathquestions;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mathquestions.english.Eng_select;
import com.example.mathquestions.math.Math_select;

public class MainActivity extends AppCompatActivity {
    ImageView english, mathematic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        english = findViewById(R.id.math_png);
        mathematic = findViewById(R.id.eng_png);

        english.setOnClickListener(v -> {
            Intent intent  = new Intent(MainActivity.this, Eng_select.class);
            startActivity(intent);
        });
        mathematic.setOnClickListener(v -> {
            Intent intent  = new Intent(MainActivity.this, Math_select.class);
            startActivity(intent);
        });


    }
}