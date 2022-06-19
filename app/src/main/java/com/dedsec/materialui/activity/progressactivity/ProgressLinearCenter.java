package com.dedsec.materialui.activity.progressactivity;

import android.os.Handler;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.adapter.AdapterListFolderFile;
import com.dedsec.materialui.model.FolderFile;
import com.dedsec.materialui.utils.ItemAnimation;
import com.dedsec.materialui.utils.Tools;
import com.dedsec.materialui.utils.ViewAnimation;

import java.util.ArrayList;
import java.util.List;

public class ProgressLinearCenter extends AppCompatActivity {

    private View parent_view;
    private final static int LOADING_DURATION = 2000;

    private RecyclerView recyclerView;
    private AdapterListFolderFile mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_linear_center);

        parent_view = findViewById(android.R.id.content);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.colorPrimary);

        loadingAndDisplayContent();
    }

    private void loadingAndDisplayContent() {
        final LinearLayout lyt_progress = (LinearLayout) findViewById(R.id.lyt_progress);
        //final ProgressBar progress_indeterminate = findViewById(R.id.progress_indeterminate);
        lyt_progress.setVisibility(View.VISIBLE);
        lyt_progress.setAlpha(1.0f);
        //progress_indeterminate.setVisibility(View.VISIBLE);
        //progress_indeterminate.setAlpha(1.0f);
        recyclerView.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewAnimation.fadeOut(lyt_progress);
                //ViewAnimation.fadeOut(progress_indeterminate);
            }
        }, LOADING_DURATION);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initComponent();
            }
        }, LOADING_DURATION + 400);
    }

    private void initComponent() {
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        List<FolderFile> items = new ArrayList<>();

        items.add(new FolderFile("Folders", true));  // add section

        items.add(new FolderFile("Photos", "Jan 9, 2017", R.drawable.ic_folder, true));
        items.add(new FolderFile("Music", "Fab 17, 2017", R.drawable.ic_folder, true));
        items.add(new FolderFile("Videos", "Jan 28, 2018", R.drawable.ic_folder, true));

        items.add(new FolderFile("Files", true));   // add section

        items.add(new FolderFile("Flower", "Jan 20, 2017", R.drawable.ic_insert_drive, false));
        items.add(new FolderFile("Girl's like you..", "Fab 10, 2017", R.drawable.ic_insert_drive, false));
        items.add(new FolderFile("Don't you need somebody", "Des 25, 2017", R.drawable.ic_insert_drive, false));

        items.add(new FolderFile("", true));   // add section

        //set data and list adapter
        mAdapter = new AdapterListFolderFile(this, items, ItemAnimation.FADE_IN);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterListFolderFile.OnItemClickListener() {
            @Override
            public void onItemClick(View view, FolderFile obj, int position) {
                Snackbar.make(parent_view, "Item " + obj.name + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_refresh_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else if (item.getItemId() == R.id.action_refresh) {
            loadingAndDisplayContent();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
