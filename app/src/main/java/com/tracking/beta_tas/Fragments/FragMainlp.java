package com.tracking.beta_tas.Fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.tracking.beta_tas.R;
import com.tracking.beta_tas.SQLi.ClasConexionSQLi;
import com.tracking.beta_tas.SQLi.ClasEntidades;
import com.tracking.beta_tas.SQLi.ClasUtilidades;

import java.util.ArrayList;


public class FragMainlp extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

     ListView listView_cont;
     ArrayList<String> listaInformacion;
     ArrayList<ClasEntidades> listaProyectos;
     ClasConexionSQLi conn;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragMainlp() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragMainlp newInstance(String param1, String param2) {
        FragMainlp fragment = new FragMainlp();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag_mainlp, container, false);

        conn = new ClasConexionSQLi(getContext(), ClasUtilidades.BBDD_TAS, null, 1);
        listView_cont = (ListView) view.findViewById(R.id.lv1_fragmainlp);
        consultarListasProyectos();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listaInformacion);
        listView_cont.setAdapter(adapter);
    // METODO PARA CLICK EN LOS ELEMENTOS DEL LISTVIEW
        listView_cont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), "Esta es la Posicion = "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    private void consultarListasProyectos() {

        SQLiteDatabase db = conn.getReadableDatabase();
        ClasEntidades entidades = null;
        listaProyectos = new ArrayList<ClasEntidades>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ClasUtilidades.BBDD_TAS, null);

        while(cursor.moveToNext()){
        entidades = new ClasEntidades();
        entidades.setNombre_muestreo(cursor.getString(1));
        entidades.setId_transecto(cursor.getString(2));

        listaProyectos.add(entidades);
        }
            optenerLista();
    }

    private void optenerLista() {

        listaInformacion = new ArrayList<String>();
        for(int i= 0; i<listaProyectos.size(); i++){
            listaInformacion.add(listaProyectos.get(i).getNombre_muestreo()+" - "+listaProyectos.get(i).getId_transecto());
        }
    }


}

