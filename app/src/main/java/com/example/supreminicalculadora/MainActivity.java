package com.example.supreminicalculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        tvResultado = findViewById(R.id.txtResultado);
        Button btnSumar = findViewById(R.id.btnSumar);
        Button btnRestar = findViewById(R.id.btnRestar);
        Button btnMultiplicar = findViewById(R.id.btnMultiplicar);
        Button btnDividir = findViewById(R.id.btnDividir);
        Button btnBorrar = findViewById(R.id.btnBorrar);

        btnSumar.setOnClickListener(v -> calcular("sumar"));
        btnRestar.setOnClickListener(v -> calcular("restar"));
        btnMultiplicar.setOnClickListener(v -> calcular("multiplicar"));
        btnDividir.setOnClickListener(v -> calcular("dividir"));
        btnBorrar.setOnClickListener(v -> borrar());

    }

    private void calcular(String operacion) {
        String strNum1 = num1.getText().toString();
        String strNum2 = num2.getText().toString();

        if (!strNum1.isEmpty() && !strNum2.isEmpty()) {
            try {
                int num1 = Integer.parseInt(strNum1);
                int num2 = Integer.parseInt(strNum2);
                int resultado = 0;

                switch (operacion) {
                    case "sumar":
                        resultado = num1 + num2;
                        break;
                    case "restar":
                        resultado = num1 - num2;
                        break;
                    case "multiplicar":
                        resultado = num1 * num2;
                        break;
                    case "dividir":
                        if (num2 == 0) {
                            tvResultado.setText("No se puede dividir entre 0");
                            return;
                        }
                        resultado = num1 / num2;
                        break;
                }

                tvResultado.setText(String.valueOf(resultado));

            } catch (NumberFormatException e) {
                tvResultado.setText("Entrada no válida");
            }
        } else {
            tvResultado.setText("Ingrese ambos números");
        }
    }

    private void borrar() {

        num1.setText("");
        num2.setText("");
        tvResultado.setText("");

    }


}