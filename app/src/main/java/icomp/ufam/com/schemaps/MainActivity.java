package icomp.ufam.com.schemaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
  private Adapter adapter;
  private List<Country> listPaises;
  private ListView listView;
  private SwipeRefreshLayout swiperefresh;

  @Override
  protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    swiperefresh = (SwipeRefreshLayout) findViewById((R.id.swiperefresh));
    //Setagem das cores
    swiperefresh.setColorScheme(R.color.colorPrimary, R.color.colorAccent);
    swiperefresh.setOnRefreshListener(this);

    listView   = (ListView) findViewById(R.id.listView);
    listPaises = new ArrayList<Country>();
    adapter    = new Adapter(this, listPaises);

    getData();

    listView.setAdapter(adapter);
    //Ações ao clicar:
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           Toast.makeText(getApplication(), ubsList.get(position).toString(), Toast.LENGTH_LONG).show();
       }
   });
 }

 private void getData(){
   String[] nomes       = {"REPÚBLICA DO CONGO", "INDONÉSIA", "CHILE", "CANADÁ", "REPÚBLICA TCHECA", "AUSTRÁLIA"};
   String[] continentes = {"ÁFRICA", "ÁSIA", "AMÉRICA DO SUL", "AMÉRICA DO NORTE", "EUROPA", "OCEANIA"};
   listPaises.clear();

   //Povoamento da lista de países:
   for(int contadora = 0; contadora < 20; contadora++){
     int nextInt     = new Randon().nextInt(6);
     Country country = new Country(contadora, nomes[nextInt], "", continentes[nextInt], "", "", "");
     listPaises.add(country);
   }

   adapter.notifyDataSetChanged();
 }

 @Override
 public void onRefresh(){
   getData();
 }

}
