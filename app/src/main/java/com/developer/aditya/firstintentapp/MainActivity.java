package com.developer.aditya.firstintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity=2;
    TextView textView;
    TextView textView1;
    EditText editText;
    CheckBox checkBox1;
    CheckBox checkBox2;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.quantity);
        textView1 = (TextView)findViewById(R.id.editName1);
        editText = (EditText)findViewById(R.id.editName);
        checkBox1 = (CheckBox) findViewById(R.id.chocolate);
        checkBox2 = (CheckBox)findViewById(R.id.whippedcream);
    }
    public void increment(View view)
    {
        quantity+=1;
        textView.setText(""+quantity);
    }
    public void decrement(View view)
    {
        if(quantity>0)
        quantity-=1;
        textView.setText(""+quantity);
    }
    public void updateOrder(View view)
    {
        String name = editText.getText().toString();
        int bill=quantity*8;
        boolean c = checkBox1.isChecked();
        boolean w = checkBox2.isChecked();
        if(c) bill=bill+quantity*5;
        if(w) bill=bill+quantity*8;
        message="Name : "+name+"\nAdd whipped Cream : "+w+"\nAdd Chocolate : "+c+"\nQuantity : "+quantity+"\nBill :"+bill+"\nThank You :-) ";
        textView1.setText(message);
    }
    public void mail(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: "));
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Bill from coffee house");
        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivity(intent);
        }
    }


}
