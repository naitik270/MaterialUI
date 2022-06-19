package com.dedsec.materialui.activity.bottomnavigation;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.core.widget.NestedScrollView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.utils.Tools;

public class BottomNavigationShifting extends AppCompatActivity {
    Context mContext;

    // Attributes for Bottom Navigation View
    private TextView mTextMessage;
    private BottomNavigationView navigation;
    private View search_bar;

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
                        mTextMessage.setText(item.getTitle());
                        navigation.setBackgroundColor(getResources().getColor(R.color.blue_grey_700));
                        return true;
                    case R.id.navigation_music:
                        mTextMessage.setText(item.getTitle());
                        navigation.setBackgroundColor(getResources().getColor(R.color.pink_800));
                        return true;
                    case R.id.navigation_books:
                        mTextMessage.setText(item.getTitle());
                        navigation.setBackgroundColor(getResources().getColor(R.color.grey_700));
                        return true;
                    case R.id.navigation_newsstand:
                        mTextMessage.setText(item.getTitle());
                        navigation.setBackgroundColor(getResources().getColor(R.color.teal_800));
                        return true;
                }
                return false;
            }
        });

        NestedScrollView nested_content = (NestedScrollView) findViewById(R.id.nested_scroll_view);
        nested_content.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY < oldScrollY) { // up
                    animateNavigation(false);
                    animateSearchBar(false);
                }
                if (scrollY > oldScrollY) { // down
                    animateNavigation(true);
                    animateSearchBar(true);
                }
            }
        });


        // display image
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_1), R.drawable.img_bird);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_2), R.drawable.img_fox);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_3), R.drawable.img_eroded_granite);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_4), R.drawable.img_island);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_5), R.drawable.img_mountain);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_6), R.drawable.img_balcony);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_7), R.drawable.img_flower);

        ((ImageButton) findViewById(R.id.bt_menu)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Tools.setSystemBarColor(this, R.color.grey_5);
        Tools.setSystemBarLight(this);
    }

    boolean isNavigationHide = false;

    private void animateNavigation(final boolean hide) {
        if (isNavigationHide && hide || !isNavigationHide && !hide) return;
        isNavigationHide = hide;
        int moveY = hide ? (2 * navigation.getHeight()) : 0;
        navigation.animate().translationY(moveY).setStartDelay(100).setDuration(300).start();
    }

    boolean isSearchBarHide = false;

    private void animateSearchBar(final boolean hide) {
        if (isSearchBarHide && hide || !isSearchBarHide && !hide) return;
        isSearchBarHide = hide;
        int moveY = hide ? -(2 * search_bar.getHeight()) : 0;
        search_bar.animate().translationY(moveY).setStartDelay(100).setDuration(300).start();
    }

    // For Option item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_default_dark, menu);
        return true;
    }

    // Method For Back Button ICON
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.default_action_search:
                Toast.makeText(mContext, "Search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.default_action_setting:
                Toast.makeText(mContext, "Setting", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
