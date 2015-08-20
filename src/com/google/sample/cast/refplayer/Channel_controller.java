package com.google.sample.cast.refplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.sample.cast.refplayer.browser.VideoItemLoader;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

//import android.support.v7.app.ActionBarActivity;


public class Channel_controller extends Activity { // ActionBarActivity

    private Button button1, button2, button3,
                   button4, button5, button6,
                   button7, button8, button9,
                   button0, button_go, button_back, button_vid_list;

    private TextView textView, display_channel;
    private List<MediaInfo> videos; // load the video list
    private static final String mUrl ="http://www.cs.ccu.edu.tw/~cml100u/CSCLAB/f2.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_controller);
        SetObjFunc(); // Create and define object
        SetOnClick();


    }

    private void SetObjFunc(){
        // Define every object
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
        button_vid_list = (Button)findViewById(R.id.button_vid_list);

        textView = (TextView)findViewById(R.id.textView);
        display_channel = (TextView)findViewById(R.id.display_channel);
    }

    private void SetOnClick(){
        button0.setOnClickListener(Controller_OnClick);
        button1.setOnClickListener(Controller_OnClick);
        button2.setOnClickListener(Controller_OnClick);
        button3.setOnClickListener(Controller_OnClick);
        button4.setOnClickListener(Controller_OnClick);
        button5.setOnClickListener(Controller_OnClick);
        button6.setOnClickListener(Controller_OnClick);
        button7.setOnClickListener(Controller_OnClick);
        button8.setOnClickListener(Controller_OnClick);
        button9.setOnClickListener(Controller_OnClick);
        button_go.setOnClickListener(Controller_OnClick);
        button_back.setOnClickListener(Controller_OnClick);
        button_vid_list.setOnClickListener(Controller_OnClick);
    }

    private Button.OnClickListener Controller_OnClick = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            switch(v.getId()) // Judging which button is clicked
            {
                /* The number buttons */
                case R.id.button0: Display_Num("0");break;
                case R.id.button1: Display_Num("1");break;
                case R.id.button2: Display_Num("2");break;
                case R.id.button3: Display_Num("3");break;
                case R.id.button4: Display_Num("4");break;
                case R.id.button5: Display_Num("5");break;
                case R.id.button6: Display_Num("6");break;
                case R.id.button7: Display_Num("7");break;
                case R.id.button8: Display_Num("8");break;
                case R.id.button9: Display_Num("9");break;

                /* Other function buttons */
                case R.id.button_go: go_channel();break;
                case R.id.button_back:
                    display_channel.setText(""); // Clear the input number
                    break;
                case R.id.button_vid_list:
                    /* Back to the video list */
                    Intent intent = new Intent();
                    intent.setClass(Channel_controller.this, VideoBrowserActivity.class );
                    startActivity(intent);
                    break;
            }
        }
    };

    private void Display_Num(String S)
    {
        String new_num;
        String zero = "0";
        new_num = display_channel.getText().toString();

        if( new_num.equals(zero)  )
        {
            display_channel.setText("");
            display_channel.setText(S);
        }
        else
        {
            display_channel.setText(new_num + S);
        }
    }

    private void go_channel()
    {
        /* Get the input channel number */
        String channel = display_channel.getText().toString();
        int channel_num = Integer.parseInt(channel);

        /*
        if(channel.equals(""))
        {
            return;
        }*/

        display_channel.setText(""); // After loading channel number, then clear it

        /* TV display the video content at specific channel */
        VideoItemLoader vloader = new VideoItemLoader(Channel_controller.this, mUrl);
        videos = vloader.loadInBackground();
        find_channel( channel_num);

        /* Time Counter : after 10 secs, the screen would display the ControllerPlayer*/
        final Timer timer = new Timer();            //declare Timer
        TimerTask timerTask;    //declare TimerTask

        timerTask = new TimerTask(){
            public void run()
            {
                timer.cancel(); // Cancel the time counter
                /* Entering the Player */
                Intent intent = new Intent();
                intent.setClass(Channel_controller.this, ControllerPlayer.class);
                startActivity(intent);
            }
        };

        timer.schedule(timerTask, 10000,10000 ); // Wait 10 secs to switch the display screen
    }

    private void find_channel(int channel_num)
    {
        MediaMetadata mm ;
        String title;
        String channel = "";

        for(int i =0; i< videos.size(); i++)
        {
            mm = videos.get(i).getMetadata();
            title = mm.getString(MediaMetadata.KEY_TITLE);
            int k = 1;

            while(title.charAt(k)!= ']') {
                channel = title.substring(1, k + 1);
                k++;
            }
            int num = Integer.parseInt(channel);
            if( channel_num == num)
            {
                // Cast the channel content to TV screen

            }
        }
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
