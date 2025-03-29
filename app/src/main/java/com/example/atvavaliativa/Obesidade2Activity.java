package com.example.atvavaliativa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class Obesidade2Activity extends AppCompatActivity {

    private float peso;
    private float altura;
    private float IMC;
    private String classificacao;
    private String FraseMotivacional;
    private TextView textPeso;
    private TextView textAltura;
    private TextView textIMC;
    private TextView textClassificacao;
    private TextView textFraseMotivacional;
    private ImageView btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade2);

        btnFechar = findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        Bundle bundle = getIntent().getExtras();

        peso = bundle.getFloat("peso");
        altura = bundle.getFloat("altura");
        IMC = bundle.getFloat("IMC");
        classificacao = bundle.getString("classificacao");
        FraseMotivacional = bundle.getString("FraseMotivacional");

        textPeso = findViewById(R.id.textPeso);
        textAltura = findViewById(R.id.textAltura);
        textIMC = findViewById(R.id.textIMC);
        textClassificacao = findViewById(R.id.textClassificacao);
        textFraseMotivacional = findViewById(R.id.textFraseMotivacional);

        String formatado = String.format(Locale.US, "%.2f", IMC);

        textPeso.setText(" "+ peso+ "kg");
        textAltura.setText(" "+ altura+"m");
        textIMC.setText(" "+ formatado +" kg/m²");
        textClassificacao.setText(" "+ classificacao);
        textFraseMotivacional.setText(""+ FraseMotivacional);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }
}