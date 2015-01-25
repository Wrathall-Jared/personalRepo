package com.hanselandpetal.catalog;

import android.net.http.AndroidHttpClient;
import org.apache.http.HttpResponse;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

/**
 * Created by Jared on 1/23/2015.
 */
public class HttpManager {


    public static String getData(String uri){

        // create an instance of the AndroidHttpClient
        AndroidHttpClient client = AndroidHttpClient.newInstance("AndroidAgent");
        HttpGet request = new HttpGet(uri);
        HttpResponse response;

        try {
            response = client.execute(request);

            // return the response
            return EntityUtils.toString(response.getEntity());
        } catch(Exception e){
            // exception handling
            e.printStackTrace();
            return null;
        } finally {
            // must close the client to make sure there are not memory leaks
            client.close();
        }
    }
}
