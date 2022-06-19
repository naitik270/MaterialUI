package com.dedsec.materialui.activity.grid;

import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.adapter.AdapterGridCaller;
import com.dedsec.materialui.data.DataGenerator;
import com.dedsec.materialui.model.People;
import com.dedsec.materialui.utils.Tools;
import com.dedsec.materialui.widget.SpacingItemDecoration;

import java.util.List;

public class GridCaller extends AppCompatActivity {

    private View parent_view;

    private RecyclerView recyclerView;
    private AdapterGridCaller mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_caller);

        parent_view = findViewById(android.R.id.content);

        initComponent();
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }

    private void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(this, 3), true));
        recyclerView.setHasFixedSize(true);

        List<People> items = DataGenerator.getPeopleData(this);

        //set data and list adapter
        mAdapter = new AdapterGridCaller(this, items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterGridCaller.OnItemClickListener() {
            @Override
            public void onItemClick(View view, People obj, int position) {
                Snackbar.make(parent_view, obj.name + " clicked", Snackbar.LENGTH_SHORT).show();
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
