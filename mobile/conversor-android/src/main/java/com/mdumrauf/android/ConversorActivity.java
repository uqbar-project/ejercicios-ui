package com.mdumrauf.android;

import android.app.Activity;
import android.os.Bundle;

public class ConversorActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setTitle("Conversor de millas a kilómetros");
        setContentView(R.layout.main);
    }

}

