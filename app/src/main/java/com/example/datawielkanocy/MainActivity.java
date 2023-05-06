package com.example.datawielkanocy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        et=findViewById(R.id.et);
    }

    public int A(int rok){
        if(rok>=30 && rok<=1582) return 15;
        else if(rok>=1583 && rok<=1699) return 22;
        else if(rok>=1700 && rok<=1799) return 23;
        else if(rok>=1800 && rok<=1899) return 23;
        else if(rok>=1900 && rok<=2099) return 24;
        else if(rok>=2100 && rok<=2199) return 24;
        else if(rok>=2200 && rok<=2299) return 25;
        else if(rok>=2300 && rok<=2399) return 26;
        else if(rok>=2400 && rok<=2499) return 25;
        else if(rok>=2500 && rok<=2599) return 26;
        else if(rok>=2600 && rok<=2699) return 27;
        else if(rok>=2700 && rok<=2899) return 27;
        else if(rok>=2900 && rok<=2999) return 28;
        else return 0;
    }

    public int B(int rok){
        if(rok>=30 && rok<=1582) return 6;
        else if(rok>=1583 && rok<=1699) return 2;
        else if(rok>=1700 && rok<=1799) return 3;
        else if(rok>=1800 && rok<=1899) return 4;
        else if(rok>=1900 && rok<=2099) return 5;
        else if(rok>=2100 && rok<=2199) return 6;
        else if(rok>=2200 && rok<=2299) return 0;
        else if(rok>=2300 && rok<=2399) return 1;
        else if(rok>=2400 && rok<=2499) return 1;
        else if(rok>=2500 && rok<=2599) return 2;
        else if(rok>=2600 && rok<=2699) return 3;
        else if(rok>=2700 && rok<=2899) return 4;
        else if(rok>=2900 && rok<=2999) return 5;
        else return 0;
    }
    public void oblicz(View view){
        String komunikat="";
        tv.setText(komunikat);
        try {
            int rok = Integer.parseInt(et.getText().toString());
            int a=rok%19;
            int b=rok%4;
            int c=rok%7;
            int d=((a*19)+A(rok))%30;
            int e=(2*b+4*c+6*d+B(rok))%7;
            if(22+d+e<=31){
                komunikat="Data Wielkanocy "+(22+d+e)+" "+"marzec"+" "+rok;
            }
            else if(22+d+e>31){
                if((d==29 && e==6)||(d==28 && e==6))
                    komunikat="Data Wielkanocy "+(d+e-9-7)+" "+"kwiecień"+" "+rok;
                else
                    komunikat="Data Wielkanocy "+(d+e-9)+" "+"kwiecień"+" "+rok;
            }
            Toast.makeText(this,komunikat,Toast.LENGTH_LONG).show();
        }catch (Exception blad){
            Toast.makeText(this,blad.getMessage(),Toast.LENGTH_LONG).show();
        }finally {
            et.setText("");
            tv.setText(komunikat);
        }
    }

    public void wszystko(View view){
        tv.setText("");
        et.setText("");
        String bufor="";
        for(int i=30;i<3000;i++){
            int rok = i;
            int a=rok%19;
            int b=rok%4;
            int c=rok%7;
            int d=((a*19)+A(rok))%30;
            int e=(2*b+4*c+6*d+B(rok))%7;
            if(22+d+e<=31){
                bufor+="Data Wielkanocy "+(22+d+e)+" "+"marzec"+" "+rok;
            }
            else if(22+d+e>31) {
                if ((d == 29 && e == 6) || (d == 28 && e == 6))
                    bufor+= "Data Wielkanocy " + (d + e - 9 - 7) + " " + "kwiecień" + " " + rok;
                else
                    bufor+= "Data Wielkanocy " + (d + e - 9) + " " + "kwiecień" + " " + rok;
            }
            bufor+="\r\n";
        }
        tv.setText(bufor);
        Toast.makeText(this,"Wielkanoc dla lat 30-2999",Toast.LENGTH_LONG).show();
    }

    public void marzec(View view){
        tv.setText("");
        et.setText("");
        String bufor="";
        for(int i=30;i<3000;i++){
            int rok = i;
            int a=rok%19;
            int b=rok%4;
            int c=rok%7;
            int d=((a*19)+A(rok))%30;
            int e=(2*b+4*c+6*d+B(rok))%7;
            if(22+d+e<=31){
                bufor+="Data Wielkanocy "+(22+d+e)+" "+"marzec"+" "+rok;
            }
            bufor+="\r\n";
        }
        tv.setText(bufor);
        Toast.makeText(this,"Wielkanoc w latach 30-2999 wypadająca w marcu",
                Toast.LENGTH_LONG).show();
    }

    public void kwiecien(View view){
        tv.setText("");
        et.setText("");
        String bufor="";
        for(int i=30;i<3000;i++){
            int rok = i;
            int a=rok%19;
            int b=rok%4;
            int c=rok%7;
            int d=((a*19)+A(rok))%30;
            int e=(2*b+4*c+6*d+B(rok))%7;
            if(22+d+e>31) {
                if ((d == 29 && e == 6) || (d == 28 && e == 6))
                    bufor+= "Data Wielkanocy " + (d + e - 9 - 7) + " " + "kwiecień" + " " + rok;
                else
                    bufor+= "Data Wielkanocy " + (d + e - 9) + " " + "kwiecień" + " " + rok;
            }
            bufor+="\r\n";
        }
        tv.setText(bufor);
        Toast.makeText(this,"Wielkanoc w latach 30-2999 wypadająca w kwietniu",
                Toast.LENGTH_LONG).show();
    }
}