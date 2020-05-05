package sg.edu.rp.c346.id18016204.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    EditText amount;
    EditText pax;
Button show;
ToggleButton tb1;
ToggleButton tb2;
    TextView display;
EditText discount;
TextView each;
Button each1;
Button clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = findViewById(R.id.amount);
        pax = findViewById(R.id.pax);
show=findViewById(R.id.show);
tb1 = findViewById(R.id.toggleButtonSVS);
discount = findViewById(R.id.discount);
tb2=findViewById(R.id.toggleButtonGST);
        display = findViewById(R.id.display);
each = findViewById(R.id.eachDisplay);
each1 = findViewById(R.id.split);
clear = findViewById(R.id.clear);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tb1.isChecked() == true & tb2.isChecked()==false){
                    int sum = Integer.parseInt(amount.getText().toString());
                    int discounted = Integer.parseInt(discount.getText().toString());
                    double total = (sum*1.1)*(discounted/100);
                        display.setText("Total bills " +String.format("%.2f",total));

                }else if (tb2.isChecked() == true & tb1.isChecked()==false){
                    int sum = Integer.parseInt(amount.getText().toString());
                    double total = sum*1.07;

                    display.setText("Total bills : " + String.format("%.2f",total));
                }else if ( tb1.isChecked()==true || tb2.isChecked()==true){
                    int sum = Integer.parseInt(amount.getText().toString());
                    double total = sum*1.1 + sum*0.07;
                    display.setText("Total bills " +String.format("%.2f",total));
                }
            }
        });
each1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int number = Integer.parseInt(pax.getText().toString());

        if(tb1.isChecked() == true & tb2.isChecked()==false){
            int sum1 = Integer.parseInt(amount.getText().toString());

            double total = (sum1/number);
            each.setText("Total bills " +String.format("%.2f",total));

        }else if (tb2.isChecked() == true & tb1.isChecked()==false){
            int sum1 = Integer.parseInt(amount.getText().toString());
            double total = sum1/number;

            each.setText("Total bills : " + String.format("%.2f",total));
        }else if ( tb1.isChecked()==true || tb2.isChecked()==true){
            int sum1 = Integer.parseInt(amount.getText().toString());
            double total = sum1*1.1 + sum1*0.07;
            double finalTotal = total/number;
            each.setText("Total bills " +String.format("%.2f",finalTotal));
        }
    }
});
clear.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        pax.setText("");
        amount.setText("");
        tb1.setChecked(false);
        tb2.setChecked(false);
       each.setText("");
        display.setText("");
    }
});
    }

}