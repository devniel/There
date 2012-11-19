package controllers;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softudy.there.R;

public class OpcionesFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		View myFragmentView = inflater.inflate(R.layout.tab3, container, false);
		return myFragmentView;
	}
}
