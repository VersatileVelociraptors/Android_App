package com.github.versatilevelociraptors.safetyraptor;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import static android.content.Context.SENSOR_SERVICE;

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
        boolean connected = false;
            try {
                if(connected && serverSocket.isConnected()) {
                    PrintWriter writer = new PrintWriter(serverSocket.getOutputStream());
                    writer.println("2585");
                    writer.flush();
                }
            } catch (IOException e) {
                connected = false;
                e.printStackTrace();
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
