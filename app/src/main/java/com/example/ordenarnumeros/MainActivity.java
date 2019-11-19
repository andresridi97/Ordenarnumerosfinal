package com.example.ordenarnumeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button button1;
    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editText1);
        button1 = findViewById(R.id.button);
        tv1 = (TextView)findViewById(R.id.textView4);
        tv2 = (TextView)findViewById(R.id.textView5);

        button1.setOnClickListener(new View.OnClickListener()
        {
            int[] arreglo = new int[20];
            int clicks = -1;

            public void onClick(View v)
            {
                if(et1.length() != 0)
                {
                    int num = Integer.parseInt(et1.getText().toString());
                    String a2;
                    if(num >= -9999 && num <= 9999){
                        clicks += 1;
                        arreglo[clicks] = num;
                        if (clicks == arreglo.length-1)
                        {
                            for(int con =0; con<=arreglo.length-1; con ++){
                                a2 = tv2.getText().toString()+arreglo[con]+",";
                                tv2.setText(a2);
                            }
                        }

                        String a1;
                        if (clicks == arreglo.length-1)
                        {

                            clicks = -1;
                            ordenar(arreglo);
                            for(int cont =0; cont<=19; cont ++){
                                a1 = tv1.getText().toString()+arreglo[cont]+",";
                                tv1.setText(a1);
                            }
                        }
                        et1.getText().clear();
                    }else{
                        Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.Invalido), Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(MainActivity.this, getApplicationContext().getString(R.string.fn), Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    private void ordenar(int [] array)
    {
        //metodo inserción
        int aux, pos;
        for(int j = 0; j < array.length; j++){
            pos = j;
            aux = array[j];
            while((pos>0) && (array[pos-1] > aux)){
                array[pos] = array[pos-1];
                pos --;
            }
            array[pos] = aux;
        }
    }
    }

