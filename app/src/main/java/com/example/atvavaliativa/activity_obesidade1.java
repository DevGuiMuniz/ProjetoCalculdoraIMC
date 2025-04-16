package com.example.atvavaliativa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class activity_obesidade1 extends AppCompatActivity {

    private TextView txtIMC, txtPeso, txtAltura, txtMensagem;
    private ImageView imgCategoria;
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obesidade1);

        txtIMC = findViewById(R.id.txt_imc);
        txtPeso = findViewById(R.id.txt_peso);
        txtAltura = findViewById(R.id.txt_altura);
        txtMensagem = findViewById(R.id.txt_mensagem);
        imgCategoria = findViewById(R.id.img_categoria);
        btnFechar = findViewById(R.id.btn_fechar);

        double imc = getIntent().getDoubleExtra("IMC", 0);
        double peso = getIntent().getDoubleExtra("Peso", 0);
        double altura = getIntent().getDoubleExtra("Altura", 0);

        txtIMC.setText("IMC: " + String.format("%.2f", imc));
        txtPeso.setText("Peso: " + peso + " kg");
        txtAltura.setText("Altura: " + altura + " m");

        txtMensagem.setText("Atenção! Pequenos passos fazem grandes mudanças. Procure hábitos mais saudáveis.");
        imgCategoria.setImageResource(R.drawable.imc);

        btnFechar.setOnClickListener(v -> finish());
    }
}
