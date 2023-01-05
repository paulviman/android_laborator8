package com.example.laborator8;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    TextView data;
    String jsonURL = "https://www.floatrates.com/daily/ron.json";
    double rate;
    EditText number;
    Button btnUSD,btnEUR,btnGBD,btnMDL;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = findViewById(R.id.textView3);
        number = findViewById(R.id.sum);
        btnUSD=findViewById(R.id.USD);
        btnEUR=findViewById(R.id.EUR);
        btnGBD=findViewById(R.id.GBD);
        btnMDL=findViewById(R.id.MDL);
    }

    public void USD(View view) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        okhttp3.Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull okhttp3.Call call, @NonNull Response response) throws IOException {
                String recData = response.body().string();
                JSONObject emp = null;
                try {
                    emp = (new JSONObject(recData)).getJSONObject("usd");
                    Log.i(TAG, "json: " + emp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    rate = emp.getDouble("inverseRate");
                    Log.i(TAG, "rate: " + rate);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double result = Double.parseDouble(String.valueOf(number.getText())) * rate;
                Log.i(TAG, "result: " + result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        data.setText(String.valueOf(result+" Lei"));
                        btnUSD.setEnabled(false);
                        btnEUR.setEnabled(true);
                        btnMDL.setEnabled(true);
                        btnGBD.setEnabled(true);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
                Log.i(TAG, "onFailure: ");
            }

        });
    }

    public void EUR(View view) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        okhttp3.Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull okhttp3.Call call, @NonNull Response response) throws IOException {
                String recData = response.body().string();
                JSONObject emp = null;
                try {
                    emp = (new JSONObject(recData)).getJSONObject("eur");
                    Log.i(TAG, "json: " + emp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    rate = emp.getDouble("inverseRate");
                    Log.i(TAG, "rate: " + rate);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double result = Double.parseDouble(String.valueOf(number.getText())) * rate;
                Log.i(TAG, "result: " + result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        data.setText(String.valueOf(result+" Lei"));
                        btnUSD.setEnabled(true);
                        btnEUR.setEnabled(false);
                        btnMDL.setEnabled(true);
                        btnGBD.setEnabled(true);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
                Log.i(TAG, "onFailure: ");
            }

        });
    }

    public void GBP(View view) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        okhttp3.Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull okhttp3.Call call, @NonNull Response response) throws IOException {
                String recData = response.body().string();
                JSONObject emp = null;
                try {
                    emp = (new JSONObject(recData)).getJSONObject("gbp");
                    Log.i(TAG, "json: " + emp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    rate = emp.getDouble("inverseRate");
                    Log.i(TAG, "rate: " + rate);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double result = Double.parseDouble(String.valueOf(number.getText())) * rate;
                Log.i(TAG, "result: " + result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        data.setText(String.valueOf(result+" Lei"));
                        btnUSD.setEnabled(true);
                        btnEUR.setEnabled(true);
                        btnMDL.setEnabled(true);
                        btnGBD.setEnabled(false);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
                Log.i(TAG, "onFailure: ");
            }

        });
    }

    public void MDL(View view) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        okhttp3.Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull okhttp3.Call call, @NonNull Response response) throws IOException {
                String recData = response.body().string();
                JSONObject emp = null;
                try {
                    emp = (new JSONObject(recData)).getJSONObject("mdl");
                    Log.i(TAG, "json: " + emp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    rate = emp.getDouble("inverseRate");
                    Log.i(TAG, "rate: " + rate);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double result = Double.parseDouble(String.valueOf(number.getText())) * rate;
                Log.i(TAG, "result: " + result);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        data.setText(String.valueOf(result+" Lei"));
                        btnUSD.setEnabled(true);
                        btnEUR.setEnabled(true);
                        btnMDL.setEnabled(false);
                        btnGBD.setEnabled(true);

                    }
                });
            }

            @Override
            public void onFailure(@NonNull okhttp3.Call call, @NonNull IOException e) {
                Log.i(TAG, "onFailure: ");
            }

        });
    }
}