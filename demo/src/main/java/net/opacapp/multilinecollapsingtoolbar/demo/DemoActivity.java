package net.opacapp.multilinecollapsingtoolbar.demo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;

import net.opacapp.multilinecollapsingtoolbar.CollapsingToolbarLayout;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        AppBarLayout appBarLayout = findViewById(R.id.appbarLayout);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsingToolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appBarLayout.addOnOffsetChangedListener((appBarLayout1, verticalOffset) -> {
            float value = 1f + (float) verticalOffset / (float) appBarLayout1.getTotalScrollRange();
            int result = (int) (value * 255);
            collapsingToolbar.getTextAlphaHelper().updateTextAlpha(result);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
