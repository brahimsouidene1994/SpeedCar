package com.example.speedcar.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.speedcar.model.Car;
import com.example.speedcar.global.Constants;
import com.example.speedcar.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adapter.OnCarListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private TextView emailUsetTextView;
    private TextView logoutUserTextView;

    private ArrayList<Car> cars = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cars.add(new Car(R.drawable.bugatti_chiron_h,"BUGATTI CHIRON SUPER SPORT 300","quad-turbo, 8.0-liter W-16","1,578 horsepower","1,180 pound-feet","2.6 seconds","304 mph","$3.8 million","30"));
        cars.add(new Car(R.drawable.koenigsegg_agera,"Koenigsegg Agera RS","twin-turbo, 5.0-liter V-8","1,341 horsepower","1,160 pound-feet","2.6 seconds","278 mph","$2.5 million","25"));
        cars.add(new Car(R.drawable.hennessey_venom,"Hennessey Venom GT","twin-turbo, 7.0-liter V-8","1,244 horsepower","1,155 pound-feet","2.7 seconds","270 mph","$1.2 million","13"));
        cars.add(new Car(R.drawable.bugatti_veyron,"Bugatti Veyron Super Sport","quad-turbo, 8.0-liter W-16","1,184 horsepower","1,106 pound-feet","2.6 seconds","268 mph","$2.7 million","30"));
        cars.add(new Car(R.drawable.bugatti_chiron,"Bugatti Chiron","quad-turbo, 8.0-liter W-16","1,479 horsepower","1,180 pound-feet","2.6 seconds","261 mph","$3 million","up to 300"));
        cars.add(new Car(R.drawable.koenigsegg_willstar,"Koenigsegg Agera R","twin-turbo, 5.0-liter V-8","1,124 horsepower","885 pound-feet","2.7 seconds","260 mph","$2 million","18"));
        cars.add(new Car(R.drawable.ssc_ultimate_aero,"SSC Ultimate Aero","twin-turbo, 6.3-liter V-8","1,183 horsepower","1,094 pound-feet","2.7 seconds","256 mph","$600,000","unkown"));
        cars.add(new Car(R.drawable.mclaren_speedtail,"McLaren Speedtail","twin-turbo, 4.0-liter V-8 hybrid","1,035 horsepower","848 pound-feet","2.5 seconds","250 mph","$2.2 million","106"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new Adapter(cars, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        emailUsetTextView = findViewById(R.id.textViewEmail);
        logoutUserTextView = findViewById(R.id.textViewLogout);

        String email = getIntent().getStringExtra("email");
        emailUsetTextView.setText(email);

        logoutUserTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(Constants.MY_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean(Constants.PREF_IS_CONNECTED, false);
                editor.putString(Constants.USER_CONNECTED, "");
                editor.apply();

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCarClick(int position) {
        Log.d("tag", "onCarClick : clicked." + position);

        Intent intent = new Intent(MainActivity.this, CarDetailActivity.class);

        intent.putExtra("image", cars.get(position).getImage_url());
        intent.putExtra("type", cars.get(position).getType());
        intent.putExtra("engine", cars.get(position).getEngine());
        intent.putExtra("horse_power", cars.get(position).getHorse_power());
        intent.putExtra("torque", cars.get(position).getTorque());
        intent.putExtra("mph", cars.get(position).getMph());
        intent.putExtra("top_speed", cars.get(position).getTop_speed());
        intent.putExtra("price", cars.get(position).getPrice());
        intent.putExtra("production", cars.get(position).getProduction());
        startActivity(intent);
    }
}