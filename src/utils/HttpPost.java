package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

public class HttpPost extends AsyncTask{

	@Override
	protected Object doInBackground(Object... params) {
		post(params[0].toString(),params[1].toString());
		return null;
	}
	
	protected void onPostExecute(Long result){
		
	}
	
	public void post(String url, String params) {
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

			request = new OutputStreamWriter(connection.getOutputStream());
			request.write(params);
			request.flush();
			request.close();
			String line = "";
			InputStreamReader isr = new InputStreamReader(
					connection.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			StringBuilder sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			// Response from server after login process will be stored in
			// response variable.
			response = sb.toString();
			isr.close();
			reader.close();

		} catch (IOException e) {
			// Error
		}
	}
	
}