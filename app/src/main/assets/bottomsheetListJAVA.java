import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.adapter.AdapterPeople;
import com.dedsec.materialui.data.DataGenerator;
import com.dedsec.materialui.utils.Tools;
import com.dedsec.materialui.model.People;

public class BottomSheetList extends AppCompatActivity {

    // Main Context Variable
    Context mContext;

    // Other Attributes
    private RecyclerView recyclerView;
    private AdapterPeople adapter;

    // attributes for bottom sheet
    private BottomSheetBehavior mBehavior;
    private BottomSheetDialog mBottomSheetDialog;
    private View bottom_sheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_list);
        mContext = BottomSheetList.this;

        initComponent();
        initToolbar();
        showBottomSheetDialog(adapter.getItem(0));
        Tools.setSystemBarColor(this, R.color.colorPrimary);

    }


    private void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //set data and list adapter
        adapter = new AdapterPeople(this, DataGenerator.getPeopleData(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new AdapterPeople.OnItemClickListener() {
            @Override
            public void onItemClick(View view, People obj, int pos) {
                showBottomSheetDialog(obj);
            }
        });

        bottom_sheet = findViewById(R.id.bottom_sheet);
        mBehavior = BottomSheetBehavior.from(bottom_sheet);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this);
    }

    private void showBottomSheetDialog(final People people) {
        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        final View view = getLayoutInflater().inflate(R.layout.sheet_bottom_sheet_list, null);

        ((View) view.findViewById(R.id.lyt_share)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Share '" + people.name + "' clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ((View) view.findViewById(R.id.lyt_get_link)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Get link '" + people.name + "' clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ((View) view.findViewById(R.id.lyt_edit_name)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Edit '" + people.name + "' clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ((View) view.findViewById(R.id.lyt_delete_collection)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Delete '" + people.name + "' clicked", Toast.LENGTH_SHORT).show();
            }
        });

        mBottomSheetDialog = new BottomSheetDialog(this);
        mBottomSheetDialog.setContentView(view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBottomSheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        mBottomSheetDialog.show();
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mBottomSheetDialog = null;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_default_light, menu);
        return true;
    }

    // Method For Back Button ICON
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.default_action_search:
                Toast.makeText(mContext, "Search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.default_action_setting:
                Toast.makeText(mContext, "Setting", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
