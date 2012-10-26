package controllers;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.softudy.there.R;

public class TagsActivity extends ListActivity {
	
	
	

	// LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
	ArrayList<String> listItems = new ArrayList<String>();

	// DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
	ArrayAdapter<String> adapter;

	// RECORDING HOW MUCH TIMES BUTTON WAS CLICKED
	int clickCounter = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		
	/*	
		
		ListView listView = (ListView) findViewById(R.id.user_list_tags);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
		  "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		  "Linux", "OS/2" };

		// First paramenter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		  android.R.layout.simple_list_item_1, android.R.id.text1, values);

		// Assign adapter to ListView
		listView.setAdapter(adapter); 
		
		setContentView(R.layout.user_tags);
		

	}
*/
		
		
			    String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
			        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
			        "Linux", "OS/2", "LA", "OP", "ZA" };
			    // Use your own layout
			    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
			        R.layout.user_tags, R.id.label, values);
			    setListAdapter(adapter);
	}
		
	 @Override
	  protected void onListItemClick(ListView l, View v, int position, long id) {
	    String item = (String) getListAdapter().getItem(position);
	    
	    Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
	  }

}
