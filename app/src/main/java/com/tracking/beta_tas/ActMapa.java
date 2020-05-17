package com.tracking.beta_tas;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.net.Uri;
import android.os.Bundle;


import com.tracking.beta_tas.Fragments.FragMapa;

public class ActMapa extends AppCompatActivity implements FragMapa.onFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_mapa);

        Fragment fragmento = new FragMapa();
         getSupportFragmentManager().beginTransaction().replace(R.id.contenedorMapa, fragmento).commit();



    }
    public void onFragmentInteraction(Uri uri){

    }


}
