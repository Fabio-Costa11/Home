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

public class AdicionarArCondicionado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_ar_condicionado);
    }
    public  void  btn_adicionar_ar_condicionado(View view)
    {

        final EditText et_id_ar_condicionado = (EditText)findViewById(R.id.et_id_ar_condicionado);
        final EditText et_id_divisao_ar = (EditText)findViewById(R.id.et_id_divisao_ar);
        final EditText et_ligado_ar = (EditText)findViewById(R.id.et_ligado_ar);
        final EditText et_temperatura = (EditText)findViewById(R.id.et_temperatura);
        final EditText et_intensidade_ar = (EditText)findViewById(R.id.et_intensidade_ar);
        final EditText et_modo = (EditText)findViewById(R.id.et_modo);

        final String str_id_ar_condicionado = et_id_ar_condicionado.getText().toString();
        final String str_id_divisao_ar = et_id_divisao_ar.getText().toString();
        final String str_ligado_ar = et_ligado_ar.getText().toString();
        final String str_temperatura = et_temperatura.getText().toString();
        final String str_intensidade_ar = et_intensidade_ar.getText().toString();
        final String str_modo = et_modo.getText().toString();
        // Send data
        try
        {

            String url = "http://aplicacoesmoveis.000webhostapp.com/domotica/inserir_ac_post.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Resultado da insercao
                            Toast.makeText(AdicionarArCondicionado.this, response,
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
                    params.put("id", str_id_ar_condicionado);
                    params.put("divisao", str_id_divisao_ar);
                    params.put("ligado", str_ligado_ar);
                    params.put("temperatura", str_temperatura);
                    params.put("intensidade", str_intensidade_ar);
                    params.put("modo", str_modo);
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
