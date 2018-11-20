package com.example.asus.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Asus on 06/02/2017.
 */

public class Listar_Iluminacao extends AppCompatActivity {

    //nao se declara aqui nada!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_iluminacao);

        listariluminacao();
    }

    public  void  listariluminacao()
    {
        // Send data
        try
        {
            final ArrayAdapter myAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
            final ListView MyListView = (ListView)findViewById(R.id.lista_iluminacao) ;
            String url = "http://aplicacoesmoveis.000webhostapp.com/domotica/listar_iluminacao_get.php";

            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // the response is already constructed as a JSONArray!
                            try {
                                //response = response.getJSONObject("args");
                                String res="", id_iluminacao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    id_iluminacao = obj.getString("id");
                                    res = id_iluminacao;

                                    myAdapter.add(res);
                                }
                                MyListView.setAdapter(myAdapter);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    });
            Volley.newRequestQueue(this).add(jsonRequest);
        }
        catch(Exception ex)
        {
        }
        finally
        {
        }
    }
}
