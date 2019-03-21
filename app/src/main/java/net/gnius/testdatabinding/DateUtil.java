package net.gnius.testdatabinding;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date long2Date(Long l) {
        Date rv = new Date();
        if (l != null) {
            rv.setTime(l);
        }
        return rv;
    }

    public static String date2String(SimpleDateFormat sdf, Date d) {
        if (d != null) {
            return sdf.format(d);
        }
        return "";
    }

    public static Date string2Date(SimpleDateFormat sdf, String s) {
        if (s != null) {
            try {
                Date d = sdf.parse(s);
                return d;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Long date2Long(Date d) {
        if (d != null) {
            return d.getTime();
        }
        return null;
    }


    public static DatePickerDialog setDateTimeField(final EditText edDate, final Context context, final SimpleDateFormat sdf) {

        Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog mDatePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                // SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                final Date startDate = newDate.getTime();
                String fdate = sdf.format(startDate);

                edDate.setText(fdate);

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        mDatePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

        edDate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDatePickerDialog.show();
                return false;
            }
        });


        return mDatePickerDialog;

    }


}
