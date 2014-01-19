package com.misstipsi.tpv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends Activity implements OnClickListener{
	 
	Button zero,one, two, three, four, five, six, seven, eight, nine,ok, delete;
	EditText disp;
	String optr;
	
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
            	new FetchSQL().execute();
            break;
            
        }
    }
	
	 private class FetchSQL extends AsyncTask<Void,Void,String> 
	    {
	        @Override
	        protected String doInBackground(Void... params) {
	            String retval = "";
	            try {
	                Class.forName("org.postgresql.Driver");
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	                retval = e.toString();
	            }
	            String url = "jdbc:postgresql://192.168.1.216:5432/tpvA?user=postgres&password=mainbricks"; 
	            //String url = "jdbc:postgresql://10.0.2.2/tpvA?user=postgres&password=postgres";
	            //String url = "jdbc:postgresql://10.0.2.2/postgres?user=postgres&password=postgres";
	           
	            
	            Connection conn;
	            try {
	                //DriverManager.setLoginTimeout(5);
	                conn = DriverManager.getConnection(url);
	                Statement st = conn.createStatement();
	                String sql;
	                sql = "SELECT version()";
	                ResultSet rs = st.executeQuery(sql);
	                while(rs.next()) {
	                    retval = rs.getString(1);
	                }
	                rs.close();
	                st.close();
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	                retval = e.toString();
	            }
	            return retval;
	        }
	        @Override
	        protected void onPostExecute(String value) {
	        	disp.setText(value);
	        }
	    }
	
}
