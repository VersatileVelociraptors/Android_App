package com.github.versatilevelociraptors.safetyraptor;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by root on 10/29/16.
 */

public class ClientTask extends AsyncTask {
    private Socket serverSocket;
    public static final String SERVER = "172.25.75.108";
    public static final int PORT = 2585;
    private PrintWriter writer;
    @Override
    protected Object doInBackground(Object[] objects) {
        OutputStream stream;
        try {
            serverSocket = new Socket(SERVER, PORT);
            DataOutputStream out = new DataOutputStream(serverSocket.getOutputStream());
            out.writeUTF("2585");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }


}
