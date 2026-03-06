package com.link.fitbody.utils;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
    }

    protected void setupToolbar(int toolbarId, String title, boolean showBackButton) {
        Toolbar myToolbar = findViewById(toolbarId);
        setSupportActionBar(myToolbar);
        setTitle(title);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null && showBackButton) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void setupToolbarWithBack(int toolbarId, String title) {
        setupToolbar(toolbarId, title, true);
    }

    protected void setupToolbarWithoutBack(int toolbarId, String title) {
        setupToolbar(toolbarId, title, false);
    }

    protected void setupWindowInsets(int rootViewId) {
        View rootView = findViewById(rootViewId);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}