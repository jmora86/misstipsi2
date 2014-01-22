/**
 * Author: Ravi Tamada
 * URL: www.androidhive.info
 * twitter: http://twitter.com/ravitamada
 * */
package com.misstipsi.library;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.content.Context;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

public class UserFunctions {
	
	private JSONParser jsonParser;
	
	private static String IP_Server="ubumainbricks.cloudapp.net";//IP DE NUESTRO Servidor  
	private static String loginURL="http://"+IP_Server+"/android/login.php";//ruta en donde estan nuestros archivos
	
	
	// constructor
	public UserFunctions(){
		jsonParser = new JSONParser();
	}
	
	/**
	 * function make Login Request
	 * @param email
	 * @param password
	 * */
	public JSONObject loginUser(String usuario){
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("usuario", usuario));
		JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
		
		
		Log.e("JSON", json.toString());
		return json;
	}
	
	public void err_login(Context context)
    {
    	Vibrator vibrator =(Vibrator)(context.getSystemService(Context.VIBRATOR_SERVICE));
	    vibrator.vibrate(200);
	    Toast toast1 = Toast.makeText(context.getApplicationContext(),"Nombre de usuario o password incorrectos", Toast.LENGTH_SHORT);
 	    toast1.show();    	
    }

	
	
}
