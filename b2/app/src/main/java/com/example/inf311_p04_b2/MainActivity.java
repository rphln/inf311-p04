package com.example.inf311_p04_b2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = getIntent();
    }

    public void goBack(View view) {
        double alcohol = input.getDoubleExtra("glasses", 0) * 4.8;
        double weight = input.getDoubleExtra("weight", 1);
        double factor;

        if (input.getStringExtra("fasting") == "s") {
            if (input.getStringExtra("sex") == "m")
                factor = 0.7;
            else
                factor = 0.6;
        } else
            factor = 1.1;

        double rate = alcohol / (weight * factor);
        String message;
        if (rate > 0.2)
            message = "Pessoa alcoolizada.";
        else
            message = "Pessoa NÃO alcoolizada.";

        Intent it = new Intent();
        it.putExtra("result", message);
        it.putExtra("rate", rate);

        setResult(1, it);
        finish();
    }
}