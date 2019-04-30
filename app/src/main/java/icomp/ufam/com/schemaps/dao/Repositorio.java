package icomp.ufam.com.schemaps.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import icomp.ufam.com.schemaps.Base.Country;

public class Repositorio {
    private SQLHelper helper;
    private SQLiteDatabase db;

    public Repositorio(Context ctx){
        helper = new SQLHelper(ctx);
    }

    public long inserir(Country country){
        db = helper.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(SQLHelper.COLUNA_NOME, country.nome);
        cv.put(SQLHelper.COLUNA_CAPITAL, country.capital);
        cv.put(SQLHelper.COLUNA_CONTINENTE, country.continente);
        cv.put(SQLHelper.COLUNA_SUBREGIAO, country.subregiao);
        try {
            cv.put(SQLHelper.COLUNA_LATITUDE, country.latitudeLongitude[0]);
            cv.put(SQLHelper.COLUNA_LONGITUDE, country.latitudeLongitude[1]);
        } catch(ArrayIndexOutOfBoundsException ex){
            cv.put(SQLHelper.COLUNA_LATITUDE, Double.MAX_VALUE);
            cv.put(SQLHelper.COLUNA_LONGITUDE, Double.MAX_VALUE);
        }

        long id = db.insert(SQLHelper.TABELA_PAISES, null, cv);

        if(id != -1){
            country.id = id;
        }

        db.close();
        return id;
    }

    public void excluirAll(){
        db = helper.getWritableDatabase();
        db.delete(SQLHelper.TABELA_PAISES, null, null);
        db.close();
    }

    public List<Country> listarPaises() {
        String sql = "SELECT * FROM " + SQLHelper.TABELA_PAISES;
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        List<Country> list = new ArrayList();

        while (cursor.moveToNext()) {
            long id = cursor.getLong(
                    cursor.getColumnIndex(SQLHelper.COLUNA_ID)
            );
            String nome = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_NOME)
            );
            String capital = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_CAPITAL)
            );
            String continente = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_CONTINENTE)
            );
            String subregiao = cursor.getString(
                    cursor.getColumnIndex(SQLHelper.COLUNA_SUBREGIAO)
            );
            Double latitude = cursor.getDouble(
                    cursor.getColumnIndex(SQLHelper.COLUNA_LATITUDE)
            );
            Double longitude = cursor.getDouble(
                    cursor.getColumnIndex(SQLHelper.COLUNA_LONGITUDE)
            );

            Country pais = new Country(id, nome, capital, continente, subregiao, latitude, longitude);
            list.add(pais);
        }
        cursor.close();
        return list;
    }
}
