package com.example.parcial_i;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView temp;
    Spinner spn;
    TabHost tbh;
    Button btn;
    conversor miconversor = new conversor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbh = findViewById(R.id.tbhConver);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("cajero automatico").setContent(R.id.tbcajero).setIndicator("Cajero"));
        tbh.addTab(tbh.newTabSpec("carea").setContent(R.id.tbarea).setIndicator("area"));

        btn = findViewById(R.id.btnConvertir);
        //btn.setOnClickListener(new View.OnClickListener() {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (TextView) findViewById(R.id.txtingresod);
                double cantidad = Double.parseDouble(temp.getText().toString());

                spn = findViewById(R.id.spnde);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spna);
                int a = spn.getSelectedItemPosition();

                temp = findViewById(R.id.lblresultado);
                temp.setText("Respuesta: " + miconversor.convertir(0, de, a, cantidad));
            }
        });
    }
}
class conversor{
    double[][] valores = {


            {1, 668896, 1063.7659033, 94.959681998, 66.36694191, 163.9962849748 },//Area
    };
    public double convertir (int opcion, int de, int a, double cantidad){
        return valores [opcion][a] / valores [opcion][de]* cantidad;
    }
}


