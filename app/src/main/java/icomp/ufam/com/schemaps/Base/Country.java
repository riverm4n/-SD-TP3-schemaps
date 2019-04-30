package icomp.ufam.com.schemaps.Base;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Country implements Serializable{
  @SerializedName("id") public long id;
  @SerializedName("nome") public String nome;
  @SerializedName("capital") public String capital;
  @SerializedName("continente") public String continente;
  @SerializedName("subregiao") public String subregiao;
  @SerializedName("latitude") public String latitude;
  @SerializedName("longitude") public String longitude;
  //Para amanhã: tentar definir como lista de Double ltdlng


  public Country(long id, String nome, String capital, String continente, String subregiao, String latitude, String longitude){
    this.id         = id;
    this.nome       = nome;
    this.capital    = capital;
    this.continente = continente;
    this.subregiao  = subregiao;
    this.latitude   = latitude;
    this.longitude  = longitude;
  }

  @Override
  public String toString(){
    return "País {" + " nome = ''" + this.nome + '\'' + " continente = ''" + this.continente + '\'' + '}';
  }

  public Long getId(){
    return this.id;
  }

  public String getNome(){
    return this.nome;
  }

  public String getCapital(){
    return this.capital;
  }

  public String subregiao(){
    return this.subregiao;
  }

  public String getLatitude(){
    return this.latitude;
  }

  public String getLongitude(){
    return this.longitude;
  }
}
