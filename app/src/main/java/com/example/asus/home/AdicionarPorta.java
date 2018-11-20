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

public class AdicionarPorta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_porta);
    }

    public  void  btn_adicionar_porta(View view)
    {

        final EditText et_id_porta = (EditText)findViewById(R.id.et_id_porta);
        final EditText et_id_divisao_porta = (EditText)findViewById(R.id.et_id_divisao_porta);
        final EditText et_aberto_porta = (EditText)findViewById(R.id.et_aberto_porta);

        final String str_id_porta = et_id_porta.getText().toString();
        final String str_id_divisao_porta = et_id_divisao_porta.getText().toString();
        final String str_aberto_porta = et_aberto_porta.getText().toString();
        // Send data
        try
        {

            String url = "http://aplicacoesmoveis.000webhostapp.com/domotica/inserir_porta_post.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Resultado da insercao
                            Toast.makeText(AdicionarPorta.this, response,
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
                    params.put("id", str_id_porta);
                    params.put("divisao", str_id_divisao_porta);
                    params.put("aberto", str_aberto_porta);
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
