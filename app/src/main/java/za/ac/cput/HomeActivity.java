package za.ac.cput;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set click listeners for each category
        setCategoryClick(R.id.beautyCategory, "Beauty");
        setCategoryClick(R.id.cartBottom, "Cart");
        setCategoryClick(R.id.groceriesCategory, "Groceries");
        setCategoryClick(R.id.homeBottom, "Home");
        setCategoryClick(R.id.householdCategory, "Household");
        setCategoryClick(R.id.ordersBottom, "Orders");
        setCategoryClick(R.id.profileBottom, "Profile");
        setCategoryClick(R.id.snacksCategory, "Snacks");
    }

    private void setCategoryClick(int viewId, String categoryName) {
        ImageView category = findViewById(viewId);
        if (category != null) {
            category.setOnClickListener(v -> {
                if (categoryName.equals("Orders")) {
                    // Navigate to OrdersActivity
                    Intent intent = new Intent(HomeActivity.this, OrdersActivity.class);
                    startActivity(intent);
                } else {
                    // Show toast for other categories
                    Toast.makeText(HomeActivity.this, categoryName + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}