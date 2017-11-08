package br.com.app.app;

import com.orm.SugarRecord;

/**
 * Created by 16254836 on 31/10/2017.
 */

public class Kilometragem extends SugarRecord {

    private String mes;
    private float kilometragem;

    public Kilometragem(){};

    public Kilometragem(String mes, float kilometragem){
        this.mes = mes;
        this.kilometragem = kilometragem;

    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public float getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(float kilometragem) {
        this.kilometragem = kilometragem;
    }


}
