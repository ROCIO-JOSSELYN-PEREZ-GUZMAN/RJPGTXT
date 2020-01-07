package com.example.RJP;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

    public class frm2Activity {

        private ArrayList<String> nombre = new ArrayList<String>();

        public boolean VerificaArch(Context context, String nomarc) {
            String[]archivos = context.fileList();
            for (String verifica : archivos){
                if (verifica.equals(nomarc)) return  true;
            }
            return false;

        }

        public boolean grabar(Context context, ArrayList<String> dato, String nomarch) {
            try {

                OutputStreamWriter archivo= new OutputStreamWriter(context.openFileOutput(nomarch, Activity.MODE_PRIVATE));
                for(String Texto:dato)
                    archivo.write(Texto + "\n");
                archivo.flush();
                archivo.close();

            }catch (Exception e){
                e.printStackTrace();
                return false;
            }

            return true;
        }

        public boolean leer(Context context, String nomarch) {
            try {
                InputStreamReader archivo = new InputStreamReader(context.openFileInput(nomarch));
                BufferedReader br =  new BufferedReader(archivo);
                String cadena = br.readLine();

                while (cadena!=null){
                    nombre.add(cadena);
                    cadena=br.readLine();
                }

            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
            return true;
        }

        public ArrayList<String> getContenido() {
            return nombre;
        }


        public void agrega(String dato, ArrayList<String> TextoCompleto) {
            this.nombre = TextoCompleto;
            this.nombre.add(dato);
        }
    }


