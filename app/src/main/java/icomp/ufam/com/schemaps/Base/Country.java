import java.io.Serializable;

public class Country implements Serializable{
  public long id;
  public String nome;
  public String capital;
  public String continente;
  public String subregiao;
  public String latitude;
  public String longitude;

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
