package com.sparrow.eslam.football;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class TestAsync extends AsyncTask<Void,Players[],Void> {
    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://api.football-data.org/v1/teams/498/players");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            Scanner scanner = new Scanner(connection.getInputStream());
            String response = "";
            while (scanner.hasNext()){
                response+=scanner.next();
            }
            Log.i("Eslam...",response);
            String palyersArray = response.substring(response.indexOf("["),response.lastIndexOf("]")+1);
            Log.i("Eslam...",palyersArray);
            Players[] players = new Gson().fromJson(palyersArray,Players[].class);
            publishProgress(players);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Players[]... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
