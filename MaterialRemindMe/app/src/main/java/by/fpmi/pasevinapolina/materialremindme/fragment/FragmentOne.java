package by.fpmi.pasevinapolina.materialremindme.fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import by.fpmi.pasevinapolina.materialremindme.R;

public class FragmentOne extends Fragment {

    private RadioGroup radioGroupGender;

    boolean answer = false;

    boolean correctAnswer = true;

    public FragmentOne() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_one, container, false);
        radioGroupGender = (RadioGroup) rootView.findViewById(R.id.radioGroupGender);
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case -1:
                        //Toast.makeText(getContext(), "No choice", Toast.LENGTH_SHORT).show();
                        answer = false;
                        break;
                    case R.id.radioButtonTrue:
                        //Toast.makeText(getContext(), "Male", Toast.LENGTH_SHORT).show();
                        answer = true;
                        break;
                    case R.id.radioButtonFalse:
                        // Toast.makeText(getContext(), "Female", Toast.LENGTH_SHORT).show();
                        answer = false;
                        break;
                    default:
                        break;
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.check_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res;
                if (correctAnswer == answer) {
                    res = "Correct";
                }
                else {
                    res = "Incorrect";
                }
                Snackbar.make(view, "Result: " + res, Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        return rootView;
    }
}
