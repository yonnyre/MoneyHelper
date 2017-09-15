package com.example.yonny.moneyhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText total;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private String in;
    private String cue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        total = (EditText) findViewById(R.id.editext1);
        spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cue = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void radioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButton1:
                in = "Ingreso";
                break;

            case R.id.radioButton2:
                in = "Egreso";
                break;
        }
    }


    public void register(View view) {
        String c = total.getText().toString();
        String monto = total.getText().toString();

        if (c.isEmpty()) {
            total.setError("Campo requerido");
        }

        if (in == "Ingreso") {
            if (monto.isEmpty()) {
                return;
            }
            Dinero dinero = new Dinero(Double.parseDouble(monto), in, cue);
            DineroRepository dineroRepository = DineroRepository.getInstance();
            dineroRepository.agregarDinero(dinero);
            finish();

        } else {
            if (monto.isEmpty()) {
                return;
            }
            Dinero dinero = new Dinero(Double.parseDouble(monto), in, cue);
            DineroRepository dineroRepository = DineroRepository.getInstance();
            dineroRepository.agregarDinero(dinero);
            finish();
        }
    }
}