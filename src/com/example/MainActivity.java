package com.example;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;


public class MainActivity extends Activity 
{
	private Button start,stop;
	private MediaPlayer mp;
	private TextView tv;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.start);
        stop=(Button)findViewById(R.id.stop);
        tv=(TextView)findViewById(R.id.tv);
        final MyCounter timer = new MyCounter(600000, 1000);
        start.setOnClickListener(new OnClickListener()
   	 	{
            public void onClick(View v)
            {
               timer.start();
           	 
            }
        });
        
        stop.setOnClickListener(new OnClickListener()
   	 	{
            public void onClick(View v)
            {
               timer.cancel();
           	 
            }
        });
        
    }

 
    public class MyCounter extends CountDownTimer
	 {
		
	        public MyCounter(long millisInFuture, long countDownInterval)
	        {
	            super(millisInFuture, countDownInterval);
	        }
	 
	        @Override
	        public void onFinish()
	        {
	            tv.setText("Playing sound");
	            mp = MediaPlayer.create(MainActivity.this, R.raw.sample);
                mp.setOnCompletionListener(new OnCompletionListener() 
                {
                    public void onCompletion(MediaPlayer mp) 
                    {
                        // TODO Auto-generated method stub
                        mp.release();
                    }

                });   
                mp.start();
	           
	        }
	 
	        @Override
	        public void onTick(long millisUntilFinished)
	        {
	        	if((millisUntilFinished/60000)>1)
	        	{	
	            	tv.setText("Your timer will expire in" + " " + (millisUntilFinished/60000)+ " " + "minutes." );
	        	}
	        	else if((millisUntilFinished/60000)==1)
	        	{
	        	    tv.setText("Your timer will expire in" + " " + (millisUntilFinished/60000)+ " " + "minute." );
	    	        
	        	}
	        	else
	        	    tv.setText("Your timer will expire in few seconds." );
		        
	        	
	        	}
	        
	 		}
	    
	 
	 }
    
    

