package com.example.fahrenheittocelsiusconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText fahrenheitTemperatureEditText = findViewById(R.id.fahrenheit_temperature_edittext);
        TextView celsiusTemperatureTextView = findViewById(R.id.celsius_temperature_textview);
        Button convertToCelsiusTemperatureButton = findViewById(R.id.convert_to_celsius_temperature_button);

        convertToCelsiusTemperatureButton.setOnClickListener(v-> {
            String fahrenheitTemperatureInText = fahrenheitTemperatureEditText.getText().toString();
            if (fahrenheitTemperatureInText.isEmpty()) {
                Toast.makeText(this, R.string.empty_fields_text, Toast.LENGTH_SHORT).show();
            } else {
                float fahrenheitTemperature = Float.parseFloat(fahrenheitTemperatureInText);
                float celsiusTemperature = convertFahrenheitToCelsiusTemperature(fahrenheitTemperature);
                String celsiusTemperatureInText = String.valueOf(celsiusTemperature);
                celsiusTemperatureTextView.setText(celsiusTemperatureInText + " °C");
            }
        });
    }

    private float convertFahrenheitToCelsiusTemperature(float fahrenheitTemperature) {
        float celsiusTemperature = fahrenheitTemperature - 32;
        celsiusTemperature = (celsiusTemperature*5)/9;
        return celsiusTemperature;
    }
}