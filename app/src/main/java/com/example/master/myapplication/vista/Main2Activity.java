package com.example.master.myapplication.vista;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master.myapplication.R;
import com.example.master.myapplication.datos.BDHelper;
import com.example.master.myapplication.datos.BDManager;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtPregunta;
    private Button btnSi;
    private Button btnNo;
    private Button btnFinalizar;
   private Cursor c;
    private BDHelper helper = new BDHelper(this);
    private BDManager manager;
    private int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        txtPregunta = (TextView)findViewById(R.id.txt_pregunta);
        btnSi = (Button)findViewById(R.id.btn_si);
        btnNo = (Button)findViewById(R.id.btn_no);
        btnFinalizar = (Button)findViewById(R.id.btn_finalizar);

        manager = new BDManager(this);
        leerPregunta();

        btnSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sn = "si";
                motorDeInferencia(txtPregunta, sn);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sn = "no";
                motorDeInferencia(txtPregunta, sn);
            }
        });

        btnFinalizar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Abrir actividad principal",Toast.LENGTH_SHORT).show();
    }

    public void motorDeInferencia(TextView pregunta,String sn){

        if(sn.equals("si")){
            i = c.getInt(c.getColumnIndex(BDManager.CN_NODOSI));
        }
        else {

            i = c.getInt(c.getColumnIndex(BDManager.CN_NODONO));
        }
        leerPregunta();

        int nf = (c.getInt(c.getColumnIndex(BDManager.CN_NODOFINAL)));
        if(nf == 1) {
            finalizarConversacion();
            i = 1;
        }
    }

    public void finalizarConversacion(){
        btnSi.setVisibility(View.INVISIBLE);
        btnNo.setVisibility(View.INVISIBLE);
        btnFinalizar.setVisibility(View.VISIBLE);
    }

    public void leerPregunta(){
        c = manager.buscarPregunta(i);
        c.moveToFirst();
        txtPregunta.setText(c.getString(c.getColumnIndex(BDManager.CN_PREGUNTA)));
    }
}
