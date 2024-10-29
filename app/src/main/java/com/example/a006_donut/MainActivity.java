package com.example.a006_donut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText eligeSabor;
    private TextView mensajePreparado;
    private CheckBox lacasito,pepitaChoco,nata,crema,kitkat,nubes;
    private double precio = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        eligeSabor = (EditText) findViewById(R.id.eligeSabor);
        lacasito = (CheckBox) findViewById(R.id.lacasito);
        pepitaChoco = (CheckBox) findViewById(R.id.pepitaChocolate);
        nata = (CheckBox) findViewById(R.id.nata);
        crema = (CheckBox) findViewById(R.id.crema);
        kitkat = (CheckBox) findViewById(R.id.kitkat);
        nubes = (CheckBox) findViewById(R.id.nubes);

        mensajePreparado = (TextView) findViewById(R.id.mensajePreparado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public double calculaDonut(){

        String sabor = eligeSabor.getText().toString();

        if(sabor.isEmpty()){
            mensajePreparado.setText("No has elegido un sabor");

        }else{

            precio=+2.0;

            if(lacasito.isChecked()){
                precio += 0.60;
            }
            if(pepitaChoco.isChecked()){
                precio+=1;
            }
            if(nata.isChecked()){
                precio+=1.2;
            }
            if(crema.isChecked()){
                precio+=1.5;
            }
            if(kitkat.isChecked()){
                precio+=0.9;
            }
            if(nubes.isChecked()){
                precio+=0.8;
            }
            mensajePreparado.setText("¡Preparado! Su precio es: "+ Double.toString(precio));
            return precio;
        }
        return 0;
    }
    public void visataWeb (View view){
        Intent paginaWebPage = new Intent(this, ActivityWeb.class);
        startActivity(paginaWebPage);
    }

    public void PasaPagina (View view){
        Intent siguiente = new Intent(this, ActEntrega.class);
        //Para pasar parametros entre activitys, Donde "usuario" es el nombre del parametro que recibe la otra activity
        String precio = Double.toString(calculaDonut());
        siguiente.putExtra("sabor",eligeSabor.getText().toString());
        siguiente.putExtra("precio",precio);

        startActivity(siguiente);
    }
    public void close(View view){
        finish();
    }
}