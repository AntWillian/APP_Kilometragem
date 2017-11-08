package br.com.app.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtKilometragen;
    Spinner spiner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKilometragen= (EditText) findViewById(R.id.txtKilometragen);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.meses,android.R.layout.simple_spinner_dropdown_item
        );
        spiner = (Spinner) findViewById(R.id.spiner);
//        spiner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner.setAdapter(adapter);

    }


    public void btnSalvar(View view) {

        String mes = spiner.getSelectedItem().toString();
        //Float km = Float.parseFloat(txtKilometragen.getText().toString());
        String km =txtKilometragen.getText().toString();

        if (km.isEmpty()){
            Toast.makeText(this,"prencha o campo",Toast.LENGTH_LONG).show();
            return;
        }
        Float kmF = Float.parseFloat(km.toString());

        Kilometragem dadosK = new Kilometragem(mes,kmF );

        dadosK.save();

        txtKilometragen.setText(null);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.verDados:
                startActivity(new Intent(this,Visualizar.class));
                return true;
            case R.id.verDadoskm:
                startActivity(new Intent(this,MainCalc.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
