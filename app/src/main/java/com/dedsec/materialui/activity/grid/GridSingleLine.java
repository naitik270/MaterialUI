package com.dedsec.materialui.activity.grid;

import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.adapter.AdapterGridSingleLine;
import com.dedsec.materialui.data.DataGenerator;
import com.dedsec.materialui.utils.Tools;
import com.dedsec.materialui.widget.SpacingItemDecoration;

import java.util.List;

public class GridSingleLine extends AppCompatActivity {

    private View parent_view;

    private RecyclerView recyclerView;
    private AdapterGridSingleLine mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_single_line);

        parent_view = findViewById(android.R.id.content);

        initToolbar();
        initComponent();
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Grid Singe Line");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(this, 3), true));
        recyclerView.setHasFixedSize(true);

        List<Integer> items = DataGenerator.getNatureImages(this);
        items.addAll(DataGenerator.getNatureImages(this));
        items.addAll(DataGenerator.getNatureImages(this));
        items.addAll(DataGenerator.getNatureImages(this));

        //set data and list adapter
        mAdapter = new AdapterGridSingleLine(this, items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterGridSingleLine.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Integer obj, int position) {
                Snackbar.make(parent_view, "Item " + (position+1) + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

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
