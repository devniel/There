package test;

import static org.junit.Assert.fail;

import org.json.JSONObject;
import org.junit.Test;

import utils.GetJSONListener;
import utils.HttpPost;
import android.util.Log;
import android.widget.Toast;

public class UserTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void findById(){
		
		Long id = 1L;
		
		StringBuilder parameters = new StringBuilder();
		parameters.append("id=" + id);
		
		HttpPost hp = new HttpPost(null, new GetJSONListener() {
			public void onRemoteCallComplete(JSONObject jsonFromNet) {
				Log.d("JSON : " , jsonFromNet.toString());
			}
		});
		
		hp.execute("http://192.168.49.74:3000/users/" + id,parameters.toString());
	}

}
