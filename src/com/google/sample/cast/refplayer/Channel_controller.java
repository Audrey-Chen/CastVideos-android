package com.google.sample.cast.refplayer;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Channel_controller extends ActionBarActivity {

    private Button button1, button2, button3,
                   button4, button5, button6,
                   button7, button8, button9,
                   button0, button_go, button_back;

    private TextView textView, display_channel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_controller);

        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button_go = (Button)findViewById(R.id.button_go);
        button_back = (Button)findViewById(R.id.button_back);

        textView = (TextView)findViewById(R.id.textView);
        display_channel = (TextView)findViewById(R.id.display_channel);

        button0.setOnClickListener(new Button.OnClickListener(){
         @Override
         public void onClick(View v){display_channel.setText("0");}
        });

        button1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){display_channel.setText("1");}
        });

        button2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){display_channel.setText("2");}
        });

        button3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){display_channel.setText("3");}
        });

        button4.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){display_channel.setText("4");}
        });

        button5.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){display_channel.setText("5");}
        });

        button6.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){display_channel.setText("6");}
        });

        button7.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){display_channel.setText("7");}
        });

        button8.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){display_channel.setText("8");}
        });

        button9.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){display_channel.setText("9");}
        });


        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_channel_controller, menu);
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
