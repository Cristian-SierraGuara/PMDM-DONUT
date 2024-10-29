package com.example.a006_donut;

import android.icu.text.RelativeDateTimeFormatter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActEntrega extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private ListView lv1;
    private ListView lv2;
    private EditText et1;


    private  String opciones[] = {"Recogida en tienda", "Pedido a domicilio"};
    private  String direcciones[] = {
            "Coso Real",
            "Piscinas Almeriz",
            "Plaza de Toros",
            "Palacio de Congresos",
            "Kiosco Parque de las Mártires",
            "(programar para cuando esté la Plaza de Toros o el Kiosco indique que tiene un sobre coste de 0,60€)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_act_entrega);

        tv1 = (TextView) findViewById(R.id.tv1_sabor);
        String sabor = getIntent().getStringExtra("sabor");
        tv1.setText(sabor);

        tv2 = (TextView) findViewById(R.id.tv2precio);
        String precio = getIntent().getStringExtra("precio");
        tv2.setText(precio);

        lv1 = (ListView) findViewById(R.id.lista_entrega);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones);
        lv1.setAdapter(adapter);

        lv2 = (ListView) findViewById(R.id.lista_direcciones);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, direcciones);
        lv2.setAdapter(adapter2);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    // Si selecciona la primera opción (Recogida en tienda)
                    et1 = (EditText) findViewById(R.id.tv_direccion);

                    et1.setVisibility(View.INVISIBLE);
                    lv2.setVisibility(View.VISIBLE);

                } else if (i == 1) {
                    // Si selecciona la segunda opción (Pedido a domicilio)
                    et1 = (EditText) findViewById(R.id.tv_direccion);
                    lv2.setVisibility(View.INVISIBLE);
                    et1.setVisibility(View.VISIBLE);
                }
            }
        });






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}