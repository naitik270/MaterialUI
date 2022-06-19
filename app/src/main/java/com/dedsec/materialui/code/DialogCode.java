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

public class DialogCode extends AppCompatActivity {

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
        setContentView(R.layout.activity_dialog_code);

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
        txtTitle.setText("Dialogs");
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
        menu.add("Full screen");
        menu.add("Custom");
        menu.add("Custom info");
        menu.add("Custom warning");
        menu.add("Custom light");
        menu.add("Custom dark");
        menu.add("Custom add post");
        menu.add("Custom add review");
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
        } else if (item.getTitle() == "Full screen") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Custom") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Custom info") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Custom warning") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Custom light") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Custom dark") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Custom add post") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Custom add review") {
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
                InputStream is = getAssets().open("dialogBasicXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Full screen") {
            try {
                InputStream is = getAssets().open("dialogFullScreenXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Custom") {
            try {
                InputStream is = getAssets().open("dialogCustomXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Custom info") {
            try {
                InputStream is = getAssets().open("dialogCustomInfoXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Custom warning") {
            try {
                InputStream is = getAssets().open("dialogCustomWarningXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Custom light") {
            try {
                InputStream is = getAssets().open("dialogCustomLightXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Custom dark") {
            try {
                InputStream is = getAssets().open("dialogCustomDarkXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Custom add post") {
            try {
                InputStream is = getAssets().open("dialogCustomAddPostXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Custom add review") {
            try {
                InputStream is = getAssets().open("dialogCustomAddReviewXML.xml");
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
                InputStream is = getAssets().open("dialogBasicJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Full screen") {
            try {
                InputStream is = getAssets().open("dialogFullScreenJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Custom") {
            try {
                InputStream is = getAssets().open("dialogCustomJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Custom info") {
            try {
                InputStream is = getAssets().open("dialogCustomInfoJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Custom warning") {
            try {
                InputStream is = getAssets().open("dialogCustomWarningJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Custom light") {
            try {
                InputStream is = getAssets().open("dialogCustomLightJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Custom dark") {
            try {
                InputStream is = getAssets().open("dialogCustomDarkJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Custom add post") {
            try {
                InputStream is = getAssets().open("dialogCustomAddPostJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Custom add review") {
            try {
                InputStream is = getAssets().open("dialogCustomAddReviewJAVA.java");
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
