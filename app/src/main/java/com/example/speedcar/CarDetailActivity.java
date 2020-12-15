package com.example.speedcar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CarDetailActivity extends AppCompatActivity {

    private ImageView imageCarView;
    private TextView textViewType;
    private TextView textViewEngine;
    private TextView textViewHorsePower;
    private TextView textViewTorque;
    private TextView textViewMPH;
    private TextView textViewTopSpeed;
    private TextView textViewPrice;
    private TextView textViewProduction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        imageCarView = findViewById(R.id.imageCar);
        textViewType = findViewById(R.id.textViewType);
        textViewEngine = findViewById(R.id.textViewEngineValue);
        textViewHorsePower = findViewById(R.id.textViewHorsePowerValue);
        textViewTorque = findViewById(R.id.textViewTorqueValue);
        textViewMPH = findViewById(R.id.textViewMPHValue);
        textViewTopSpeed = findViewById(R.id.textViewTopSpeedValue);
        textViewPrice = findViewById(R.id.textViewPriceValue);
        textViewProduction = findViewById(R.id.textViewProductionValue);

        int imageCar = getIntent().getIntExtra("image", 0);
        String type = getIntent().getStringExtra("type");
        String engine = getIntent().getStringExtra("engine");
        String horse_power = getIntent().getStringExtra("horse_power");
        String torque = getIntent().getStringExtra("torque");
        String mph = getIntent().getStringExtra("mph");
        String top_speed = getIntent().getStringExtra("top_speed");
        String price = getIntent().getStringExtra("price");
        String production = getIntent().getStringExtra("production");

        imageCarView.setImageResource(imageCar);
        textViewType.setText(type);
        textViewEngine.setText(engine);
        textViewHorsePower.setText(horse_power);
        textViewTorque.setText(torque);
        textViewMPH.setText(mph);
        textViewTopSpeed.setText(top_speed);
        textViewPrice.setText(price);
        textViewProduction.setText(production);



    }
}