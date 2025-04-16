package com.example.atvavaliativa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_abaixo_do_peso extends AppCompatActivity {

    private TextView txtIMC, txtPeso, txtAltura, txtMensagem;
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abaixo_do_peso);


        txtMensagem = findViewById(R.id.txt_mensagem);
        btnFechar = findViewById(R.id.btn_fechar_abaixo_peso);


        double imc = getIntent().getDoubleExtra("IMC", 0);
        double peso = getIntent().getDoubleExtra("Peso", 0);
        double altura = getIntent().getDoubleExtra("Altura", 0);

        txtIMC.setText("IMC: " + String.format("%.2f", imc));
        txtPeso.setText("Peso: " + peso + " kg");
        txtAltura.setText("Altura: " + altura + " m");

        txtMensagem.setText("Você está abaixo do peso. Cuide-se!");

        btnFechar.setOnClickListener(v -> {

            finish();
        });
    }
}
