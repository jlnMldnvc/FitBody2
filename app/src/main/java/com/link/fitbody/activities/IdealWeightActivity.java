package com.link.fitbody.activities;

import android.os.Bundle;
import android.text.Spannable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.link.fitbody.R;
import com.link.fitbody.core.Gender;
import com.link.fitbody.core.Health;
import com.link.fitbody.utils.BaseActivity;
import com.link.fitbody.utils.ResultFormatter;
import com.link.fitbody.utils.SnackbarHelper;
import com.link.fitbody.utils.Validator;

public class IdealWeightActivity extends BaseActivity {

    RadioGroup genderRadioGroup;
    EditText heightText;
    RadioButton maleRadioButton;
    RadioButton femaleRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ideal_weight);

        setupToolbarWithBack(R.id.my_toolbar, getString(R.string.ideal_weight_title));
        setupWindowInsets(R.id.activity_ideal_weight);

        initViews();
    }

    private void initViews() {
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        heightText = findViewById(R.id.heightEditText);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
    }

    public void onCalculateClick(View view) {

        if (Validator.isEmpty(heightText) || !Validator.isRadioGroupSelected(genderRadioGroup)) {
            SnackbarHelper.showError(view, getString(R.string.error_enter_all_values_text));
            return;
        }

        Gender gender = Validator.getSelectedGender(genderRadioGroup, maleRadioButton, femaleRadioButton);
        double height = Validator.getDoubleValue(heightText, 0);

        if (height <= 0 || gender == Gender.UNKNOWN) {
            SnackbarHelper.showError(view, getString(R.string.error_invalid_values_text));
            return;
        }

        Health health = new Health();
        double result = health.calculateIdealWeight(gender, height);

        if (result > 0) {
            String message = getString(R.string.ideal_weight_result, result);
            Spannable spannable = ResultFormatter.formatResult(this, message, R.color.result_color);
            SnackbarHelper.showResult(view, spannable);
        }
    }
}