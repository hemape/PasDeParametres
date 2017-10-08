package com.example.hector.pasdeparametres;

import android.content.Intent;
import android.nfc.Tag;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mensaje2;
    private EditText etNom;
    private Button btMesInfo;
    private final String TAG = "prova";

    private int SUBACT_1=345;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btMesInfo = (Button) findViewById(R.id.button);
        etNom = (EditText) findViewById(R.id.introNom);

        btMesInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Nom: " + etNom.getText());


                Intent i = new Intent(getApplicationContext(), Activity2.class);

                Bundle parametresActivity2 = new Bundle();
                parametresActivity2.putString("nomActivity1", etNom.getText().toString());
                i.putExtras(parametresActivity2);
                startActivityForResult(i, SUBACT_1);

            }


        });


    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==SUBACT_1){
            if (resultCode==RESULT_OK){
                Toast.makeText(this,"El subactivity se ha realizado correctamente",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"El subactivity no se ha podido realizar", Toast.LENGTH_LONG).show();
            }
        }
    }
}
