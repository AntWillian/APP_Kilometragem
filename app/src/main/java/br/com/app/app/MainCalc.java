package br.com.app.app;

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

import java.util.ArrayList;
import java.util.List;

public class MainCalc extends AppCompatActivity {

    ListView listView;

    MainCalcAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        listView = (ListView) findViewById(R.id.listViewBonus);

        List<Kilometragem> lstBonus = Kilometragem.listAll(Kilometragem.class);

        List<Kilometragem> listaCalc = new ArrayList<>();

        float valor;
        float proximo= 0;

        for (int i=0 ; i < lstBonus.size() ; i++) {

            Kilometragem k = lstBonus.get(i);

            Float km = k.getKilometragem();

            if (km <= 4000){

                valor = (float) (km * 1.50);
                proximo = valor + proximo;

            }else{
                valor = (float) (km * 1.25);
                proximo = valor + proximo;
            }

            Kilometragem kilometragem = new Kilometragem();
            kilometragem.setMes(k.getMes());
            kilometragem.setKilometragem(proximo);

            listaCalc.add(kilometragem);
        }



        adapter = new MainCalcAdapter (this, listaCalc);




        listView.setAdapter(adapter);

    }

    private class MainCalcAdapter extends ArrayAdapter<Kilometragem> {
        public  MainCalcAdapter(Context context, List<Kilometragem> items){
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

            txt_Km.setText("R$ "+ km2);

            return v;
        }
    }
}
