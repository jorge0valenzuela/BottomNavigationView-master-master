package com.example.bottomnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SesionFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener {


    RequestQueue rq;
    JsonRequest jrq;

    EditText uss,pas;
    Button b1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sesion, container, false);
        View vista = inflater.inflate(R.layout.fragment_sesion,container,false);
        uss = (EditText)  vista.findViewById(R.id.txtUss);
        pas = (EditText)  vista.findViewById(R.id.txtPass);
        b1 = (Button) vista.findViewById(R.id.btnLogin);

        rq = Volley.newRequestQueue(getContext());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iniciarSesion();

            }
        });

    return vista;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast toast1 =
                Toast.makeText(getContext(),
                        "No se encontro el usuario", Toast.LENGTH_SHORT);
        toast1.show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast toast1 =
                Toast.makeText(getContext(),
                        "Bienvenido: "+uss.getText().toString(), Toast.LENGTH_SHORT);
        toast1.show();

        User usuario = new User();

        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObject = null;

        try {
            jsonObject = jsonArray.getJSONObject(0);
            usuario.setUser(jsonObject.optString("user"));
            usuario.setNames(jsonObject.optString("pwd"));
            usuario.setNames(jsonObject.optString("names"));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        Intent i = new Intent(getContext(),Main2Activity.class);
        startActivity(i);

    }
private void iniciarSesion()
{
    String url = "http://madbatterbakes.000webhostapp.com/sesion.php?user="+uss.getText().toString()+"&pwd"+pas.getText().toString();
    jrq = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
    rq.add(jrq);
}
private void muffin()
    {
        String url = "http://madbatterbakes.000webhostapp.com/promociones.php";
        jrq = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        rq.add(jrq);
    }


}
