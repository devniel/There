package controllers;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;


public class InicioFragment extends Fragment {
	
		
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	   
	
	        Intent intent = new Intent(getActivity().getBaseContext(), UserActivity.class);
	        startActivity(intent);
	        
	    }

	
}



