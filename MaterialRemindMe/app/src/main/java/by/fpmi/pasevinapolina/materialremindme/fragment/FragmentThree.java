package by.fpmi.pasevinapolina.materialremindme.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import by.fpmi.pasevinapolina.materialremindme.R;


public class FragmentThree extends Fragment {

    Button dateButton;
    TextView dateTextView;

    private Calendar calendar;
    private int year, month, day;

    private String warDate="";

    public FragmentThree() {
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int yearWar, int monthWar, int dayWar) {
            day = dayWar;
            month = monthWar;
            year = yearWar;
            int mm = monthWar + 1;
            warDate =  dayWar + "." + mm + "." + yearWar;
            dateTextView.setText(warDate);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        dateButton = (Button) view.findViewById(R.id.dateButton);
        dateTextView = (TextView) view.findViewById(R.id.dateTextView);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                DatePickerDialog d = new DatePickerDialog(getContext(), myDateListener, year, month, day);
                d.show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.check_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res;
                if (warDate.equals("1.9.1939")) {
                    res = "Correct!";
                } else {
                    res = "Incorrect! It's a shame!!!";
                }

                Snackbar.make(view, "Result: " + res, Snackbar.LENGTH_SHORT).setAction("Action", null).show();

            }
        });

        return view;
    }


}
