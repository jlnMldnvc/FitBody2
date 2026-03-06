package com.link.fitbody.utils;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.link.fitbody.core.Gender;

public class Validator {

    public static Gender getSelectedGender(RadioGroup radioGroup,
                                           RadioButton maleButton,
                                           RadioButton femaleButton) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == maleButton.getId()) {
            return Gender.MALE;
        } else if (selectedId == femaleButton.getId()) {
            return Gender.FEMALE;
        }
        return Gender.UNKNOWN;
    }

    public static boolean isEmpty(EditText... editTexts) {
        for (EditText et : editTexts) {
            if (et.getText().toString().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRadioGroupSelected(RadioGroup radioGroup) {
        return radioGroup.getCheckedRadioButtonId() != -1;
    }

    public static boolean isSpinnerValid(Spinner spinner) {
        return spinner.getSelectedItemPosition() != -1;
    }

    public static double getDoubleValue(EditText editText, double defaultValue) {
        try {
            return Double.parseDouble(editText.getText().toString());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public static int getIntValue(EditText editText, int defaultValue) {
        try {
            return Integer.parseInt(editText.getText().toString());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
