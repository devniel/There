package controllers;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

public class TagFragment extends Fragment {
	
	
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Intent intent = new Intent(getActivity().getBaseContext(), TagsActivity.class);
	        startActivity(intent);
	        
	      
	    }
	 

}
