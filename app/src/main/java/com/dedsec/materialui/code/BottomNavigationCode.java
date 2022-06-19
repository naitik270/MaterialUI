package com.dedsec.materialui.code;

import android.content.DialogInterface;
import android.os.Handler;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AlertDialog;
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

public class BottomNavigationCode extends AppCompatActivity {

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
        setContentView(R.layout.activity_bottom_navigation_code);
        checkAndRunDialogBox();

        CodeProcessor.init(this);

        parentView = findViewById(android.R.id.content);
        //back_drop = findViewById(R.id.back_drop);

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
        txtTitle.setText("Bottom Navigation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.colorPrimaryDark);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toolbar.showOverflowMenu();
            }
        }, 1200);
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
        menu.add("Shifting");
        menu.add("Light");
        menu.add("Dark");
        menu.add("Icon");
        menu.add("Primary");
        menu.add("Map blue");
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
        } else if (item.getTitle() == "Shifting") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Light") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Dark") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Icon") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Primary") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        } else if (item.getTitle() == "Map blue") {
            txtType.setText(item.getTitle());
            xmlCodeFrag.setData(parentView, this, codeCollectorXML(item));
            javaCodeFrag.setData(parentView, this, codeCollectorJAVA(item));
        }
        return super.onOptionsItemSelected(item);
    }

    private void checkAndRunDialogBox() {
        Boolean i = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("i", true);

        if (i) {
            showWarningDialog();
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("i", false).apply();
        }
    }

    private void showWarningDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Warning");
        dialog.setIcon(R.drawable.ic_error);
        dialog.setCancelable(false);
        dialog.setMessage("Don't write whole code otherwise you will get an error. \n\nWrite only necessary code.");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();

    }



    // All Code Collector Method -------------------------------------------------------------------
    public String codeCollectorXML(MenuItem item) {
        if (item.getTitle() == "Basic") {
            try {
                InputStream is = getAssets().open("bottomnavigationBasicXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Shifting") {
            try {
                InputStream is = getAssets().open("bottomnavigationShiftingXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Light") {
            try {
                InputStream is = getAssets().open("bottomnavigationLightXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Dark") {
            try {
                InputStream is = getAssets().open("bottomnavigationDarkXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Icon") {
            try {
                InputStream is = getAssets().open("bottomnavigationIconXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Primary") {
            try {
                InputStream is = getAssets().open("bottomnavigationPrimaryXML.xml");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeXML = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeXML;
        } else if (item.getTitle() == "Map blue") {
            try {
                InputStream is = getAssets().open("bottomnavigationMapblueXML.xml");
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
                InputStream is = getAssets().open("bottomnavigationBasicJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Shifting") {
            try {
                InputStream is = getAssets().open("bottomnavigationShiftingJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Light") {
            try {
                InputStream is = getAssets().open("bottomnavigationLightJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Dark") {
            try {
                InputStream is = getAssets().open("bottomnavigationDarkJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Icon") {
            try {
                InputStream is = getAssets().open("bottomnavigationIconJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Primary") {
            try {
                InputStream is = getAssets().open("bottomnavigationPrimaryJAVA.java");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                codeJAVA = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            } return codeJAVA;
        } else if (item.getTitle() == "Map blue") {
            try {
                InputStream is = getAssets().open("bottomnavigationMapblueJAVA.java");
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
