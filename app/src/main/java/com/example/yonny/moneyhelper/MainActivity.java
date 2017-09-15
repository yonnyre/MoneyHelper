package com.example.yonny.moneyhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REGISTER_FORM_REQUEST = 100;

    private TextView a1, a2, a3;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a1 = (TextView) findViewById(R.id.saldoAhorro);
        a2 = (TextView) findViewById(R.id.saldoCredito);
        a3 = (TextView) findViewById(R.id.saldoEfectivo);
        progressbar = (ProgressBar) findViewById(R.id.progressbar1);

    }

    public void addItem(View view) {
        startActivityForResult(new Intent(this, Main2Activity.class), REGISTER_FORM_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        DineroRepository dineroRepository = DineroRepository.getInstance();
        List<Dinero> dineros = dineroRepository.getDineros();

        double total = 0;
        double total1 = 0;
        double total2 = 0;


        for (Dinero dinero : dineros) {
            if (dinero.getCuenta().equals("Tarjeta de Credito")) {
                if (dinero.getRegistro() == "Ingreso") {
                    total = total + dinero.getMonto();
                    a2.setText("S/." + total);
                    double todo = (total + total1 + total2)/100;

                    int p = (int) todo;
                    progressbar.setProgress(p);


                } else {
                    total = total - dinero.getMonto();
                    a2.setText("S/." + total);
                    double todo = (total + total1 + total2)/100;
                    int p = (int) todo;
                    progressbar.setProgress(p);
                }
            } else if (dinero.getCuenta().equals("Ahorro")) {
                if (dinero.getRegistro() == "Ingreso") {
                    total1 = total1 + dinero.getMonto();
                    a1.setText("S/." + total1);
                    double todo = (total + total1 + total2)/100;
                    int p = (int) todo;
                    progressbar.setProgress(p);
                } else {
                    total1 = total1 - dinero.getMonto();
                    a1.setText("S/." + total1);
                    double todo = (total + total1 + total2)/100;
                    int p = (int) todo;
                    progressbar.setProgress(p);
                }

            } else {
                if (dinero.getRegistro() == "Ingreso") {
                    total2 = total2 + dinero.getMonto();
                    a3.setText("S/." + total2);
                    double todo = (total + total1 + total2)/100;
                    int p = (int) todo;
                    progressbar.setProgress(p);
                } else {
                    total2 = total2 - dinero.getMonto();
                    a3.setText("S/." + total2);
                    double todo = (total + total1 + total2)/100;
                    int p = (int) todo;
                    progressbar.setProgress(p);
                }
            }
        }
    }
}