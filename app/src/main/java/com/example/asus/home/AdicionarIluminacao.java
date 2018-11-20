package com.example.asus.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

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

public class AdicionarIluminacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_iluminacao);
    }


    public  void  btn_adicionartv(View view)
    {
        //declaracao das variaveis
        final EditText et_id_iluminacao = (EditText)findViewById(R.id.et_id_iluminacao);
        final EditText et_id_divisaoi = (EditText)findViewById(R.id.et_id_divisaoi);
        final EditText et_ligadoi = (EditText)findViewById(R.id.et_ligadoi);
        final EditText et_intensidade = (EditText)findViewById(R.id.et_intensidade);

        //atribuir as variaveis
        final String str_id_iluminacao = et_id_iluminacao.getText().toString();
        final String str_id_divisaoi = et_id_divisaoi.getText().toString();
        final String str_ligadoi = et_ligadoi.getText().toString();
        final String str_intensidade = et_intensidade.getText().toString();

        // Send data
        try
        {

            String url = "http://aplicacoesmoveis.000webhostapp.com/domotica/inserir_iluminacao_post.php";

            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Resultado da insercao
                            Toast.makeText(AdicionarIluminacao.this, response,
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
                    params.put("id", str_id_iluminacao);
                    params.put("divisao", str_id_divisaoi);
                    params.put("ligado", str_ligadoi);
                    params.put("intensidade", str_intensidade);
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
