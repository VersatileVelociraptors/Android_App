package com.github.versatilevelociraptors.safetyraptor;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import com.github.versatilevelociraptors.safetyraptor.AsyncResponse;

public class MainActivity extends AppCompatActivity implements SensorEventListener {



    private Sensor gyro;
    private SensorManager sensorManager;
    private TextView gyroText;
    private int x,y,z;
    private PrintWriter writer;
    private Socket serverSocket;
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Connecting to server...", Toast.LENGTH_LONG).show();
                writer = null;
                x = 0;
                y = 0;
                z = 0;

                new ClientTask(new AsyncResponse() {
                    @Override
                    public void print(String output){
                        System.out.println(output);
                    }

                    @Override
                    public void setPrintWriter(PrintWriter writ) {
                        writer = writ;
                    }

                    @Override
                    public void setSocket(Socket socket) {
                        serverSocket = socket;
                    }
                }).execute(savedInstanceState);
            }
        });

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(this, gyro, SensorManager.SENSOR_DELAY_NORMAL);

        gyroText = (TextView) findViewById(R.id.gyro);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int dX = (int)sensorEvent.values[0];
        int dY = (int)sensorEvent.values[1];
        int dZ = (int)sensorEvent.values[2];
        if (writer != null) {
            writer.println("" + dX + " " + dY + " " + dZ);
            writer.flush();
        }
        gyroText.setText("X: " + dX + " Y: " + dY + " Z: " + dZ);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
