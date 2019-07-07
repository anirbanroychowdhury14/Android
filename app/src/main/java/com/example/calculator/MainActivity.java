package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static int mode=0;
    EditText e1;
    EditText e2;
    TextView t;
    Button modes;
    Button cal;
    double ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText3);
        t=findViewById(R.id.textView3);
        modes=findViewById(R.id.button2);
        cal=findViewById(R.id.button3);
    }
    public void onModeClick(View view)
    {
        mode++;
        if(mode==4)
        mode=0;
        switch (mode) {
            case 0:
                modes.setText("SUM");
                break;
            case 1:
                modes.setText("SUB");
                break;
            case 2:
                modes.setText("MULTI");
                break;
            case 3:
                modes.setText("DIV");
                break;
        }
    }
    public void calculate(View view)
    {
        String s1,s2;
        s1=e1.getText().toString().trim();
        s2=e2.getText().toString().trim();
        if(s1.length()==0||s2.length()==0)
        {
            Toast.makeText(this,"INPUT",Toast.LENGTH_LONG).show();
            return;
        }
        double n1=Double.parseDouble(s1);
        double n2=Double.parseDouble(s2);
        switch (mode) {
            case 0:
                ans = n1 + n2;
                break;
            case 1:
                ans = n1 - n2;
                break;
            case 2:
                ans = n1 * n2;
                break;
            case 3:
                ans = n1 / n2;
                break;
        }
        t.setText(String.valueOf(ans));
    }
}
