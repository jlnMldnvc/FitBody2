package com.link.fitbody.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.link.fitbody.R;
import com.link.fitbody.utils.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbarWithoutBack(R.id.my_toolbar, getString(R.string.main_title));

        setupWindowInsets(R.id.main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.info_item) {
            Snackbar.make(findViewById(R.id.main), R.string.info_text, Snackbar.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void idealWeightOnClick(View view) {
        Intent intent = new Intent(this, IdealWeightActivity.class);
        startActivity(intent);
    }

    public void calorieOnClick(View view) {
        Intent intent = new Intent(this, CalorieActivity.class);
        startActivity(intent);
    }

    public void bodyShapeOnClick(View view) {
    }
}