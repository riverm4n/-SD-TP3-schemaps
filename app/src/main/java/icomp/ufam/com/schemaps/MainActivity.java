package icomp.ufam.com.schemaps;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import icomp.ufam.com.schemaps.Adapter.Adapter;
import icomp.ufam.com.schemaps.Base.Country;
import icomp.ufam.com.schemaps.dao.Repositorio;
import icomp.ufam.com.schemaps.util.HttpRetro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private Adapter adapter;
    private List<Country> listPaises;
    private ListView listView;
    private SwipeRefreshLayout swiperefresh;
    Repositorio db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Repositorio(getBaseContext());

        swiperefresh = (SwipeRefreshLayout) findViewById((R.id.swiperefresh));
        //Setagem das cores
        swiperefresh.setColorScheme(R.color.colorPrimary, R.color.colorAccent);
        swiperefresh.setOnRefreshListener(this);

        listView = (ListView) findViewById(R.id.listView);
        listPaises = new ArrayList<Country>();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplication(), listPaises.get(position).toString(), Toast.LENGTH_LONG).show();

                if ( listPaises.get(position).latitudeLongitude[0] == Double.MAX_VALUE ){
                    Toast.makeText(getApplication(), "This country doesn't have lat_lng data!", Toast.LENGTH_LONG).show();
                } else {
                    hasPermission();

                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    intent.putExtra("pais",listPaises.get(position));
                    startActivity(intent);
                }

            }
        });
        adapter = new Adapter(this, listPaises);

        getDataRetro();

        listView.setAdapter(adapter);
        //Ações ao clicar:
    }

    @Override
    public void onRefresh(){
        getDataRetro();
    }

    private void getDataRetro() {
        swiperefresh.setRefreshing(true);
        if (isConnected()) {
            HttpRetro.getCountryClient().getCountries().enqueue(new Callback<List<Country>>() {
                public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                    if (response.isSuccessful()) {
                        List<Country> countryBody = response.body();
                        listPaises.clear();

                        db.excluirAll();

                        for (Country country : countryBody) {
                            listPaises.add(country);
                            db.inserir(country);
                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        System.out.println(response.errorBody());
                    }
                    swiperefresh.setRefreshing(false);
                }

                @Override
                public void onFailure(Call<List<Country>> call, Throwable t) {
                    t.printStackTrace();
                }

            });
        } else {
            swiperefresh.setRefreshing(false);
            Toast.makeText(this, "Sem Conexão, acessando base local", Toast.LENGTH_SHORT).show();
            getDataSqlite();
        }
    }

    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if(cm != null){
            Toast.makeText(getApplication(), "Sem conexão. Acessando a Base Local.", Toast.LENGTH_LONG);
            NetworkInfo ni = cm.getActiveNetworkInfo();
            return ni != null && ni.isConnected();
        }

        return false;
    }

    private void getDataSqlite(){
        listPaises.clear();
        listPaises.addAll(db.listarPaises());
        adapter.notifyDataSetChanged();
    }

    void hasPermission(){
        //pede permissao de localizacao
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // ja pediu permissao?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {

                // solicita permissao de localizacao
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            }
        }
    }
}

