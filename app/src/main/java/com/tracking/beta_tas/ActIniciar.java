package com.tracking.beta_tas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tracking.beta_tas.SQLi.ClasConexionSQLi;
import com.tracking.beta_tas.SQLi.ClasUtilidades;

public class ActIniciar extends AppCompatActivity {

    EditText nombre_muestreo, id_transecto, grupo_organismos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_iniciar);

        nombre_muestreo = (EditText) findViewById(R.id.et_nombreMuestreo);
        id_transecto = (EditText) findViewById(R.id.et_idTransecto);
        grupo_organismos = (EditText) findViewById(R.id.et_grupoOrganismos);

    }
    public void onClickVolver(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
    public void onClickMAPA(View view){
        Intent intent2 = new Intent(this, ActMapa.class);
        startActivity(intent2);
    }
    public void onClickMAPA2(View view){
        Intent intent3 = new Intent(this, Act2mapa.class);
        startActivity(intent3);
    }


    public void onClickCrear(View view){
    crearproyecto();
        }

    private void crearproyecto() {


    ClasConexionSQLi conn = new ClasConexionSQLi(this, ClasUtilidades.BBDD_TAS, null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ClasUtilidades.NOMBRE_MUESTREO, nombre_muestreo.getText().toString());
        values.put(ClasUtilidades.ID_TRANSECTO, id_transecto.getText().toString());
        values.put(ClasUtilidades.GRUPO_ORGANISMOS, grupo_organismos.getText().toString());

        Long idResultante = db.insert(ClasUtilidades.BBDD_TAS, ClasUtilidades.ID_TRANSECTO, values);
        Toast.makeText(getApplicationContext(), "Numero de Registro = "+idResultante, Toast.LENGTH_LONG).show();
        nombre_muestreo.setText("");
        id_transecto.setText("");
        grupo_organismos.setText("");
    }





}
