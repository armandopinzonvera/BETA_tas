package com.tracking.beta_tas.SQLi;

public class ClasEntidades {

    private Integer id;
    private String nombre_muestreo;
    private String id_transecto;
    private String grupo_organismos;

    public ClasEntidades(Integer id, String nombre_muestreo, String id_transecto, String grupo_organismos) {
        this.id = id;
        this.nombre_muestreo = nombre_muestreo;
        this.id_transecto = id_transecto;
        this.grupo_organismos = grupo_organismos;
    }
    public ClasEntidades(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_muestreo() {
        return nombre_muestreo;
    }

    public void setNombre_muestreo(String nombre_muestreo) {
        this.nombre_muestreo = nombre_muestreo;
    }

    public String getId_transecto() {
        return id_transecto;
    }

    public void setId_transecto(String id_transecto) {
        this.id_transecto = id_transecto;
    }

    public String getGrupo_organismos() {
        return grupo_organismos;
    }

    public void setGrupo_organismos(String grupo_organismos) {
        this.grupo_organismos = grupo_organismos;
    }
}
