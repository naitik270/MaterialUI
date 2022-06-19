package com.dedsec.materialui.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dedsec.materialui.R;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "AboutPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initToolbar();
        initComponent();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initComponent() {
        findViewById(R.id.link_github).setOnClickListener(this);
        findViewById(R.id.link_insta).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            this.finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.link_github: {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/naitik270"));
                startActivity(i);
                //Toast.makeText(this, "github", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.link_insta: {
                try {
                    Uri uri = Uri.parse("https://www.instagram.com/techflow_developer/?hl=en");
                    Intent j = new Intent(Intent.ACTION_VIEW, uri);
                    j.setPackage("com.instagram.android");
                    startActivity(j);
                } catch (ActivityNotFoundException e) {
                    // when package not found !!
                    Intent j = new Intent(Intent.ACTION_VIEW);
                    j.setData(Uri.parse("https://www.instagram.com/techflow_developer/?hl=en"));
                    startActivity(j);
                    Log.d(TAG, "onClick: linkInsta" + e.getMessage());
                }
                break;
            }
        }
    }
}
