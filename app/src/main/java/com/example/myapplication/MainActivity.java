package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etHeight, etWeight;
    Button btnCalculate;
    TextView tvResult;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.0");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etHeight.getText().toString().isEmpty() || etWeight.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Enter all Fields!", Toast.LENGTH_SHORT).show();
                }
                else {
                    double heightInCm = Double.parseDouble(etHeight.getText().toString().trim());
                    double weightInKg = Double.parseDouble(etWeight.getText().toString().trim());

                    // Convert height from cm to meters
                    double heightInMeters = heightInCm / 100.0;

                    double bmi = weightInKg / (heightInMeters * heightInMeters);

                    String results;

                    if (bmi < 18.6) {
                        results = "Under Weight \n BMI: " + bmi;
                    }
                    else if (bmi >= 18.6 && bmi<24.9) {
                        results = "Normal \n BMI: " + formatter.format(bmi);
                    }
                    else {
                        results = "Over Weight \n BMI: " + formatter.format(bmi);
                    }

                    tvResult.setText(results);

                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}