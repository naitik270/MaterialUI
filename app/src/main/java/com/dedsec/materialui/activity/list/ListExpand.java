package com.dedsec.materialui.activity.list;

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
import com.dedsec.materialui.adapter.AdapterListExpand;
import com.dedsec.materialui.data.DataGenerator;
import com.dedsec.materialui.model.Social;
import com.dedsec.materialui.utils.Tools;
import com.dedsec.materialui.widget.LineItemDecoration;

import java.util.List;

public class ListExpand extends AppCompatActivity {

    private View parent_view;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_expand);
        parent_view = findViewById(android.R.id.content);

        initToolbar();
        initComponent();

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("List Expand");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }

    private void initComponent() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new LineItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);

        List<Social> items = DataGenerator.getSocialData(this);

        // set data and list adapter
        recyclerView.setAdapter(new AdapterListExpand(this, items));

        //on item click listener
        (new AdapterListExpand(this, items)).setOnItemClickListener(new AdapterListExpand.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Social obj, int position) {
                Snackbar.make(parent_view, "Item " + obj.name + " clicked", Snackbar.LENGTH_SHORT).show();
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
        if (item.getItemId() == android.R.id.home)
            finish();
        else
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }
}
