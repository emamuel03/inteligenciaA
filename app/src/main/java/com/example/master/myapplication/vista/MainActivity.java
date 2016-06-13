package com.example.master.myapplication.vista;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.master.myapplication.R;
import com.example.master.myapplication.datos.BDManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnIngresar;
    private BDManager manager;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = new BDManager(this);
        //Pregunta p = new Pregunta();

        /*p.setPregunta("Sufres de violencia fisica");
        p.setNodoSi(0);
        p.setNodoNo(0);
        p.setNodoFinal(true);
        manager.insertar(p);*/

        //cursor = manager.buscarPregunta(1);


        btnIngresar = (Button)findViewById(R.id.btn_ingresar);

        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent abrir = new Intent(this,Main2Activity.class);
        startActivity(abrir);
        Toast.makeText(this,"Actividad dos",Toast.LENGTH_SHORT).show();
    }
}
