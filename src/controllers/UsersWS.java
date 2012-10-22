package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import utils.HttpPost;

import models.User;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class UsersWS extends AsyncTask {
	
	private static final String DEBUG_TAG = "HttpExample";
	private Context ctx;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	protected Object doInBackground(Object... params) {

		try {
			return downloadUrl(String.valueOf(params[0]));
		} catch (IOException e) {
			return "Unable to retrieve web page. URL may be invalid";
		}
	}

	public Context getCtx() {
		return ctx;
	}

	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}

	public void create(User user) {

		StringBuilder parameters = new StringBuilder();
		parameters.append("username=" + user.username);
		parameters.append("&password=" + user.password);
		parameters.append("&email=" + user.email);
		
		(new HttpPost()).execute("http://192.168.1.38:3000/users/create",parameters.toString());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
	 */

	protected void onPostExecute(Object result) {
		Toast.makeText(ctx, "ÉXITO", 1000).show();
	}

	/*
	 * DOWNLOAD URL
	 */

	private String downloadUrl(String myurl) throws IOException {
		InputStream is = null;
		// Only display the first 500 characters of the retrieved
		// web page content.
		int len = 500;

		try {
			URL url = new URL(myurl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(10000 /* milliseconds */);
			conn.setConnectTimeout(15000 /* milliseconds */);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			// Starts the query
			conn.connect();
			int response = conn.getResponseCode();
			Log.d(DEBUG_TAG, "The response is: " + response);
			is = conn.getInputStream();

			// Convert the InputStream into a string
			String contentAsString = readIt(is, len);
			return contentAsString;

			// Makes sure that the InputStream is closed after the app is
			// finished using it.
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	/*
	 * 
	 */

	// Reads an InputStream and converts it to a String.
	public String readIt(InputStream stream, int len) throws IOException,
			UnsupportedEncodingException {
		Reader reader = null;
		reader = new InputStreamReader(stream, "UTF-8");
		char[] buffer = new char[len];
		reader.read(buffer);
		return new String(buffer);
	}

	

	

}
