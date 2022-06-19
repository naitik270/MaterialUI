
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BottomNavigationMapBlue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_map_blue);
    }


    public void clickAction(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.map_button:
                Toast.makeText(getApplicationContext(), "Map Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.list_button:
                Toast.makeText(getApplicationContext(), "List Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_button:
                Toast.makeText(getApplicationContext(), "Add Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
