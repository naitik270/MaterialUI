import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.dedsec.materialui.R;
import com.dedsec.materialui.utils.Tools;

public class BottomSheetBasic extends AppCompatActivity {

    // Main Context Variable
    Context mContext;

    // Other Attributes
    CoordinatorLayout _clMainLayout;
    View bgView;
    ListView personLV;
    //ArrayAdapter<String> adapterListView;
    TextView personNameTxt;

    int[] PersonIMAGES = {R.drawable.person1, R.drawable.person2, R.drawable.person3,
            R.drawable.person1, R.drawable.person2, R.drawable.person3,
            R.drawable.person1, R.drawable.person2, R.drawable.person3,
            R.drawable.person1, R.drawable.person2, R.drawable.person3,
            R.drawable.person1, R.drawable.person2};
    String[] PersonNAME = {"Evans Collins", "Sarah Scott","Betty L", "Garcia Lewis", "Anderson Thomas",
            "Kevin John", "Laura Michelle", "Roberts", "Adams Green",
            "Roberts Turner", "Mary Jackson", "Miller Wilson", "Betty C",
            "Elizabeth"};


    // attributes for bottom sheet
    private LinearLayout _bottomSheetLayout;
    private BottomSheetBehavior _bottomSheetBehavior;
    private Button _btnSheetClose, _btnSheetDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_basic);
        mContext = BottomSheetBasic.this;
        _clMainLayout = findViewById(R.id.main_layout_t2_l1);

        // For Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Basic");
        // For Back Button Icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_menu_white));


        // For Bottom Sheet
        // Sheet
        _bottomSheetLayout = findViewById(R.id.bottom_sheet_l1_sheet);
        _bottomSheetBehavior = BottomSheetBehavior.from(_bottomSheetLayout);
        // For Make Background Dark
        bgView = findViewById(R.id.bgVisible);
        _bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED)
                    bgView.setVisibility(View.GONE);
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.d("TEST", "onSlide: slideOffset" + slideOffset + "");
                bgView.setVisibility(View.VISIBLE);
                bgView.setAlpha(slideOffset);
            }
        });
        bgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (_bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED)
                    _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        // BottomSheet Button
        _btnSheetClose = findViewById(R.id.bottom_sheet_close_btn);
        _btnSheetDetails = findViewById(R.id.bottom_sheet_details_btn);
        _btnSheetClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        _btnSheetDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DETAILS", "clicked");
                Toast.makeText(mContext, "Details clicked", Toast.LENGTH_SHORT).show();
            }
        });



        // For ListView Person NAme
        personLV = findViewById(R.id.listview_person_name);
        personNameTxt = findViewById(R.id.txt_person_name);

        //final ArrayList<String>  arrayPersonName = new ArrayList<>();
        //arrayPersonName.addAll(Arrays.asList(getResources().getStringArray(R.array.array_person_name)));
        //adapterListView = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, arrayPersonName);
        customAdapter customAdapter = new customAdapter();
        personLV.setAdapter(customAdapter);

        personLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                personNameTxt.setText(PersonNAME[position]);
                _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        Tools.setSystemBarColor(this, R.color.blue_A700);


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
        if (_bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED)
            _bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        else
            super.onBackPressed();
    }

    // Base Class For Custom Listview..
    class customAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return PersonIMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int pos, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_list_view_1, null);
            ImageView personImg = view.findViewById(R.id.imgView_person_img);
            TextView personNameTxt = view.findViewById(R.id.txt_person_name);


            personImg.setImageResource(PersonIMAGES[pos]);
            personNameTxt.setText(PersonNAME[pos]);
            return view;
        }
    }

}
