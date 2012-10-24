package controllers;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import com.softudy.there.R;

public class TabActionBarActivity extends Activity {

	@TargetApi(11)
	@Override
	public void onCreate(Bundle savedinstanceState){
		
		super.onCreate(savedinstanceState);
		
		Log.d("SDSD","HOLA");
		
		ActionBar actionBar= getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		 String inicio = getResources().getString(R.string.tab_inicio);
	        Tab tab = actionBar.newTab();
	        tab.setText(inicio);
	        TabListener<Tab1Fragment> tl = new TabListener<Tab1Fragment>(this,
	                inicio, Tab1Fragment.class);
	        tab.setTabListener(tl);
	        actionBar.addTab(tab);
	        Log.d("SDSD","HOLA 2");
	        String tags = getResources().getString(R.string.tab_tag);
	        tab = actionBar.newTab();
	        tab.setText(tags);
	        TabListener<Tab2Fragment> tl2 = new TabListener<Tab2Fragment>(this,
	                tags, Tab2Fragment.class);
	        tab.setTabListener(tl2);
	        actionBar.addTab(tab);
	        Log.d("SDSD","HOLA 3");
	        String opciones = getResources().getString(R.string.tab_options);
	        tab = actionBar.newTab();
	        tab.setText(opciones);
	        
	        
	        TabListener<Tab3Fragment> tl3 = new TabListener<Tab3Fragment>(this,
	        		opciones, Tab3Fragment.class);
	        tab.setTabListener(tl3);
	        actionBar.addTab(tab);
	        Log.d("SDSD","HOLA 4");
	}

	private class TabListener<T extends Fragment> implements
			ActionBar.TabListener {
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mTag;
		private final Class<T> mClass;

		/**
		 * Constructor used each time a new tab is created.
		 * 
		 * @param activity
		 *            The host Activity, used to instantiate the fragment
		 * @param tag
		 *            The identifier tag for the fragment
		 * @param clz
		 *            The fragment's Class, used to instantiate the fragment
		 */
		public TabListener(Activity activity, String tag, Class<T> clz) {
			mActivity = activity;
			mTag = tag;
			mClass = clz;
		}

		@TargetApi(13)
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// Check if the fragment is already initialized
			if (mFragment == null) {
				// If not, instantiate and add it to the activity
				mFragment = Fragment.instantiate(mActivity, mClass.getName());
				 Log.d("SDSD","FUS");
				ft.add(android.R.id.content, mFragment, mTag);
				 Log.d("SDSD","ROH");
			} else {
				// If it exists, simply attach it in order to show it
				ft.attach(mFragment);
				 Log.d("SDSD","DAH");
			}
			
		}

		@TargetApi(13)
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			if (mFragment != null) {
				// Detach the fragment, because another one is being attached
				ft.detach(mFragment);
				 Log.d("SDSD","HOLA 6");
			}
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// User selected the already selected tab. Usually do nothing.
		}
	}
	
	
}
