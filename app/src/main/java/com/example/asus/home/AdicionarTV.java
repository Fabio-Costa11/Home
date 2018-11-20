package com.example.asus.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asus on 05/02/2017.
 */

public class AdicionarTV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_tv);
    }

    public  void  btn_adicionartv(View view)
    {

        final EditText et_id_tv = (EditText)findViewById(R.id.et_id_tv);
        final EditText et_id_divisao = (EditText)findViewById(R.id.et_id_divisao);
        final EditText et_ligado = (EditText)findViewById(R.id.et_ligado);
        final EditText et_canal = (EditText)findViewById(R.id.et_canal);
        final EditText et_gravacao = (EditText)findViewById(R.id.et_gravacao);
        final EditText et_volume = (EditText)findViewById(R.id.et_volume);

        final String str_id_tv = et_id_tv.getText().toString();
        final String str_id_divisao = et_id_divisao.getText().toString();
        final String str_ligado = et_ligado.getText().toString();
        final String str_canal = et_canal.getText().toString();
        final String str_gravacao = et_gravacao.getText().toString();
        final String str_volume = et_volume.getText().toString();
        // Send data
        try
        {

            String url = "http://aplicacoesmoveis.000webhostapp.com/domotica/inserir_tv_post.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Resultado da insercao
                            Toast.makeText(AdicionarTV.this, response,
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
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<>();
                    // the POST parameters:
                    params.put("id", str_id_tv);
                    params.put("divisao", str_id_divisao);
                    params.put("ligado", str_ligado);
                    params.put("canal", str_canal);
                    params.put("gravacao", str_gravacao);
                    params.put("volume", str_volume);
                    return params;
                }
            };
            Volley.newRequestQueue(this).add(postRequest);
        }
        catch(Exception ex)
        {
        }
        finally
        {
        }
    }
}