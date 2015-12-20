package by.fpmi.pasevinapolina.materialremindme.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import by.fpmi.pasevinapolina.materialremindme.R;

public class FragmentFive extends Fragment {
    EditText editText;

    public FragmentFive() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_five, container, false);
        editText = (EditText) rootView.findViewById(R.id.input_answer);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.check_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res;
                if (editText.getText().toString().toUpperCase().equals("ARKANSAS")) {
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
