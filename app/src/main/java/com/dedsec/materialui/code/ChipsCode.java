package com.dedsec.materialui.code;

import android.os.Handler;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.dedsec.materialui.R;
import com.dedsec.materialui.adapter.SectionPagerAdapter;
import com.dedsec.materialui.fragment.JAVACodeFrag;
import com.dedsec.materialui.fragment.XMLCodeFrag;
import com.dedsec.materialui.utils.Tools;

import java.io.IOException;
import java.io.InputStream;

import io.github.kbiakov.codeview.classifier.CodeProcessor;

public class ChipsCode extends AppCompatActivity {

    private ViewPager view_pager;
    private TabLayout tab_layout;
    private SectionPagerAdapter mAdapter;

    // UI references
    View parentView;
    private String codeXML, codeJAVA;
    private TextView txtTitle, txtType;

    // For Fragment
    private XMLCodeFrag xmlCodeFrag;
    private JAVACodeFrag javaCodeFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chips_code);

        CodeProcessor.init(this);

        parentView = findViewById(android.R.id.content);

        // Create Object For tab fragment
        xmlCodeFrag = new XMLCodeFrag();
        javaCodeFrag = new JAVACodeFrag();

        initToolbar();
        initComponent();


    }

    private void initToolbar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtTitle = findViewById(R.id.txt_title);
        txtType = findViewById(R.id.txt_type);
        txtTitle.setText("Chips");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.colorPrimaryDark);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toolbar.showOverflowMenu();
            }
        }, 1000);
    }

    private void initComponent() {
        view_pager = findViewById(R.id.view_pager);
        mAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        view_pager.setAdapter(mAdapter);

        tab_layout = findViewById(R.id.tab_layout);
        tab_layout.setupWithViewPager(view_pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Basic");
        menu.add("Tag");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        else if (item.getTitle() == "Basic") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this,  codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Tag") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        }
        return super.onOptionsItemSelected(item);
    }


    // All Code Collector Method -------------------------------------------------------------------
    public String codeCollectorXML(MenuItem item) {
        if (item.getTitle() == "Basic") {
            try {
                InputStream is = getAssets().open("chipsBasicXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Tag") {
            try {
                InputStream is = getAssets().open("chipsTagXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        }
        return codeXML;
    }

    public String codeCollectorJAVA(MenuItem item) {
        if (item.getTitle() == "Basic") {
            try {
                InputStream is = getAssets().open("chipsBasicJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Tag") {
            try {
                InputStream is = getAssets().open("chipsTagJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        }
        return codeJAVA;
    }
}
