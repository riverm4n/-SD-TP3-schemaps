package icomp.ufam.com.schemaps.util;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

import icomp.ufam.com.schemaps.Base.Country;
import java.util.List;

public class HttpRetro {
  private static final String BASE_URL = "https://restcountries.eu/rest/v1/all/";

  public static CountryInterface getCountryClient(){
    Retrofit restAdapter = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

    return restAdapter.create(CountryInterface.class);
  }

  public interface CountryInterface{
    @GET("bins/13hcng")
    Call<List<Country>> getCountries();
  }
}
