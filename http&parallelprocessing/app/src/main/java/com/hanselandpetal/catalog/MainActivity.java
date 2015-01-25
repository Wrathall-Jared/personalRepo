package com.hanselandpetal.catalog;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	TextView output;
    ProgressBar pb;
    List<MyTask> tasks;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		Initialize the TextView for vertical scrolling
		output = (TextView) findViewById(R.id.textView);
		output.setMovementMethod(new ScrollingMovementMethod());

        pb = (ProgressBar) findViewById(R.id.progressBar1);
        pb.setVisibility(View.INVISIBLE);

        tasks = new ArrayList<MainActivity.MyTask>();


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_do_task) {

            // first Check to see if they are connected
            if(isOnline()) {
                requestData("http://services.hanselandpetal.com/feeds/flowers.xml");
            }
            else{
                // Error.. no connectivity
                Toast.makeText(this, "Network isn't available", Toast.LENGTH_LONG).show();
            }
		}
		return false;
	}

    private void requestData(String uri) {
        MyTask task = new MyTask();

        // pas into the async task the uri (send to background process)
        task.execute(uri);
    }

    protected void updateDisplay(String message) {
        output.append(message + "\n");
    }

    // Check network connectivity
    protected boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        // If network info isn't null and is either connected or connecting
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }else{
            return false;
        }
    }

        // Uses MyTask to to extend the Async Class (Async class allows parallel processes)
        private class MyTask extends AsyncTask<String, String, String>{

            @Override
            protected void onPreExecute() {
                updateDisplay("Starting Task");

                if(tasks.size() == 0) {
                    pb.setVisibility(View.VISIBLE);
                }
                tasks.add(this);
            }

            protected String doInBackground(String... params){

               // Http Manger handles the uri and performs the HTTP request
               // We then put the response into the content string
               String content = HttpManager.getData(params[0]);

                // send the content string back
                return content;

        }

            @Override
            protected void onPostExecute(String s) {
                updateDisplay(s);

                tasks.remove(this);
                if(tasks.size() == 0) {
                    pb.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            protected void onProgressUpdate(String... values) {
                updateDisplay(values[0]);
            }
        }

}