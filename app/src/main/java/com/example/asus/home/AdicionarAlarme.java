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

public class AdicionarAlarme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_alarme);
    }

    public  void  btn_adicionar_alarme(View view)
    {

        final EditText et_id_alarme = (EditText)findViewById(R.id.et_id_alarme);
        final EditText et_id_divisao_alarme = (EditText)findViewById(R.id.et_id_divisao_alarme);
        final EditText et_ligado_alarme = (EditText)findViewById(R.id.et_ligado_alarme);
        final EditText et_tipo = (EditText)findViewById(R.id.et_tipo);

        final String str_id_alarme = et_id_alarme.getText().toString();
        final String str_id_divisao_alarme = et_id_divisao_alarme.getText().toString();
        final String str_ligado_alarme = et_ligado_alarme.getText().toString();
        final String str_tipo = et_tipo.getText().toString();
        // Send data
        try
        {

            String url = "http://aplicacoesmoveis.000webhostapp.com/domotica/inserir_alarme_post.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Resultado da insercao
                            Toast.makeText(AdicionarAlarme.this, response,
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
                    params.put("id", str_id_alarme);
                    params.put("divisao", str_id_divisao_alarme);
                    params.put("ligado", str_ligado_alarme);
                    params.put("tipo", str_tipo);
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
