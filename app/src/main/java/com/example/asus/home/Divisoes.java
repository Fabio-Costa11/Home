package com.example.asus.home;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Asus on 31/01/2017.
 */

public class Divisoes extends AppCompatActivity{

    //nao se declara aqui nada!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.divisoes);

        listadivisoes();
    }

    public void btn_adicionar (View view){
        Intent i = new Intent(this, AdicionarDivisao.class);
        startActivity(i);
    }
    public  void  listadivisoes()
    {
        // Send data
        try
        {
            final ArrayAdapter myAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
            final ListView MyListView = (ListView)findViewById(R.id.lista_divisoes) ;
            String url = "http://aplicacoesmoveis.000webhostapp.com/domotica/listar_divisoes.php";

            JsonArrayRequest jsonRequest = new JsonArrayRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            // the response is already constructed as a JSONArray!
                            try {
                                //response = response.getJSONObject("args");
                                String res="",res_id="", id, descricao;
                                for (int i = 0; i < response.length(); ++i) {
                                    JSONObject obj = response.getJSONObject(i);
                                    id = obj.getString("id");
                                    descricao = obj.getString("descricao");

                                    res_id = id;
                                    res = descricao;

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