package com.tracking.beta_tas.SQLi;

public class ClasUtilidades {

    public static final String BBDD_TAS = "bbdd_tas";
    public static final String ID = "id";
    public static final String NOMBRE_MUESTREO = "nombre_muestreo";
    public static final String ID_TRANSECTO = "id_transecto";
    public static final String GRUPO_ORGANISMOS = "grupo_organismos";

    public static final String CREAR_TABLA_PROYECTO = "CREATE TABLE "+BBDD_TAS+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NOMBRE_MUESTREO+" TEXT, "+ID_TRANSECTO+" TEXT, "+GRUPO_ORGANISMOS+" TEXT)";



}
