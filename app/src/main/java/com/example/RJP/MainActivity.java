package com.example.RJP;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txt;
    TextView archivo;

    private final String nomarch = "nombreRocio.txt";
    private ArrayList<String> nombre = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        archivo = findViewById(R.id.archivo);

        frm2Activity informacion = new frm2Activity();
        if (informacion.VerificaArch(this, nomarch)) {
            Toast.makeText(this, "existe ", Toast.LENGTH_LONG).show();
            if(informacion.leer(this,nomarch)){
                nombre = informacion.getContenido();
                String temp="";
                for (String cadena :nombre) temp+="\n"+cadena;
                archivo.setText(temp);

            }

        } else {
            Toast.makeText(this, "No existe", Toast.LENGTH_LONG).show();
        }
    }

    public void recargar(View v){
        frm2Activity objmanar = new frm2Activity();

        objmanar.agrega(txt.getText().toString(),nombre);
        nombre = objmanar.getContenido();

        if (objmanar.grabar(this, nombre, nomarch)) {
            Toast.makeText(this, "Grabado correctamente ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Nlo se pudo grabnar", Toast.LENGTH_SHORT).show();
        }


    }
}
