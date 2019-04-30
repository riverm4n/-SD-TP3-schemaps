package icomp.ufam.com.schemaps.Base;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Country implements Serializable{
  @SerializedName("name") public String nome;
  @SerializedName("capital") public String capital;
  @SerializedName("region") public String continente;
  @SerializedName("subregion") public String subregiao;
  @SerializedName("latlng") public List<Double> latitudeLongitude = new ArrayList<Double>(2);


  public Country(String nome, String capital, String continente, String subregiao){
    this.nome       = nome;
    this.capital    = capital;
    this.continente = continente;
    this.subregiao  = subregiao;
  }

  @Override
  public String toString(){
    return "País {" + " nome = ''" + this.nome + '\'' + " continente = ''" + this.continente + '\'' + '}';
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

  public List<Double> getLatitudeLongitude(){
    return this.latitudeLongitude;
  }
}
