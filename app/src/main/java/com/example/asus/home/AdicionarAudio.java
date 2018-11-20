package com.example.asus.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asus on 06/02/2017.
 */

public class AdicionarAudio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_audio);
    }


    public void btn_adicionar_audio(View view) {

        final EditText et_id_audio = (EditText) findViewById(R.id.et_id_audio);
        final EditText et_id_divisao_audio = (EditText) findViewById(R.id.et_id_divisao_audio);
        final EditText et_ligado_audio = (EditText) findViewById(R.id.et_ligado_audio);
        final EditText et_radio = (EditText) findViewById(R.id.et_radio);
        final EditText et_cd = (EditText) findViewById(R.id.et_cd);
        final EditText et_volume_audio = (EditText) findViewById(R.id.et_volume_audio);

        final String str_id_tv = et_id_audio.getText().toString();
        final String str_id_divisao = et_id_divisao_audio.getText().toString();
        final String str_ligado_audio = et_ligado_audio.getText().toString();
        final String str_radio = et_radio.getText().toString();
        final String str_cd = et_cd.getText().toString();
        final String str_volume_audio = et_volume_audio.getText().toString();
        // Send data
        try {

            String url = "http://aplicacoesmoveis.000webhostapp.com/domotica/inserir_audio_post.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Resultado da insercao
                            Toast.makeText(AdicionarAudio.this, response,
                                    Toast.LENGTH_LONG).show();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    // the POST parameters:
                    params.put("id", str_id_tv);
                    params.put("divisao", str_id_divisao);
                    params.put("ligado", str_ligado_audio);
                    params.put("radio", str_radio);
                    params.put("cd_dvd", str_cd);
                    params.put("volume", str_volume_audio);
                    return params;
                }
            };
            Volley.newRequestQueue(this).add(postRequest);
        } catch (Exception ex) {
        } finally {
        }
    }
}