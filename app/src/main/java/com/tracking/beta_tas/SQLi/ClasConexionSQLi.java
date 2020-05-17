package com.tracking.beta_tas.SQLi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClasConexionSQLi extends SQLiteOpenHelper {


    public ClasConexionSQLi(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClasUtilidades.CREAR_TABLA_PROYECTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ ClasUtilidades.BBDD_TAS);
        onCreate(db);
    }
}
