import android.content.DialogInterface;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dedsec.materialui.R;
import com.dedsec.materialui.utils.Tools;

public class DialogBasic extends AppCompatActivity {

    private View parent_view;

    private static final String[] SONG = new String[]{
            "None", "Hip-Hop", "Chill", "Desi"
    };

    private boolean[] clicked_language = new boolean[LANGUAGE.length];
    private static final String[] LANGUAGE = new String[]{
            "English", "Hindi", "Gujarati", "Marathi", "Urdu"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_basic);

        parent_view = findViewById(android.R.id.content);

        initToolbar();
        Tools.setSystemBarColor(this, R.color.colorPrimary);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Basic");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    public void clickAction(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.confirm_dialog:
                showConfirmDialog();
                break;
            case R.id.alert_dialog:
                showAlertDialog();
                break;
            case R.id.single_choice_dialog:
                showSingleChoiceDialog();
                break;
            case R.id.multi_choice_dialog:
                showMultiChoiceDialog();
                break;
        }
    }

    private void showConfirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Use Google's location services ?");
        builder.setMessage("Allow your location service for better performance");
        builder.setPositiveButton(R.string.AGREE, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar.make(parent_view, "Agree clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.DISAGREE, null);
        builder.show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Discard draft ?");
        builder.setPositiveButton(R.string.DISCARD, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar.make(parent_view, "Discard clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.CANCEL, null);
        builder.show();
    }


    private String single_choice_selected;

    private void showSingleChoiceDialog() {
        single_choice_selected = SONG[0];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Phone Ringtone");
        builder.setSingleChoiceItems(SONG, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                single_choice_selected = SONG[i];
            }
        });
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar.make(parent_view, "selected : " + single_choice_selected, Snackbar.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.CANCEL, null);
        builder.show();
    }

    private void showMultiChoiceDialog() {
        single_choice_selected = LANGUAGE[0];
        clicked_language = new boolean[LANGUAGE.length];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Your preferred language");
        builder.setMultiChoiceItems(LANGUAGE, clicked_language, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                clicked_language[i] = b;
            }
        });
        builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Snackbar.make(parent_view, "Data submitted", Snackbar.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.CANCEL, null);
        builder.show();
    }
}
