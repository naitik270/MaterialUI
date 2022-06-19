import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class BottomNavigationShifting extends AppCompatActivity {
    Context mContext;

    // Attributes for Bottom Navigation View
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_shifting);
        mContext = BottomNavigationShifting.this;

        initComponent();

    }

    // Method For  BottomNavigationView
    private void initComponent() {
        search_bar = (View) findViewById(R.id.search_bar);
        mTextMessage = (TextView) findViewById(R.id.search_text);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_movie:
                        // implement your code..
                        return true;
                    case R.id.navigation_music:
                        // implement your code..
                        return true;
                    case R.id.navigation_books:
                        // implement your code..
                        return true;
                    case R.id.navigation_newsstand:
                        // implement your code..
                        return true;
                }
                return false;
            }
        });
    }
}