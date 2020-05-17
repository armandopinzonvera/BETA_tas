package com.tracking.beta_tas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tracking.beta_tas.Fragments.FragMainlp;
import com.tracking.beta_tas.Fragments.FragMainlp2;
import com.tracking.beta_tas.Fragments.fragMainLogo;
import com.tracking.beta_tas.SQLi.ClasConexionSQLi;
import com.tracking.beta_tas.SQLi.ClasUtilidades;

public class MainActivity extends AppCompatActivity {

    FragMainlp f_mainlp;
    fragMainLogo f_mainlogo;
    FragMainlp2 f_mainlp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClasConexionSQLi conn = new ClasConexionSQLi(this, ClasUtilidades.BBDD_TAS, null, 1);

        f_mainlp = new FragMainlp();
        f_mainlogo = new fragMainLogo();
        f_mainlp2 = new FragMainlp2();

        getSupportFragmentManager().beginTransaction().add(R.id.mainFragmentLayout, f_mainlogo).commit();
    }

    public void irIniciar(View view){
        Intent intent1 = new Intent(this, ActIniciar.class);
        startActivity(intent1);
    }



    public void onclick(View view){
        FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){

            case R.id.bt2_ma:
                transaccion.replace(R.id.mainFragmentLayout, f_mainlp);
                break;
           case R.id.bt3_ma:
               transaccion.replace(R.id.mainFragmentLayout, f_mainlp2);
             break;


        } transaccion.commit();

    }
}
