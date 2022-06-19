package com.dedsec.materialui.activity.tabs;

import com.google.android.material.snackbar.Snackbar;
import androidx.core.widget.NestedScrollView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.utils.Tools;
import com.dedsec.materialui.utils.ViewAnimation;

public class TabsRound extends AppCompatActivity {

    private View parent_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_round);

        initToolbar();
        initComponent();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }

    private void initComponent() {
        parent_view = (View) findViewById(R.id.main_content);

        // display image
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_1), R.drawable.img_balcony);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_2), R.drawable.img_bird);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_3), R.drawable.img_eroded_granite);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_4), R.drawable.img_flower);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_5), R.drawable.img_fox);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_6), R.drawable.img_island);
        Tools.displayImageOriginal(this, (ImageView) findViewById(R.id.image_7), R.drawable.img_mountain);
    }


    public void onButtonTabClick(View v) {
        String title = ((Button) v).getText().toString();
        title = Tools.toCamelCase(title);
        switch (v.getId()) {
            case R.id.tab_home:
                Snackbar.make(parent_view, title, Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.tab_top_artists:
                Snackbar.make(parent_view, title, Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.tab_top_albums:
                Snackbar.make(parent_view, title, Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.tab_new_releases:
                Snackbar.make(parent_view, title, Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.tab_top_songs:
                Snackbar.make(parent_view, title, Snackbar.LENGTH_SHORT).show();
                break;
        }
        getSupportActionBar().setTitle(title);
        ViewAnimation.fadeOutIn(((NestedScrollView) findViewById(R.id.nested_content)));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_default_light, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
