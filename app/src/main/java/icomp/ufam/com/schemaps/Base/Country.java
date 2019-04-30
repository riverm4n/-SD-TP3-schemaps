package icomp.ufam.com.schemaps.Base;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Country implements Serializable{
  public long id;
  @SerializedName("name") public String nome;
  @SerializedName("capital") public String capital;
  @SerializedName("region") public String continente;
  @SerializedName("subregion") public String subregiao;
  @SerializedName("latlng") public Double[] latitudeLongitude = new Double[2];


  public Country(Long id, String nome, String capital, String continente, String subregiao, Double latitude, Double longitude){
    this.id         = id;
    this.nome       = nome;
    this.capital    = capital;
    this.continente = continente;
    this.subregiao  = subregiao;
    latitudeLongitude[0] = latitude;
    latitudeLongitude[1] = longitude;
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

  public Double[] getLatitudeLongitude(){
    return this.latitudeLongitude;
  }
}
