package com.github.versatilevelociraptors.safetyraptor;

import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
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
    protected String doInBackground(Object[] objects) {
        OutputStream stream;
        String response = "";
        while(!response.equals("Michael is a gypsy")) {
            try {
                Socket serverSocket = new Socket(SERVER, PORT);
                DataOutputStream out = new DataOutputStream(serverSocket.getOutputStream());
                DataInputStream in = new DataInputStream(serverSocket.getInputStream());

                out.writeUTF("2585");
                response = in.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return response;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected void onCancelled() {
        super.onCancelled();
    }


}
