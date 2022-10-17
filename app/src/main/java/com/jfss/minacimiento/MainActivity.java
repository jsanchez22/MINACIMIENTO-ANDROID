package com.jfss.minacimiento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText dia_dato;
    private EditText mes_dato;
    private EditText ano_dato;
    private TextView textrespuesta;
    private TextView textzodiaco;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dia_dato = findViewById(R.id.ingresar_dia);
        mes_dato = findViewById(R.id.ingresar_mes);
        ano_dato = findViewById(R.id.ingresar_ano);
        textrespuesta = findViewById(R.id.mostrar);
        textzodiaco = findViewById(R.id.mostrar2);
    }

    public void sumar (View view){

        Integer dd = Integer.parseInt(dia_dato.getText().toString());
        Integer mm = Integer.parseInt(mes_dato.getText().toString());
        Integer aa = Integer.parseInt(ano_dato.getText().toString());
        Integer anos_bisi, anos_resto, dias_total , dia_en_semana;
        Integer dias_segun_mes [] = {0,31,59,90,120,151,181,212,243,273,304,334};
        String mostrar_dia;
        String zodiaco;
        String lista_dias[]= {
                "LUNES",
                "MARTES",
                "MIERCOLES",
                "JUEVES",
                "VIERNES",
                "SABADO",
                "DOMINGO"
        };
        if ( dd <= 31 && mm <= 12 ){

        anos_bisi = aa / 4;
        anos_resto = aa % 4 ;
        dias_total = aa *365 + anos_bisi + dias_segun_mes[mm-1] + dd ;
        if (anos_resto==0 && mm <= 2 )
        {
            dias_total = dias_total - 1 ;
            /* code */
        }

        dia_en_semana = (dias_total -3)% 7 ;

        mostrar_dia = lista_dias[dia_en_semana];



        textrespuesta.setText("DIA DE NACIMIENTO: "+ mostrar_dia);
        zodiaco = obtener_zodiaco(dd,mm);
        textzodiaco.setText("SIGNO: "+ zodiaco);
        closeteclado();    }
        else {
            textrespuesta.setText("");
            textzodiaco.setTextColor(Color.RED);
            textzodiaco.setTextSize(30);
            textzodiaco.setText("FECHA INCORRECTA");
            closeteclado();    }

    }

    public static String obtener_zodiaco(Integer dd, Integer mm) {
            String signo = "nada";
        switch(mm) {
            case 1:
                // Enero
                if (dd>=21)
                    signo ="ACUARIO";
                else
                    signo = "CAPRICORNIO";
               break;
               case 2:
                // Febrero
                if (dd>=20)
                    signo =  "PISCIS";
                else
                    signo = "ACUARIO";
                break;
            case 3:
                // Marzo
                if (dd>=21)
                    signo = "ARIES";
                else
                    signo = "PISCIS";
                break;
            case 4:
                // Abril
                if (dd>=20)
                    signo = "TAURO";
                else
                    signo = "ARIES";
                break;
            case 5:
                // Mayo
                if (dd>=21)
                    signo = "GEMINIS";
                else
                    signo = "TAURO";
                break;
            case 6:
                // Junio
                if (dd>=22)
                    signo = "CANCER";
                else
                    signo = "GEMINIS";
                break;
            case 7:
                // JULIO
                if (dd>=23)
                    signo = "LEO";
                else
                    signo = "CANCER";
                break;
            case 8:
                // agosto
                if (dd>=23)
                    signo = "VIRGO";
                else
                    signo = "LEO";
                break;
            case 9:
                // Septiembre
                if (dd>=23)
                    signo = "LIBRA";
                else
                    signo = "VIRGO";
                break;
            case 10:
                // octubre
                if (dd>=23)
                    signo = "ESCORPIO";
                else
                    signo = "LIBRA";
                break;
            case 11:
                // NOVIEMBRE
                if (dd>=22)
                    signo = "SAGITARIO";
                else
                    signo = "ESCORPIO";
                break;
            case 12:
                // DICIEMBRE
                if (dd>=22)
                    signo = "CAPRICORNIO";
                else
                    signo = "SAGITARIO";
                break;

       }
            return signo;

    }

    private void closeteclado() {
        View view= this.getCurrentFocus();
        if (view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),  0);
        }
    }

}