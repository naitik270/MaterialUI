package com.dedsec.materialui.activity.chips;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.utils.Tools;
import com.hootsuite.nachos.NachoTextView;
import com.hootsuite.nachos.terminator.ChipTerminatorHandler;

import java.util.ArrayList;
import java.util.List;

public class ChipsTag extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chips_tag);

        initToolbar();
        iniComponent();
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tag");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void iniComponent() {
        NachoTextView et_tag = (NachoTextView) findViewById(R.id.et_tag);
        List<String> items = new ArrayList<>();
        items.add("mountain");
        items.add("rock");
        et_tag.setText(items);
        et_tag.addChipTerminator('\n', ChipTerminatorHandler.BEHAVIOR_CHIPIFY_ALL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_done, menu);
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
