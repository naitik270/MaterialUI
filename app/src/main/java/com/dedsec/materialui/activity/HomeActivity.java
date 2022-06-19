package com.dedsec.materialui.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.core.widget.NestedScrollView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.activity.button.ButtonBasic;
import com.dedsec.materialui.activity.button.ButtonFabMiddle;
import com.dedsec.materialui.activity.button.ButtonFabMore;
import com.dedsec.materialui.activity.button.ButtonFabMoreText;
import com.dedsec.materialui.activity.button.ButtonInUtilities;
import com.dedsec.materialui.activity.bottomnavigation.BottomNavigationBasic;
import com.dedsec.materialui.activity.bottomnavigation.BottomNavigationMapBlue;
import com.dedsec.materialui.activity.bottomnavigation.BottomNavigationPrimary;
import com.dedsec.materialui.activity.bottomnavigation.BottomNavigationShifting;
import com.dedsec.materialui.activity.bottomnavigation.BottomNavigationLight;
import com.dedsec.materialui.activity.bottomnavigation.BottomNavigationDark;
import com.dedsec.materialui.activity.bottomnavigation.BottomNavigationIcon;
import com.dedsec.materialui.activity.bottomsheet.BottomSheetBasic;
import com.dedsec.materialui.activity.bottomsheet.BottomSheetFloating;
import com.dedsec.materialui.activity.bottomsheet.BottomSheetFull;
import com.dedsec.materialui.activity.bottomsheet.BottomSheetList;
import com.dedsec.materialui.activity.bottomsheet.BottomSheetMap;
import com.dedsec.materialui.activity.cards.CardBasic;
import com.dedsec.materialui.activity.cards.CardOverlap;
import com.dedsec.materialui.activity.cards.CardTimeline;
import com.dedsec.materialui.activity.cards.CardWizard;
import com.dedsec.materialui.activity.cards.CardWizardLight;
import com.dedsec.materialui.activity.cards.CardWizardOverlap;
import com.dedsec.materialui.activity.chips.ChipsBasic;
import com.dedsec.materialui.activity.chips.ChipsTag;
import com.dedsec.materialui.activity.dialog.DialogAdPost;
import com.dedsec.materialui.activity.dialog.DialogAddReview;
import com.dedsec.materialui.activity.dialog.DialogBasic;
import com.dedsec.materialui.activity.dialog.DialogCustom;
import com.dedsec.materialui.activity.dialog.DialogCustomDark;
import com.dedsec.materialui.activity.dialog.DialogCustomInfo;
import com.dedsec.materialui.activity.dialog.DialogCustomLight;
import com.dedsec.materialui.activity.dialog.DialogCustomWarning;
import com.dedsec.materialui.activity.dialog.DialogFullscreen;
import com.dedsec.materialui.activity.expansionpanel.ExpansionPanelTicket;
import com.dedsec.materialui.activity.expansionpanel.ExpansionPanelBasic;
import com.dedsec.materialui.activity.expansionpanel.ExpansionPanelInvoice;
import com.dedsec.materialui.activity.form.FormLogin;
import com.dedsec.materialui.activity.form.FormProfileData;
import com.dedsec.materialui.activity.form.FormSignup;
import com.dedsec.materialui.activity.form.FormTextArea;
import com.dedsec.materialui.activity.form.FormWithIcon;
import com.dedsec.materialui.activity.grid.GridAlbums;
import com.dedsec.materialui.activity.grid.GridBasic;
import com.dedsec.materialui.activity.grid.GridCaller;
import com.dedsec.materialui.activity.grid.GridSectioned;
import com.dedsec.materialui.activity.grid.GridSingleLine;
import com.dedsec.materialui.activity.grid.GridTwoLine;
import com.dedsec.materialui.activity.list.ListAnimation;
import com.dedsec.materialui.activity.list.ListBasic;
import com.dedsec.materialui.activity.list.ListDragable;
import com.dedsec.materialui.activity.list.ListExpand;
import com.dedsec.materialui.activity.list.ListMultiSelection;
import com.dedsec.materialui.activity.list.ListSectioned;
import com.dedsec.materialui.activity.list.ListSwipe;
import com.dedsec.materialui.activity.menu.MenuDrawerMail;
import com.dedsec.materialui.activity.menu.MenuDrawerNews;
import com.dedsec.materialui.activity.menu.MenuDrawerNoIcon;
import com.dedsec.materialui.activity.menu.MenuDrawerSimpleDark;
import com.dedsec.materialui.activity.menu.MenuDrawerSimpleLight;
import com.dedsec.materialui.activity.menu.MenuOverflowList;
import com.dedsec.materialui.activity.menu.MenuOverflowToolbar;
import com.dedsec.materialui.activity.picker.PickerDateDark;
import com.dedsec.materialui.activity.picker.PickerDateLight;
import com.dedsec.materialui.activity.picker.PickerLocation;
import com.dedsec.materialui.activity.picker.PickerRGBColor;
import com.dedsec.materialui.activity.picker.PickerTimeDark;
import com.dedsec.materialui.activity.picker.PickerTimeLight;
import com.dedsec.materialui.activity.progressactivity.ProgressBasic;
import com.dedsec.materialui.activity.progressactivity.ProgressCircleCenter;
import com.dedsec.materialui.activity.progressactivity.ProgressDotsBounce;
import com.dedsec.materialui.activity.progressactivity.ProgressLinearCenter;
import com.dedsec.materialui.activity.progressactivity.ProgressLinearTop;
import com.dedsec.materialui.activity.progressactivity.ProgressOnScroll;
import com.dedsec.materialui.activity.progressactivity.ProgressPullRefresh;
import com.dedsec.materialui.activity.slider.SliderColorPicker;
import com.dedsec.materialui.activity.slider.SliderDark;
import com.dedsec.materialui.activity.slider.SliderLight;
import com.dedsec.materialui.activity.snackbartoast.SnackbarAndFab;
import com.dedsec.materialui.activity.snackbartoast.SnackbarToastBasic;
import com.dedsec.materialui.activity.tabs.TabsBasic;
import com.dedsec.materialui.activity.tabs.TabsDark;
import com.dedsec.materialui.activity.tabs.TabsIcon;
import com.dedsec.materialui.activity.tabs.TabsIconLight;
import com.dedsec.materialui.activity.tabs.TabsIconStack;
import com.dedsec.materialui.activity.tabs.TabsLight;
import com.dedsec.materialui.activity.tabs.TabsRound;
import com.dedsec.materialui.activity.tabs.TabsScroll;
import com.dedsec.materialui.activity.tabs.TabsStore;
import com.dedsec.materialui.activity.tabs.TabsTextIcon;
import com.dedsec.materialui.activity.toolbar.ToolbarBasic;
import com.dedsec.materialui.activity.toolbar.ToolbarCollapse;
import com.dedsec.materialui.activity.toolbar.ToolbarCollapsePin;
import com.dedsec.materialui.activity.toolbar.ToolbarDark;
import com.dedsec.materialui.activity.toolbar.ToolbarLight;
import com.dedsec.materialui.code.BottomNavigationCode;
import com.dedsec.materialui.code.BottomSheetCode;
import com.dedsec.materialui.code.ButtonsCode;
import com.dedsec.materialui.code.CardsCode;
import com.dedsec.materialui.code.ChipsCode;
import com.dedsec.materialui.code.DialogCode;
import com.dedsec.materialui.code.ExpansionPanelsCode;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = "TEST";

    // Main CONTEXT Variable
    Context ctx;

    //int exitCounter = 0;

    // attributes for bottom sheet
    private LinearLayout _bottomSheetLayout;
    private BottomSheetBehavior _bottomSheetBehavior;


    // Other Attributes
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private View parentView;
    NestedScrollView _nestedScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ctx = this;
        parentView = findViewById(android.R.id.content);

        initToolbar();
        initComponent();
        initNavigationMenu();

        // For Bottom Sheet
        // Load Default BottomSheetLayout When app invoke
        _bottomSheetLayout = findViewById(R.id.bottom_navigation_sheet);
        _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);

        // For Close the bottom sheet when touch on screen

        LinearLayout _llBottomSheetCloser = findViewById(R.id.main_layout_ll);
        _llBottomSheetCloser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED)
                    _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        // calling Bottom Sheet IdLoader Method
        bottomSheetIdLoader();
        // calling Bottom Sheet Types opener Method
        openTypesLayout();


    }

    private void initToolbar() {
        // For Toolbar
        toolbar = findViewById(R.id.toolbar);
        appBarLayout = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white);

    }

    private void initComponent() {

        TextView _txtTitle = findViewById(R.id.toolbar_txtview);
        _txtTitle.setText(R.string.app_name);

        // when tap on Code button
        findViewById(R.id.bt_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, BottomNavigationCode.class));
            }
        });
        findViewById(R.id.bt_code_bottom_sheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, BottomSheetCode.class));
            }
        });
        findViewById(R.id.bt_code_buttons).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ButtonsCode.class));
            }
        });
        findViewById(R.id.bt_code_cards).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, CardsCode.class));
            }
        });
        findViewById(R.id.bt_code_dialogs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DialogCode.class));
            }
        });
        findViewById(R.id.bt_code_chips).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ChipsCode.class));
            }
        });
        findViewById(R.id.bt_code_expansion_panels).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ExpansionPanelsCode.class));
            }
        });


        _nestedScrollView = findViewById(R.id.main_layout);
        _nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY < oldScrollY) { // up
                    animateToolbar(false);
                }
                if (scrollY > oldScrollY) { // down
                    animateToolbar(true);
                }
            }
        });


    }

    private void initNavigationMenu() {
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                if (item.getGroupId() == R.id.grp_1) {
                    if (item.getItemId() == R.id.nav_feedback)
                        showFeedbackDialog();
                    else if (item.getItemId() == R.id.nav_developer)
                        showMakerDialog();
                    else if (item.getItemId() == R.id.nav_about)
                        //showAboutDialog();
                        startActivity(new Intent(ctx, AboutActivity.class));
                }

                drawer.closeDrawers();
                return true;
            }
        });


    }

    boolean isToolbarHide = false;
    private void animateToolbar(final boolean hide) {
        if (isToolbarHide && hide || !isToolbarHide && !hide) return;
        isToolbarHide = hide;
        int moveY = hide ? -(2 * appBarLayout.getHeight()) : 0;
        appBarLayout.animate().translationY(moveY).setStartDelay(100).setDuration(300).start();
    }

    // method for When BACK PRESSED
    @Override
    public void onBackPressed() {
        if (_bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            //exitCounter = 0;
        } else
            appCloser();
    }

    // method for BOTTOM SHEET Id loader
    private void bottomSheetIdLoader() {
        findViewById(R.id.tap1).setOnClickListener(this);
        findViewById(R.id.tap2).setOnClickListener(this);
        findViewById(R.id.tap3).setOnClickListener(this);
        findViewById(R.id.tap4).setOnClickListener(this);
        findViewById(R.id.tap5).setOnClickListener(this);
        findViewById(R.id.tap6).setOnClickListener(this);
        findViewById(R.id.tap7).setOnClickListener(this);
        findViewById(R.id.tap8).setOnClickListener(this);
        findViewById(R.id.tap9).setOnClickListener(this);
        findViewById(R.id.tap10).setOnClickListener(this);
        findViewById(R.id.tap11).setOnClickListener(this);
        findViewById(R.id.tap12).setOnClickListener(this);
        findViewById(R.id.tap13).setOnClickListener(this);
        findViewById(R.id.tap14).setOnClickListener(this);
        findViewById(R.id.tap15).setOnClickListener(this);
        findViewById(R.id.tap16).setOnClickListener(this);
        findViewById(R.id.tap17).setOnClickListener(this);
    }

    // Bottom Sheet Opener Method
    // System default inbuilt method...
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tap1: {
                _bottomSheetLayout = findViewById(R.id.bottom_navigation_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                //findViewById(R.id.tap1).startAnimation(btnTap);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap2: {
                _bottomSheetLayout = findViewById(R.id.bottom_sheet_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap3: {
                _bottomSheetLayout = findViewById(R.id.buttons_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap4: {
                _bottomSheetLayout = findViewById(R.id.cards_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap5: {
                _bottomSheetLayout = findViewById(R.id.dialogs_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap6: {
                _bottomSheetLayout = findViewById(R.id.chips_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap7: {
                _bottomSheetLayout = findViewById(R.id.expansion_panels_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap8: {
                _bottomSheetLayout = findViewById(R.id.grid_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap9: {
                _bottomSheetLayout = findViewById(R.id.lists_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap10: {
                _bottomSheetLayout = findViewById(R.id.menu_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap11: {
                _bottomSheetLayout = findViewById(R.id.pickers_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap12: {
                _bottomSheetLayout = findViewById(R.id.progress_activity_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap13: {
                _bottomSheetLayout = findViewById(R.id.sliders_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap14: {
                _bottomSheetLayout = findViewById(R.id.snackbars_toasts_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap15: {
                _bottomSheetLayout = findViewById(R.id.tabs_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap16: {
                _bottomSheetLayout = findViewById(R.id.form_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
            case R.id.tap17: {
                _bottomSheetLayout = findViewById(R.id.toolbars_sheet);
                _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // For Make Background Dark
                findViewById(R.id.bgVisible).setOnClickListener(this);
                _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                    @Override
                    public void onStateChanged(@NonNull View bottomSheet, int newState) {
                        if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                            findViewById(R.id.bgVisible).setVisibility(View.GONE);
                    }

                    @Override
                    public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                        Log.d(TAG, "onSlide: slideOffset" + slideOffset + "");
                        findViewById(R.id.bgVisible).setVisibility(View.VISIBLE);
                        findViewById(R.id.bgVisible).setAlpha(slideOffset);
                    }
                });
                break;
            }
        }
    }

    // Method For Tapped on Type of Titles
    private void openTypesLayout() {

        // T1 --BottomNavigation -------------------------------------------------------------------
        findViewById(R.id.t1_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t1l1Intent = new Intent(ctx, BottomNavigationBasic.class);
                startActivity(t1l1Intent);
            }
        });

        findViewById(R.id.t1_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t1l2Intent = new Intent(ctx, BottomNavigationShifting.class);
                startActivity(t1l2Intent);
            }
        });

        findViewById(R.id.t1_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t1l3Intent = new Intent(ctx, BottomNavigationLight.class);
                startActivity(t1l3Intent);
            }
        });

        findViewById(R.id.t1_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t1l4Intent = new Intent(ctx, BottomNavigationDark.class);
                startActivity(t1l4Intent);
            }
        });

        findViewById(R.id.t1_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t1l5Intent = new Intent(ctx, BottomNavigationIcon.class);
                startActivity(t1l5Intent);
            }
        });

        findViewById(R.id.t1_l6_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t1l6Intent = new Intent(ctx, BottomNavigationPrimary.class);
                startActivity(t1l6Intent);
            }
        });

        findViewById(R.id.t1_l7_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t1l7Intent = new Intent(ctx, BottomNavigationMapBlue.class);
                startActivity(t1l7Intent);
            }
        });

        // T2 --BottomSheet ------------------------------------------------------------------------
        findViewById(R.id.t2_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, BottomSheetBasic.class));
            }
        });

        findViewById(R.id.t2_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, BottomSheetList.class));
            }
        });

        findViewById(R.id.t2_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, BottomSheetMap.class));
            }
        });

        findViewById(R.id.t2_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, BottomSheetFloating.class));
            }
        });

        findViewById(R.id.t2_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, BottomSheetFull.class));
            }
        });

        // T3 --Button -----------------------------------------------------------------------------
        findViewById(R.id.t3_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ButtonBasic.class));
            }
        });

        findViewById(R.id.t3_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ButtonInUtilities.class));
            }
        });

        findViewById(R.id.t3_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ButtonFabMiddle.class));
            }
        });

        findViewById(R.id.t3_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ButtonFabMore.class));
            }
        });

        findViewById(R.id.t3_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ButtonFabMoreText.class));
            }
        });

        // T4 --Card -------------------------------------------------------------------------------
        findViewById(R.id.t4_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, CardBasic.class));
            }
        });

        findViewById(R.id.t4_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, CardTimeline.class));
            }
        });

        findViewById(R.id.t4_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, CardOverlap.class));
            }
        });

        findViewById(R.id.t4_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, CardWizard.class));
            }
        });

        findViewById(R.id.t4_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, CardWizardLight.class));
            }
        });

        findViewById(R.id.t4_l6_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, CardWizardOverlap.class));
            }
        });

        // T5 --Dialogs ----------------------------------------------------------------------------
        findViewById(R.id.t5_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DialogBasic.class));
            }
        });

        findViewById(R.id.t5_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DialogFullscreen.class));
            }
        });

        findViewById(R.id.t5_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DialogCustom.class));
            }
        });

        findViewById(R.id.t5_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DialogCustomInfo.class));
            }
        });

        findViewById(R.id.t5_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DialogCustomWarning.class));
            }
        });

        findViewById(R.id.t5_l6_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DialogCustomLight.class));
            }
        });

        findViewById(R.id.t5_l7_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DialogCustomDark.class));
            }
        });

        findViewById(R.id.t5_l8_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DialogAdPost.class));
            }
        });

        findViewById(R.id.t5_l9_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, DialogAddReview.class));
            }
        });

        // T6 --Chips ------------------------------------------------------------------------------
        findViewById(R.id.t6_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ChipsBasic.class));
            }
        });

        findViewById(R.id.t6_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ChipsTag.class));
            }
        });

        // T7 --ExpansionPanel ---------------------------------------------------------------------
        findViewById(R.id.t7_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ExpansionPanelBasic.class));
            }
        });

        findViewById(R.id.t7_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ExpansionPanelInvoice.class));
            }
        });

        findViewById(R.id.t7_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ExpansionPanelTicket.class));
            }
        });

        // T8 --Grid -------------------------------------------------------------------------------
        findViewById(R.id.t8_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, GridBasic.class));
            }
        });

        findViewById(R.id.t8_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, GridSingleLine.class));
            }
        });

        findViewById(R.id.t8_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, GridTwoLine.class));
            }
        });

        findViewById(R.id.t8_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, GridSectioned.class));
            }
        });

        findViewById(R.id.t8_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, GridAlbums.class));
            }
        });

        findViewById(R.id.t8_l6_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, GridCaller.class));
            }
        });

        // T9 --List -------------------------------------------------------------------------------
        findViewById(R.id.t9_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ListBasic.class));
            }
        });

        findViewById(R.id.t9_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ListSectioned.class));
            }
        });

        findViewById(R.id.t9_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ListAnimation.class));
            }
        });

        findViewById(R.id.t9_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ListExpand.class));
            }
        });

        findViewById(R.id.t9_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ListDragable.class));
            }
        });

        findViewById(R.id.t9_l6_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ListSwipe.class));
            }
        });

        findViewById(R.id.t9_l7_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ListMultiSelection.class));
            }
        });

        // T10 --Menu ------------------------------------------------------------------------------
        findViewById(R.id.t10_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, MenuDrawerNews.class));
            }
        });

        findViewById(R.id.t10_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, MenuDrawerMail.class));
            }
        });

        findViewById(R.id.t10_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, MenuDrawerSimpleLight.class));
            }
        });

        findViewById(R.id.t10_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, MenuDrawerSimpleDark.class));
            }
        });

        findViewById(R.id.t10_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, MenuDrawerNoIcon.class));
            }
        });

        findViewById(R.id.t10_l6_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, MenuOverflowToolbar.class));
            }
        });

        findViewById(R.id.t10_l7_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, MenuOverflowList.class));
            }
        });

        // T11 --Picker ----------------------------------------------------------------------------
        findViewById(R.id.t11_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, PickerDateLight.class));
            }
        });

        findViewById(R.id.t11_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, PickerDateDark.class));
            }
        });

        findViewById(R.id.t11_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, PickerTimeLight.class));
            }
        });

        findViewById(R.id.t11_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, PickerTimeDark.class));
            }
        });

        findViewById(R.id.t11_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, PickerRGBColor.class));
            }
        });

        findViewById(R.id.t11_l6_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, PickerLocation.class));
            }
        });

        // T12 --Progress Activity -----------------------------------------------------------------
        findViewById(R.id.t12_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ProgressBasic.class));
            }
        });

        findViewById(R.id.t12_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ProgressLinearCenter.class));
            }
        });

        findViewById(R.id.t12_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ProgressLinearTop.class));
            }
        });

        findViewById(R.id.t12_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ProgressCircleCenter.class));
            }
        });

        findViewById(R.id.t12_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ProgressOnScroll.class));
            }
        });

        findViewById(R.id.t12_l6_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ProgressPullRefresh.class));
            }
        });

        findViewById(R.id.t12_l7_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ProgressDotsBounce.class));
            }
        });

        // T13 --Sliders ---------------------------------------------------------------------------
        findViewById(R.id.t13_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, SliderLight.class));
            }
        });

        findViewById(R.id.t13_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, SliderDark.class));
            }
        });

        findViewById(R.id.t13_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, SliderColorPicker.class));
            }
        });

        // T14 --Snackbar Toast --------------------------------------------------------------------
        findViewById(R.id.t14_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, SnackbarToastBasic.class));
            }
        });

        findViewById(R.id.t14_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, SnackbarAndFab.class));
            }
        });

        // T15 --Tabs ------------------------------------------------------------------------------
        findViewById(R.id.t15_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, TabsBasic.class));
            }
        });

        findViewById(R.id.t15_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, TabsStore.class));
            }
        });

        findViewById(R.id.t15_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, TabsLight.class));
            }
        });

        findViewById(R.id.t15_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, TabsDark.class));
            }
        });

        findViewById(R.id.t15_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, TabsIcon.class));
            }
        });

        findViewById(R.id.t15_l6_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, TabsTextIcon.class));
            }
        });

        findViewById(R.id.t15_l7_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, TabsIconLight.class));
            }
        });

        findViewById(R.id.t15_l8_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, TabsIconStack.class));
            }
        });

        findViewById(R.id.t15_l9_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, TabsScroll.class));
            }
        });

        findViewById(R.id.t15_l10_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, TabsRound.class));
            }
        });

        // T16 --Form ------------------------------------------------------------------------------
        findViewById(R.id.t16_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, FormLogin.class));
            }
        });

        findViewById(R.id.t16_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, FormSignup.class));
            }
        });

        findViewById(R.id.t16_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, FormProfileData.class));
            }
        });

        findViewById(R.id.t16_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, FormWithIcon.class));
            }
        });

        findViewById(R.id.t16_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, FormTextArea.class));
            }
        });

        // T17 --Tabs ------------------------------------------------------------------------------
        findViewById(R.id.t17_l1_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ToolbarBasic.class));
            }
        });

        findViewById(R.id.t17_l2_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ToolbarCollapse.class));
            }
        });

        findViewById(R.id.t17_l3_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ToolbarCollapsePin.class));
            }
        });

        findViewById(R.id.t17_l4_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ToolbarLight.class));
            }
        });

        findViewById(R.id.t17_l5_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ctx, ToolbarDark.class));
            }
        });

    }

    // method for Alert_Dialog
    // MAKER Dialog
    private void showMakerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        LayoutInflater inflater = this.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialog_maker, null))
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Implement Code
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    // FEEDBACK Dialog
    private void showFeedbackDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_feedback);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        final EditText fieldEmail = (EditText) dialog.findViewById(R.id.field_email);
        final EditText fieldFeedback = (EditText) dialog.findViewById(R.id.field_feedback);

        ((AppCompatButton) dialog.findViewById(R.id.bt_cancel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ((AppCompatButton) dialog.findViewById(R.id.bt_submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = fieldEmail.getText().toString().trim();
                String feedback = fieldFeedback.getText().toString().trim();

                if (email.isEmpty() || feedback.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();

                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        Toast.makeText(ctx, "Enter Currect email", Toast.LENGTH_SHORT).show();
                } else {

                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/html");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{"techflow.developer97@gmail.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "Feedback from MaterialUI");
                    i.putExtra(Intent.EXTRA_TEXT, "Email : " + email + "\nMessage : " + feedback);
                    try {
                        startActivity(Intent.createChooser(i, "Send feedback..."));
                    } catch (android.content.ActivityNotFoundException e) {
                        Toast.makeText(ctx, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getApplicationContext(), "Submitting", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

    // Method For Exit from the App
    private long exitTime = 0;
    public void appCloser() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "Press again to exit app", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }


    // Dismiss BottomSheet When Touch Anywhere On Screen
    // Anywhere Touch Method
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (_bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                Rect outRect = new Rect();
                _bottomSheetLayout.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    return true;
                }

            }
        }
        return super.dispatchTouchEvent(event);
    }
}
