package com.dedsec.materialui.activity.bottomnavigation;

import android.graphics.PorterDuff;
import androidx.annotation.NonNull;

import com.google.android.material.tabs.TabLayout;
import androidx.core.widget.NestedScrollView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.utils.Tools;
import com.dedsec.materialui.utils.ViewAnimation;

public class BottomNavigationIcon extends AppCompatActivity {

    // Attributes -------------
    private TabLayout tab_layout;   // Bottom Tab Icon Layout
    private ActionBar actionBar;    // Up Action(Title) Bar
    private NestedScrollView nested_scroll_view;    // NestedScroll

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_icon);

        initToolbar();
        initComponent();

    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_ATOP);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Home");
        actionBar.setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.grey_20);
    }

    private void initComponent() {
        nested_scroll_view = (NestedScrollView) findViewById(R.id.nested_scroll_view);
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
                        actionBar.setTitle("Home");
                        break;
                    case 1:
                        actionBar.setTitle("Explore");
                        break;
                    case 2:
                        actionBar.setTitle("Story");
                        break;
                    case 3:
                        actionBar.setTitle("Activity");
                        break;
                    case 4:
                        actionBar.setTitle("Profile");
                        break;
                }

                ViewAnimation.fadeOutIn(nested_scroll_view);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // display image
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_1), R.drawable.img_island);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_2), R.drawable.img_bird);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_3), R.drawable.img_fox);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_4), R.drawable.img_eroded_granite);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_5), R.drawable.img_mountain);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_6), R.drawable.img_flower);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_7), R.drawable.img_balcony);

        Tools.setSystemBarColor(this, R.color.grey_5);
        Tools.setSystemBarLight(this);
    }

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
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.default_action_setting:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
