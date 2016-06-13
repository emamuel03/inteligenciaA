package com.example.master.myapplication.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.master.myapplication.modelo.Pregunta;

/**
 * Created by Master on 09/06/2016.
 */
public class BDManager {
    public static final String TABLE_NAME = "preguntas";
    public static final String CN_ID = "_id";
    public static final String CN_PREGUNTA = "pregunta";
    public static final String CN_NODOSI = "nodo_si";
    public static final String CN_NODONO = "nodo_no";
    public static final String CN_NODOFINAL = "nodo_final";

    /*create table preguntas(
                                _id integer primary key autoincrement,
                                pregunta text not null,
                                nodo_si integer not null,
                                nodo_no integer not null,
                                nodo_final boolean not null)
     */

    public static final String CREATE_TABLE = " create table " +TABLE_NAME+" ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_PREGUNTA + " text not null,"
            + CN_NODOSI + " integer not null,"
            + CN_NODONO + " integer not null,"
            + CN_NODOFINAL + " boolean not null);";


    private BDHelper helper;
    private SQLiteDatabase db;
    public BDManager(Context context) {
        helper = new BDHelper(context);
        db = helper.getWritableDatabase();
    }

    public ContentValues generarContenedor(Pregunta p){
        ContentValues valores = new ContentValues();
        valores.put(CN_PREGUNTA, p.getPregunta());
        valores.put(CN_NODOSI, p.getNodoSi());
        valores.put(CN_NODONO, p.getNodoNo());
        valores.put(CN_NODOFINAL, p.isNodoFinal());

        return valores;
    }

    public void insertar(Pregunta p){

        db.insert(TABLE_NAME, null, generarContenedor(p));

    }

    public void eliminar(Pregunta p){
        db.delete(TABLE_NAME, CN_PREGUNTA + "=?",new String[]{p.getPregunta()});
    }

    public void modificarPregunta(Pregunta p){
        db.update(TABLE_NAME, generarContenedor(p),CN_PREGUNTA + "=?",new String[]{p.getPregunta()});
    }

    public Cursor buscarPregunta(int  id){
        String[] columnas = new String[]{CN_ID, CN_PREGUNTA, CN_NODOSI, CN_NODONO, CN_NODOFINAL};
        return db.query(TABLE_NAME, columnas, CN_ID + "=?", new String[]{String.valueOf(id)}, null,null,null);
        }


}


