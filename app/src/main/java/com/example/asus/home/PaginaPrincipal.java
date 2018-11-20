package com.example.asus.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Asus on 31/01/2017.
 */

public class PaginaPrincipal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.paginaprincipal);
    }
    public void btn_divisoes (View view){
        Intent i = new Intent(this, Divisoes.class);
        startActivity(i);
    }
    public void btn_dispositivos (View view){
        Intent i = new Intent(this, Dispositivos.class);
        startActivity(i);
    }
    public void btn_sobre (View view){
        Intent i = new Intent(this, Sobre.class);
        startActivity(i);
    }
    public void btn_sair (View view){
        this.finish();
    }
}
