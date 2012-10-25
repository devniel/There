package controllers;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;

import com.softudy.there.R;


public class TabActionBarActivity extends Activity {

	   /** Called when the activity is first created. */
		//se tiene que borrar los themes de los styles para que no muera
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 
    	super.onCreate(savedInstanceState);
        
    	 final ActionBar actionBar = getActionBar();
     
         actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
       
       
        Tab tabA = actionBar.newTab();
        tabA.setText("Inicio");
        tabA.setTabListener(new TabListener<InicioFragment>(this, "Inicio", InicioFragment.class));
        actionBar.addTab(tabA);
        
        Tab tabB = actionBar.newTab();
        tabB.setText("Tags");
        tabB.setTabListener(new TabListener<TagFragment>(this, "Tags", TagFragment.class));
        actionBar.addTab(tabB);
        
        Tab tabC = actionBar.newTab();
        tabC.setText("Opciones");
        tabC.setTabListener(new TabListener<OpcionesFragment>(this, "Opciones", OpcionesFragment.class));
        actionBar.addTab(tabC);
        
        if (savedInstanceState != null) {
            int savedIndex = savedInstanceState.getInt("SAVED_INDEX");
            getActionBar().setSelectedNavigationItem(savedIndex);
        }
        
       
        
    }
    

    

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("SAVED_INDEX", getActionBar().getSelectedNavigationIndex());
	}

	public static class TabListener<T extends Fragment> 
    	implements ActionBar.TabListener{
    	
        private final Activity myActivity;
        private final String myTag;
        private final Class<T> myClass;

        public TabListener(Activity activity, String tag, Class<T> cls) {
            myActivity = activity;
            myTag = tag;
            myClass = cls;
        }

		public void onTabSelected(Tab tab, FragmentTransaction ft) {

			Fragment myFragment = myActivity.getFragmentManager().findFragmentByTag(myTag);
			
			// Check if the fragment is already initialized
	        if (myFragment == null) {
	            // If not, instantiate and add it to the activity
	            myFragment = Fragment.instantiate(myActivity, myClass.getName());
	            ft.add(android.R.id.content, myFragment, myTag);
	        } else {
	            // If it exists, simply attach it in order to show it
	            ft.attach(myFragment);
	        }
			
		}

		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			
			Fragment myFragment = myActivity.getFragmentManager().findFragmentByTag(myTag);
			
			if (myFragment != null) {
	            // Detach the fragment, because another one is being attached
	            ft.detach(myFragment);
	        }
			
		}

		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}
    	
    }
}