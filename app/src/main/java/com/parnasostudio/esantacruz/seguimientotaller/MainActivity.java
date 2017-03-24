package com.parnasostudio.esantacruz.seguimientotaller;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText placa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placa   = (EditText) findViewById(R.id.input_placa);



    }

    public String getMacAddress(Context context) {
        WifiManager wimanager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        String macAddress = wimanager.getConnectionInfo().getMacAddress();
        if (macAddress == null) {
            macAddress = "Device don't have mac address or wi-fi is disabled";
        }
        return macAddress;
    }

    public void registrarPlaca(View v){


        Toast toastRed = Toast.makeText(this, getMacAddress( getBaseContext()),Toast.LENGTH_SHORT);
        toastRed.setGravity(Gravity.CENTER,0,0);
        toastRed.show();


        if (placa.length()>0){
            Toast toast = Toast.makeText(this,"Se registro la Placa",  Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();

            placa.setText("");
        }else{
            Toast toast = Toast.makeText(this,"Debe ingresar una Placa válida",  Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();

        }



    }

}
