package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class HttpPost extends AsyncTask<String, Void, JSONObject>{

	String result;
	GetJSONListener getJSONListener;
	
	public HttpPost(Context context, GetJSONListener listener){
		this.getJSONListener = listener;
	}


	@Override
	protected JSONObject doInBackground(String... params) {
		return post(params[0].toString(),params[1].toString());
	}
	
	@Override
	protected void onPostExecute(JSONObject json){
		Log.d("POST","Exito");
		getJSONListener.onRemoteCallComplete(json);
	}
	
	public JSONObject post(String url, String params) {
		HttpURLConnection connection = null;
		OutputStreamWriter request = null;
		URL to_url = null;
		String response = null;

		try {
			to_url = new URL(url);
			connection = (HttpURLConnection) to_url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			connection.setRequestMethod("POST");
			Log.d("POSTEANDO " , "....");
			request = new OutputStreamWriter(connection.getOutputStream());
			request.write(params);
			request.flush();
			request.close();
			String line = "";
			
			Log.d("POSTEANDO " , "....");
			
			InputStream is = connection.getInputStream();
			
			String result = convertStreamToString(is);
			
			 // A Simple JSONObject Creation
            JSONObject json = new JSONObject(result);
            
			is.close();
			
			Log.d("POSTEANDO " , "RETORNANDO");
			
			return json;
			
		} catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return null;
	}
	
	/*
	 * Convert Stream to String
	 */
	
	private static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
	
}