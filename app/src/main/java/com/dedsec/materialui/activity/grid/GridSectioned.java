package com.dedsec.materialui.activity.grid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.adapter.AdapterGridSectioned;
import com.dedsec.materialui.data.DataGenerator;
import com.dedsec.materialui.model.SectionImage;
import com.dedsec.materialui.utils.Tools;

import java.util.ArrayList;
import java.util.List;

public class GridSectioned extends AppCompatActivity {

    private View parent_view;

    private RecyclerView recyclerView;
    private AdapterGridSectioned mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_sectioned);

        parent_view = findViewById(android.R.id.content);

        initToolbar();
        initComponent();
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sectioned");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setHasFixedSize(true);

        List<Integer> items_img = DataGenerator.getNatureImages(this);
        items_img.addAll(DataGenerator.getNatureImages(this));
        items_img.addAll(DataGenerator.getNatureImages(this));
        items_img.addAll(DataGenerator.getNatureImages(this));
        items_img.addAll(DataGenerator.getNatureImages(this));

        List<SectionImage> items = new ArrayList<>();
        for (Integer i : items_img) {
            items.add(new SectionImage(i, "IMG_" + i + ".jpg", false));
        }

        int sect_count = 0;
        int sect_idx = 0;
        List<String> months = DataGenerator.getStringsMonth(this);
        for (int i = 0; i < items.size() / 10; i++) {
            items.add(sect_count, new SectionImage(-1, months.get(sect_idx), true));
            sect_count = sect_count + 10;
            sect_idx++;
        }

        //set data and list adapter
        mAdapter = new AdapterGridSectioned(this, items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterGridSectioned.OnItemClickListener() {
            @Override
            public void onItemClick(View view, SectionImage obj, int position) {

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
