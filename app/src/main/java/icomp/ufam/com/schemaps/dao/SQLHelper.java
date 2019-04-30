package icomp.ufam.com.schemaps.dao;

import android.content.Context;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class SQLHelper extends SQLiteOpenHelper {
  private static final String NOME_BANCO     = "dbPaises";
  private static final int VERSAO_BANCO      = 1;
  public static final String COLUNA_ID      = "_id";
  public static final String TABELA_PAISES  = "paises_tabela";
  public static final String COLUNA_NOME    = "nome";
  public static final String COLUNA_CAPITAL = "capital";
  public static final String COLUNA_CONTINENTE = "continente";
  public static final String COLUNA_SUBREGIAO  = "subregiao";
  public static final String COLUNA_LATITUDE    = "latitude";
  public static final String COLUNA_LONGITUDE   = "longitude";

  public SQLHelper(Context context){
    super(context, NOME_BANCO, null, VERSAO_BANCO);
  }

  public void onCreate(SQLiteDatabase sqLiteDatabase){
    sqLiteDatabase.execSQL(
      "CREATE TABLE " + TABELA_PAISES + " ( " +
      COLUNA_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
      COLUNA_NOME + " TEXT, " +
      COLUNA_CAPITAL + " TEXT, " +
      COLUNA_CONTINENTE + " TEXT, " +
      COLUNA_SUBREGIAO + " TEXT, " +
      COLUNA_LATITUDE + " REAL, " +
      COLUNA_LONGITUDE + " REAL)"
    );
  }

  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
    //Para versões futuras
  }


}
