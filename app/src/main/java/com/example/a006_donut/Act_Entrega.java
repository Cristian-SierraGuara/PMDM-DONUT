package com.example.a006_donut;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Act_Entrega extends AppCompatActivity {
    private ListView lv1;
    private TextView tv1;
    private  String opciones[] = {"Recogida en tienda", "Pedido a domicilio"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_act_entrega);



        tv1 = (TextView) findViewById(R.id.tv1_sabor);

        //Obtener el parametro y mostrarlo en el textView
        String sabor = getIntent().getStringExtra("sabor");
        tv1.setText(sabor);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}