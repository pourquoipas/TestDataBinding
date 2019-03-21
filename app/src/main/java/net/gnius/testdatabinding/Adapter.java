package net.gnius.testdatabinding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.support.design.widget.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Adapter {
    @BindingAdapter("android:text")
    public static void int2String(TextInputEditText text, Integer value) {
        text.setText(Integer.toString(value));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static Integer string2Int(TextInputEditText text) { // }, String value) {
        return Integer.parseInt(text.getText().toString());
    }

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @BindingAdapter("android:text")
    public static void date2String(TextInputEditText text, Date value) {
        text.setText(DateUtil.date2String(sdf, value));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static Date string2Date(TextInputEditText text) { // }, String value) {
        return DateUtil.string2Date(sdf, text.getText().toString());
    }

}
