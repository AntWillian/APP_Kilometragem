package br.com.app.app;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class Visualizar extends AppCompatActivity {


    ListView listView;

    KilometragemAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        listView = (ListView) findViewById(R.id.listView);

        List<Kilometragem> lstKm = Kilometragem.listAll(Kilometragem.class);

        adapter = new KilometragemAdapter(this, lstKm);

        listView.setAdapter(adapter);

    }


    private class KilometragemAdapter extends ArrayAdapter<Kilometragem>{
        public  KilometragemAdapter (Context context, List<Kilometragem> items){
            super(context,0,items);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;

            // colocando o layout na lista
            if (v == null){
                v= LayoutInflater.from(getContext()).inflate(R.layout.list_view,null);
            }

            Kilometragem item = getItem(position);

            // setando as caxinha
            TextView txt_Mes = v.findViewById(R.id.txtMotrarMes);
            TextView txt_Km = v.findViewById(R.id.txtMotrarKm);


            // dados para mostar na lista dados do banco Sugar
            txt_Mes.setText(item.getMes());
            Float km = item.getKilometragem();
            String km2 = Float.toString(km);

            txt_Km.setText(km2+" KM");

            return v;
        }
    }



}
