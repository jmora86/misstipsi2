package com.misstipsi.tpv;

import org.json.JSONException;
import org.json.JSONObject;
import com.misstipsi.library.UserFunctions;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class LoginActivity extends Activity implements OnClickListener{
	 
	Button zero,one, two, three, four, five, six, seven, eight, nine,ok, delete;
	EditText disp;
	String optr;
	UserFunctions userFunction;
	LinearLayout linear_error;
	public static final int cod_user = 1111;
	int logstatus=-1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//IMPIDE ROTAR PANTALLA
		setContentView(R.layout.login);
		
		one 	= (Button) findViewById(R.id.one);
        two 	= (Button) findViewById(R.id.two);
        three 	= (Button) findViewById(R.id.three);
        four 	= (Button) findViewById(R.id.four);
        five 	= (Button) findViewById(R.id.five);
        six 	= (Button) findViewById(R.id.six);
        seven 	= (Button) findViewById(R.id.seven);
        eight 	= (Button) findViewById(R.id.eight);
        nine 	= (Button) findViewById(R.id.nine);
        zero 	= (Button) findViewById(R.id.zero);
        ok 		= (Button) findViewById(R.id.ok);
        delete 	= (Button) findViewById(R.id.delete);
        
        disp = (EditText) findViewById(R.id.cajaTextLogin);
        linear_error=(LinearLayout)findViewById(R.id.liner_sms_error);
        
        try
        {
            one.setOnClickListener(this);
            two.setOnClickListener(this);
            three.setOnClickListener(this);
            four.setOnClickListener(this);
            five.setOnClickListener(this);
            six.setOnClickListener(this);
            seven.setOnClickListener(this);
            eight.setOnClickListener(this);
            nine.setOnClickListener(this);
            zero.setOnClickListener(this);
            delete.setOnClickListener(this);
            ok.setOnClickListener(this);
        }
        catch(Exception e){}

	}

	@Override
    public void onClick(View arg0) 
	{
        Editable str =  disp.getText();
        switch(arg0.getId()){
            
        	case R.id.zero:
            	str = str.append(zero.getText());
            	disp.setText(str);
            break;
        	case R.id.one:
                str = str.append(one.getText());
                disp.setText(str);
            break;
            case R.id.two:
                str = str.append(two.getText());
                disp.setText(str);
            break;
            case R.id.three:
                str = str.append(three.getText());
                disp.setText(str);
            break;
            case R.id.four:
                str = str.append(four.getText());
                disp.setText(str);
            break;
            case R.id.five:
                str = str.append(five.getText());
                disp.setText(str);
            break;
            case R.id.six:
            	str = str.append(six.getText());
                disp.setText(str);
            break;
            case R.id.seven:
                str = str.append(seven.getText());
                disp.setText(str);
            break;
            case R.id.eight:
                str = str.append(eight.getText());
                disp.setText(str);
            break;
            case R.id.nine:
                str = str.append(nine.getText());
                disp.setText(str);
            break;
            case R.id.delete:
            	if(disp.length()!= 0)
            	{
            		disp.setText(disp.getText().delete(disp.length() - 1, disp.length()));
            	}
            break;
            case R.id.ok:
            	String codigo = str.toString();
            	new FetchSQL().execute(codigo);
            break;
            
        }
    }
	
	private class FetchSQL extends AsyncTask<String,Void,Boolean> 
	{
			String usuario;
			Boolean resultado;
				
			@Override
	        protected Boolean doInBackground(String... params) {
	        	
	        	usuario = params[0];
	        	userFunction = new UserFunctions();
				JSONObject json = userFunction.loginUser(usuario);
				
	            try 
				{	
					logstatus=json.getInt("logstatus");
					
					if(logstatus==1)
					{
						resultado = true;
						
					}else
					{
						resultado = false;
					}
					 
				} catch (JSONException e) 
				{
					e.printStackTrace();
				}
				return resultado;
				
				
	        }
	        @Override
	        protected void onPostExecute(Boolean value) 
	        {
	        	if(value)
				{
	        		Intent go_plans=new Intent(getApplicationContext(),PlansActivity.class);
	        		startActivity(go_plans);
					
				}else
				{
					linear_error.setVisibility(View.VISIBLE);
					
				}
	       }
	}
	
}
