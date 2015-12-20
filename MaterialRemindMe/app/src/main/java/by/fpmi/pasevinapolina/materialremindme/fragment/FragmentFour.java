package by.fpmi.pasevinapolina.materialremindme.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import by.fpmi.pasevinapolina.materialremindme.R;

public class FragmentFour extends Fragment {

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox4;

    public FragmentFour() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_four, container, false);
        checkBox1 = (CheckBox) rootView.findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox) rootView.findViewById(R.id.checkbox2);
        checkBox4 = (CheckBox) rootView.findViewById(R.id.checkbox4);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.check_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res;
                if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox4.isChecked()) {
                    res = "Correct!";
                } else {
                    res = "Incorrect!";
                }

                Snackbar.make(view, "Result: " + res, Snackbar.LENGTH_SHORT).setAction("Action", null).show();

            }
        });

        return rootView;
    }


}
