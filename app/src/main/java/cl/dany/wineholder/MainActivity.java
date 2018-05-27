package cl.dany.wineholder;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import cl.dany.wineholder.models.Wine;
import cl.lauragc.wineholder.R;

public class MainActivity extends AppCompatActivity {

    private WineFragment wineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wineFragment = (WineFragment) getSupportFragmentManager().findFragmentById(R.id.wineFragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_wine);

                ImageButton button = dialog.findViewById(R.id.saveWineBtn);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText input = dialog.findViewById(R.id.nameEt);
                        String name = input.getText().toString();

                        EditText inputYears = dialog.findViewById(R.id.yearsEt);
                        String years = inputYears.getText().toString();

                        EditText inputVine = dialog.findViewById(R.id.yearsEt);
                        String vine = inputVine.getText().toString();

                        if (name.trim().length()>0 && years.trim().length() > 0 && vine.trim().length()>0){
                        Wine wine = new Wine();
                        wine.setName(name);
                        wine.setAge(years);
                        wine.setVine(vine);
                        wine.save();

                        wineFragment.updateList(wine);
                        } else {
                            Toast.makeText(MainActivity.this, "Ingrese toda la información", Toast.LENGTH_SHORT).show();
                        }



                        dialog.dismiss();
                    }

                });


                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
