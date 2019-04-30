package icomp.ufam.com.schemaps.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import java.util.List;

import icomp.ufam.com.schemaps.R;
import icomp.ufam.com.schemaps.Base.Country;


public class Adapter extends ArrayAdapter<Country>{
  public Adapter(Context context, List<Country> objects){
    super(context, 0, objects);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent){
    Country country = getItem(position);

    if(convertView == null)
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_country, parent, false);

    TextView txtviewNome = (TextView) convertView.findViewById(R.id.nome);
    TextView txtviewCont = (TextView) convertView.findViewById(R.id.continente);
    txtviewNome.setText(country.nome);
    txtviewCont.setText(country.continente);

    return convertView;
  }
}
