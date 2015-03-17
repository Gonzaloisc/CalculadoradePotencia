package com.example.usuario.calculadoradepotencia;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Datos extends ActionBarActivity {
   EditText edt1,edt2;
    TextView res;
    String datos[];@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        final String dato=getIntent().getExtras().getString("nombre");
       datos=dato.split(" Y ");
        ((TextView)findViewById(R.id.textView2)).setText(datos[0]+"/"+subfijo(datos[0]));
        ((TextView)findViewById(R.id.dato1)).setText(datos[1]+"/"+subfijo(datos[1]));
        edt1=(EditText)findViewById(R.id.editText);
        edt2=(EditText)findViewById(R.id.dato2);
        res=(TextView)findViewById(R.id.resp);
        ((Button)findViewById(R.id.resolver)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try{
                double dato1=Double.parseDouble(edt1.getText().toString());
                double dato2=Double.parseDouble(edt2.getText().toString());
                if(datos[0].equalsIgnoreCase("Resistencia")){
                  res.setText("Respuesta: "+(dato2*dato2*dato1)+"watts");
                }else if(datos[1].equalsIgnoreCase("Intencidad")){
                    res.setText("Respuesta: "+(dato2*dato1)+"watts");

                }else{

                    res.setText("Respuesta: "+((dato2*dato2)/dato1)+"watts");
                }}catch(Exception e){
                   Toast toast = Toast.makeText(getApplicationContext(), "Complete todos los Campos", Toast.LENGTH_SHORT);
                   toast.show();
               }
            }
        });
    }
   public String subfijo(String s){
       if(s.equalsIgnoreCase("Resistencia")){

           return "Homs";
       }else if(s.trim().equalsIgnoreCase("Intencidad")){
           return "Amperes";
       }else{

           return "Volts";
       }

   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
