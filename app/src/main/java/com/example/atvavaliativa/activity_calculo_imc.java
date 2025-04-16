package com.example.atvavaliativa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity_calculo_imc extends AppCompatActivity {

    private EditText edtPeso, edtAltura;
    private Button btnCalcular, btnLimpar, btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        edtPeso = findViewById(R.id.edt_peso);
        edtAltura = findViewById(R.id.edt_altura);
        btnCalcular = findViewById(R.id.btn_calcular_imc);
        btnLimpar = findViewById(R.id.btn_limpar);
        btnFechar = findViewById(R.id.btn_fechar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesoStr = edtPeso.getText().toString();
                String alturaStr = edtAltura.getText().toString();

                if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
                    Toast.makeText(activity_calculo_imc.this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                double peso = Double.parseDouble(pesoStr);
                double altura = Double.parseDouble(alturaStr);

                double imc = peso / (altura * altura);

                Intent intent;
                if (imc < 18.5) {
                    intent = new Intent(activity_calculo_imc.this, activity_abaixo_do_peso.class);
                } else if (imc >= 18.5 && imc < 24.9) {
                    intent = new Intent(activity_calculo_imc.this, activity_peso_normal.class);
                } else if (imc >= 25 && imc < 29.9) {
                    intent = new Intent(activity_calculo_imc.this, activity_sobrepeso.class);
                } else if (imc >= 30 && imc < 34.9) {
                    intent = new Intent(activity_calculo_imc.this, activity_obesidade1.class);
                } else if (imc >= 35 && imc < 39.9) {
                    intent = new Intent(activity_calculo_imc.this, activity_obesidade2.class);
                } else {
                    intent = new Intent(activity_calculo_imc.this, activity_obesidade3.class);
                }


                intent.putExtra("IMC", imc);
                intent.putExtra("Peso", peso);
                intent.putExtra("Altura", altura);
                startActivity(intent);
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPeso.setText("");
                edtAltura.setText("");
            }
        });

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(activity_calculo_imc.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
