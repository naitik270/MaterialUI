
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.dedsec.materialui.R;

public class BottomNavigationPrimary extends AppCompatActivity {

    private ActionBar actionBar;
    private NestedScrollView nested_scroll_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_primary);
    }

    
    public void clickAction(View view) {
        // Implement your code..
        int id = view.getId();
        switch (id) {
            case R.id.apps_button:
                Toast.makeText(getApplicationContext(), "Apps Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.offer_button:
                Toast.makeText(getApplicationContext(), "Offer Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cart_button:
                Toast.makeText(getApplicationContext(), "Cart Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
