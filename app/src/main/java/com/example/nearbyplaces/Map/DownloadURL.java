package com.example.nearbyplaces.Map;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadURL {

    public String readUrl(String myURL) throws IOException{

        String data = " ";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;

        try {
            URL url = new URL(myURL);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            BufferedReader br =new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();

            String line = " ";
            while ((line = br.readLine()) != null){

                sb.append(line);
            }

            data = sb.toString();
            br.close();

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        finally {
        inputStream.close();
        httpURLConnection.disconnect();

        }
        Log.d("DownloadURL","Returning data= "+data);

        return data;
    }
}
