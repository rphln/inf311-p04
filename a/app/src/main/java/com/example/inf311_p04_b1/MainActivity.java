package com.example.inf311_p04_b1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        String inputSex = ((EditText) findViewById(R.id.editSex)).getText().toString();
        String inputGlasses = ((EditText) findViewById(R.id.editGlasses)).getText().toString();
        String inputFasting = ((EditText) findViewById(R.id.editFasting)).getText().toString();
        String inputWeight = ((EditText) findViewById(R.id.editWeight)).getText().toString();

        if (inputSex.isEmpty() || inputGlasses.isEmpty() || inputFasting.isEmpty() || inputWeight.isEmpty()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_SHORT);
            toast.show();

            return;
        }

        double glasses = Double.parseDouble(inputGlasses);
        double weight = Double.parseDouble(inputWeight);

        Intent it = new Intent(this, ResultActivity.class);
        it.putExtra("sex", inputSex);
        it.putExtra("weight", weight);
        it.putExtra("glasses", glasses);
        it.putExtra("fasting", inputFasting);

        startActivityForResult(it, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String result = data.getStringExtra("result");
        double rate = data.getDoubleExtra("rate", 0);

        Toast toast = Toast.makeText(this, String.format("Taxa de Alcoolemia: %f\nClassificação: %s", rate, result), Toast.LENGTH_LONG);
        toast.show();
    }
}