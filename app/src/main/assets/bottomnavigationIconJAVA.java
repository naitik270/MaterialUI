import android.graphics.PorterDuff;
import androidx.annotation.NonNull;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class BottomNavigationIcon extends AppCompatActivity {

    // Attributes -------------
    private TabLayout tab_layout;   // Bottom Tab Icon Layout
    private ActionBar actionBar;    // Up Action(Title) Bar
    private NestedScrollView nested_scroll_view;    // NestedScroll

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_icon);

        initComponent();

    }

    private void initComponent() {

        tab_layout = (TabLayout) findViewById(R.id.tab_layout);

        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_home), 0);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_search), 1);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_add_box), 2);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_favorite_border), 3);
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_person), 4);

        // set icon color pre-selected
        tab_layout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.deep_orange_500), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_IN);
        tab_layout.getTabAt(4).getIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_IN);

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.deep_orange_500), PorterDuff.Mode.SRC_IN);
                switch (tab.getPosition()) {
                    case 0:
                        // implement your code..like Toast msg.
                        break;
                    case 1:
                        // implement your code..
                        break;
                    case 2:
                        // implement your code..
                        break;
                    case 3:
                        // implement your code..
                        break;
                    case 4:
                        // implement your code..
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
