package com.misstipsi.tpv;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

import android.content.Intent;

public class PlansActivity extends Activity 
{
	Button button_session,button_reserve,button_new_service,button_options;
	ImageView image_date;
	TextView text_day,text_month;
	TextClock digital_oclock;
	Calendar calendar;
	SimpleDateFormat simple_date_format;
	String formattedDate,day,month,date_str;
	PopupWindow pwindo;
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduls);
        
        button_session 		   = (Button) findViewById(R.id.out_session);
        button_reserve 		   = (Button) findViewById(R.id.button_reserve);
        button_new_service 	   = (Button) findViewById(R.id.button_new_service);
        button_options 		   = (Button) findViewById(R.id.button_options);
        text_day 			   = (TextView)findViewById(R.id.text_day);
        text_month 			   = (TextView)findViewById(R.id.text_month);
        image_date 			   = (ImageView) findViewById(R.id.button_date);
        digital_oclock 		   = (TextClock) findViewById(R.id.digitalClock);
        simple_date_format 	   = new SimpleDateFormat("EEE-MMM-dd-HH:mm",java.util.Locale.getDefault());
        
        Date now 			   = new Date();
        date_str		       = simple_date_format.format(now);
        String[] date_complete = date_str.split("-");
        day 				   = date_complete[2];
        month 				   = date_complete[1];
        
        text_day.setText(day);
        text_month.setText(month);
        
        
        button_session.setOnClickListener(new OnClickListener() 
        {
        	@Override
	    	public void onClick(View v) 
	        {
        		Intent go_login=new Intent(getApplicationContext(), LoginActivity.class);
        		startActivity(go_login);
		    }
    	});
        
        button_reserve.setOnClickListener(new OnClickListener() 
        {
        	@Override
	    	public void onClick(View v) 
	        {
        		Toast.makeText(getApplicationContext(), "Reserves", Toast.LENGTH_SHORT).show();
		    }
    	});
        
        button_new_service.setOnClickListener(new OnClickListener() 
        {
        	@Override
	    	public void onClick(View v) 
	        {
        		Toast.makeText(getApplicationContext(), "New Service", Toast.LENGTH_SHORT).show();
        		initiatePopupWindow();
		    }
    	});
        
        button_options.setOnClickListener(new OnClickListener() 
        {
        	@Override
	    	public void onClick(View v) 
	        {
        		Toast.makeText(getApplicationContext(), "Options", Toast.LENGTH_SHORT).show();
		    }
    	});
        
      }
	
	private void initiatePopupWindow() 
	{
		try 
		{
			/*LayoutInflater inflater = (LayoutInflater) PlansActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.onshow,(ViewGroup) findViewById(R.id.popup_element));//id del layout
			pwindo = new PopupWindow(layout, 450, 695, true);
			pwindo.showAtLocation(layout, Gravity.LEFT, 0, 90);
	
			btnClosePopup = (ImageButton) layout.findViewById(R.id.btn_close_popup_window);
			btnClosePopup.setOnClickListener(cancel_button_click_listener);*/

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
 
   
}
