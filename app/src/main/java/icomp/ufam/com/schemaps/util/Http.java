package icomp.ufam.com.schemaps.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import icomp.ufam.com.schemaps.Base.Country;

// A conexão com a Internet é realizada através do método HttpURLConnection do pacote java.net
public class Http {
  /*public static final String MAPA_URL_JSON = "https://restcountries.eu/rest/v1/all";

  private static HttpURLConnection conectar(String urlArquivo) throws IOException{
    final int SEGUNDOS = 1000;
    URL url = new URL(urlArquivo);
    HttpURLConnection conexao = (HttpURLConnection)url.openConnection(); //Estabelece conexão
    conexao.setReadTimeout(10 * SEGUNDOS);
    conexao.setConnectTimeout(15 * SEGUNDOS);
    conexao.setRequestMethod("GET");
    conexao.setDoInput(true);
    conexao.setDoOutput(false);
    conexao.connect();

    return conexao;
  }

  // Método responsável por carregar o JSON:
  public static List<Country> carregarJSONPaises(){
    try{
      HttpURLConnection conexao = conectar(MAPA_URL_JSON);
      int resposta = conexao.getResponseCode();

      //Checagem se a conexão foi estabelecida:
      if(resposta == HttpURLConnection.HTTP_OK){
        InputStream is  = conexao.getInputStream();
        JSONArray json = new JSONArray(bytesParaString(is));

        return lerJSONPaises(json);
      }
    } catch(Exception e){
      e.printStackTrace();
    }

    return null;
  }

  private static List<Country> lerJSONPaises(JSONArray json) throws JSONException {
    List<Country> listaDePaises = new ArrayList<Country>();

    for(int contador = 0; contador < json.length(); contador++){
      JSONObject country = json.getJSONObject(contador);

      Country pais = new Country(contador, country.getString("name"), country.getString("capital"), country.getString("region"), country.getString("subregion"), country.getInt("ltdlng", 0), country.getInt("ltdlng", 1));

      listaDePaises.add(pais);
    }

    return listaDePaises;
  }

  private static String bytesParaString(InputStream is) throws IOException{
    byte[] buffer = new byte[1024];

    //O bigBuffer vai armazenar todos os bytes lidos:
    ByteArrayOutputStream bigBuffer = new ByteArrayOutputStream();

    int bytesLidos;
    //Lendo 1KB pro vez:
    while((bytesLidos = is.read(buffer)) != -1){
      bigBuffer.write(buffer, 0, bytesLidos);
    }

    return new String(bigBuffer.toByteArray(), "UTF-8");
  }*/

}
