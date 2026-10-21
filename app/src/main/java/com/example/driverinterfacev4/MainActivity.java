package com.example.driverinterfacev4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Navbar Profile click -> DriverProfile
        View navProfile = findViewById(R.id.nav_item_profile);
        if (navProfile != null) {
            navProfile.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, DriverProfile.class);
                startActivity(intent);
            });
        }

        // Delivery cards click -> DeliveryDetails
        View.OnClickListener deliveryClickListener = v -> {
            Intent intent = new Intent(MainActivity.this, DeliveryDetails.class);
            startActivity(intent);
        };

        View card1 = findViewById(R.id.card_delivery_1);
        View card2 = findViewById(R.id.card_delivery_2);
        View card3 = findViewById(R.id.card_delivery_3);
        View card4 = findViewById(R.id.card_delivery_4);

        if (card1 != null) card1.setOnClickListener(deliveryClickListener);
        if (card2 != null) card2.setOnClickListener(deliveryClickListener);
        if (card3 != null) card3.setOnClickListener(deliveryClickListener);
        if (card4 != null) card4.setOnClickListener(deliveryClickListener);
    }
}
