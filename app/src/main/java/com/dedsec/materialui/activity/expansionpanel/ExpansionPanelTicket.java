package com.dedsec.materialui.activity.expansionpanel;

import androidx.core.widget.NestedScrollView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.utils.Tools;
import com.dedsec.materialui.utils.ViewAnimation;

public class ExpansionPanelTicket extends AppCompatActivity {

    private View parent_view;
    private NestedScrollView nested_scroll_view;
    private TextView tv_booking_code;
    private ImageButton bt_toggle_info, bt_toggle_passenger, bt_copy_code;
    private Button bt_hide_info;
    private View lyt_expand_info, lyt_expand_passenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expansio_panel_ticket);

        parent_view = findViewById(android.R.id.content);

        initToolbar();
        initComponent();
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Train Ticket");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initComponent() {
        // item_section info
        bt_toggle_info = findViewById(R.id.bt_toggle_info);
        bt_hide_info = findViewById(R.id.bt_hide_info);
        lyt_expand_info = findViewById(R.id.lyt_expand_info);
        bt_toggle_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                toggleSectionInfo(bt_toggle_info);
            }
        });

        bt_hide_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                toggleSectionInfo(bt_toggle_info);
            }
        });

        // item_section passenger
        bt_toggle_passenger = findViewById(R.id.bt_toggle_passenger);
        lyt_expand_passenger = findViewById(R.id.lyt_expand_passenger);
        bt_toggle_passenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                toggleSectionPassenger(bt_toggle_passenger);
            }
        });

        // copy to clipboard
        tv_booking_code = findViewById(R.id.tv_booking_code);
        bt_copy_code = findViewById(R.id.bt_copy_code);
        bt_copy_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.copyToClipboard(getApplicationContext(), tv_booking_code.getText().toString());
            }
        });

        // nested scrollview
        nested_scroll_view = findViewById(R.id.nested_scroll_view);

    }

    private void toggleSectionInfo(View view) {
        boolean show = toggleArroe(view);
        if (show) {
            ViewAnimation.expand(lyt_expand_info, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    Tools.nestedScrollTo(nested_scroll_view, lyt_expand_info);
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_info);
        }
    }

    private void toggleSectionPassenger(View view) {
        boolean show = toggleArroe(view);
        if (show) {
            ViewAnimation.expand(lyt_expand_passenger, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    Tools.nestedScrollTo(nested_scroll_view, lyt_expand_passenger);
                }
            });
        } else {
            ViewAnimation.collapse(lyt_expand_passenger);
        }
    }

    public boolean toggleArroe(View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(180);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }
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
