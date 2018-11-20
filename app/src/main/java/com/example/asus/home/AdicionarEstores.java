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

public class AdicionarEstores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_estores);
    }

    public  void  btn_adicionar_estore(View view)
    {

        final EditText et_id_estore = (EditText)findViewById(R.id.et_id_estore);
        final EditText et_id_divisao_estore = (EditText)findViewById(R.id.et_id_divisao_estore);
        final EditText et_aberto = (EditText)findViewById(R.id.et_aberto);

        final String str_id_estore = et_id_estore.getText().toString();
        final String str_id_divisao_estore = et_id_divisao_estore.getText().toString();
        final String str_aberto = et_aberto.getText().toString();
        // Send data
        try
        {

            String url = "http://aplicacoesmoveis.000webhostapp.com/domotica/inserir_estore_post.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Resultado da insercao
                            Toast.makeText(AdicionarEstores.this, response,
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
                    params.put("id", str_id_estore);
                    params.put("divisao", str_id_divisao_estore);
                    params.put("aberto", str_aberto);
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
