package com.example.hector.pasdeparametres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Activity2 extends AppCompatActivity {
    TextView benv;

    Button btnContinuar;
    Button btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        benv = (TextView) findViewById(R.id.mensaje);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnContinuar = (Button) findViewById(R.id.continuar);
        Intent i = getIntent();

        Bundle parametresRebuts = i.getExtras();
        if(parametresRebuts!=null){

            String elNom = parametresRebuts.getString("nomActivity1");
            benv.setText("Hola "+elNom+" introdueix la teua edat:");
        }

        btnCancelar.setOnClickListener(new View.OnClickListener()  {
            @Override
                 public void onClick(View v){
                 setResult(RESULT_CANCELED);
        finish();
            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
                public  void onClick(View v){
                setResult(RESULT_OK);
                finish();
            }

        });

    }
}
