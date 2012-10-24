package controllers;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.softudy.there.R;
 
public class Tab1Fragment extends Fragment {
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	 Log.d("SDSD","ROH 2");
        return (LinearLayout) inflater.inflate(R.id.tab1, container, false);
    }
 
}
