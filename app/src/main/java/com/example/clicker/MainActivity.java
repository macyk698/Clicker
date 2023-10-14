package com.example.clicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView counterText;
    private Button incrementButton;
    private Button resetButton;
    private Switch toggleSwitch;
    private int count = 0;
    private int incrementValue = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.counterText);
        incrementButton = findViewById(R.id.incrementButton);
        resetButton = findViewById(R.id.resetButton);
        toggleSwitch = findViewById(R.id.toggleSwitch);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += incrementValue;
                updateCounter();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                updateCounter();
            }
        });

        toggleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                incrementValue = isChecked ? -1 : 1;
            }
        });
    }

    private void updateCounter() {
        counterText.setText("Licznik: " + count);
    }
}
