package com.example.asus.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Asus on 31/01/2017.
 */

public class Dispositivos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dispositivos);
    }

    public void btn_add_tv (View view){
        Intent i = new Intent(this, AdicionarTV.class);
        startActivity(i);
    }

    public void btn_add_iluminacao (View view){
        Intent i = new Intent(this, AdicionarIluminacao.class);
        startActivity(i);
    }

    public void btn_add_arcondicionado (View view){
        Intent i = new Intent(this, AdicionarArCondicionado.class);
        startActivity(i);
    }

    public void btn_add_audio (View view){
        Intent i = new Intent(this, AdicionarAudio.class);
        startActivity(i);
    }

    public void btn_add_estore (View view){
        Intent i = new Intent(this, AdicionarEstores.class);
        startActivity(i);
    }

    public void btn_add_alarme (View view){
        Intent i = new Intent(this, AdicionarAlarme.class);
        startActivity(i);
    }

    public void btn_add_porta (View view){
        Intent i = new Intent(this, AdicionarPorta.class);
        startActivity(i);
    }

    public void btn_informacoes (View view){
        Intent i = new Intent(this, Informacoes.class);
        startActivity(i);
    }

    public void btn_tv(View view){
        Intent i = new Intent(this, ListarTV.class);
        startActivity(i);
    }

    public void btn_iluminacao(View view){
        Intent i = new Intent(this, Listar_Iluminacao.class);
        startActivity(i);
    }

    public void btn_arcondicionado(View view){
        Intent i = new Intent(this, ListarArCondicionado.class);
        startActivity(i);
    }

    public void btn_audio(View view){
        Intent i = new Intent(this, ListarAudio.class);
        startActivity(i);
    }

    public void btn_estores(View view){
        Intent i = new Intent(this, ListarEstores.class);
        startActivity(i);
    }

    public void btn_alarme(View view){
        Intent i = new Intent(this, ListarAlarme.class);
        startActivity(i);
    }

    public void btn_portas(View view){
        Intent i = new Intent(this, ListarPorta.class);
        startActivity(i);
    }
}
