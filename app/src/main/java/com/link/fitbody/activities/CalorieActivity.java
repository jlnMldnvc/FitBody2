package com.link.fitbody.activities;

import android.os.Bundle;
import android.text.Spannable;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.link.fitbody.R;
import com.link.fitbody.core.Gender;
import com.link.fitbody.core.Health;
import com.link.fitbody.utils.BaseActivity;
import com.link.fitbody.utils.ResultFormatter;
import com.link.fitbody.utils.SnackbarHelper;
import com.link.fitbody.utils.Validator;

public class CalorieActivity extends BaseActivity {
    EditText ageEditText;
    RadioGroup genderRadioGroup;
    RadioButton maleRadioButton;
    RadioButton femaleRadioButton;
    EditText heightEditText;
    EditText weightEditText;
    Spinner activitySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);

        setupToolbarWithBack(R.id.my_toolbar, getString(R.string.calorie_calculator_title));
        setupWindowInsets(R.id.activity_calorie);

        initViews();
        loadSpinnerValues();
    }

    private void initViews() {
        ageEditText = findViewById(R.id.ageEditText);
        heightEditText = findViewById(R.id.heightEditText);
        weightEditText = findViewById(R.id.weightEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        activitySpinner = findViewById(R.id.activitySpinner);

        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
    }

    private String[] spinnerValues;

    private void loadSpinnerValues() {
        spinnerValues = getResources().getStringArray(R.array.spinner_values);
    }

    private double getSelectedActivityFactor() {
        int position = activitySpinner.getSelectedItemPosition();
        if (position >= 0 && position < spinnerValues.length) {
            return Double.parseDouble(spinnerValues[position]);
        }
        return 1.0;
    }

    public void onCalculateClick(View view) {

        if (Validator.isEmpty(heightEditText, weightEditText, ageEditText) ||
                !Validator.isRadioGroupSelected(genderRadioGroup) ||
                !Validator.isSpinnerValid(activitySpinner)) {

            SnackbarHelper.showError(view, getString(R.string.error_enter_all_values_text));
            return;
        }

        int age = Validator.getIntValue(ageEditText, 0);
        double weight = Validator.getDoubleValue(weightEditText, 0);
        double height = Validator.getDoubleValue(heightEditText, 0);
        Gender gender = Validator.getSelectedGender(genderRadioGroup, maleRadioButton, femaleRadioButton);
        double activity = getSelectedActivityFactor();

        if (age <= 0 || height <= 0 || weight <= 0 || gender == Gender.UNKNOWN) {
            SnackbarHelper.showError(view, getString(R.string.error_invalid_values_text));
            return;
        }

        Health health = new Health();
        int result = health.calculateCalorie(gender, age, height, weight, activity);
        if (result != -1) {
            String message = getString(R.string.calorie_calc_result, result);
            Spannable spannable = ResultFormatter.formatResult(this, message, R.color.result_color);
            SnackbarHelper.showResult(view, spannable);
        } else {
            SnackbarHelper.showError(view, getString(R.string.error_calculation_failed));
        }
    }
}