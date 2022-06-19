import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class BottomNavigationLight extends AppCompatActivity {
    Context mContext;

    // Attributes for Bottom Navigation View
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_light);
        mContext = BottomNavigationLight.this;

        bottomNavigationViewHandler();
    }

    // Method For  BottomNavigationView
    public void bottomNavigationViewHandler() {
        bottomNavigationView = findViewById(R.id.t1_l3_bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_recent:
                        // implement your code..
                        return true;
                    case R.id.navigation_favorites:
                        // implement your code..
                        return true;
                    case R.id.navigation_nearby:
                        // implement your code..
                        return true;
                    default:
                        return false;
                }
            }
        });
    }
}
