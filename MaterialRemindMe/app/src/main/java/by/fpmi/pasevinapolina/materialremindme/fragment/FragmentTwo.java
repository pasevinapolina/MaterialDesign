package by.fpmi.pasevinapolina.materialremindme.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import by.fpmi.pasevinapolina.materialremindme.R;


public class FragmentTwo extends Fragment {

    SeekBar seekBar;
    TextView progressValue;

    int answerCorrect = 90;

    public FragmentTwo() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_two, container, false);
        seekBar = (SeekBar) rootView.findViewById(R.id.seekBar);
        progressValue = (TextView) rootView.findViewById(R.id.progressValue);
        seekBar.setMax(100);
        seekBar.setProgress(60);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int  mProgress = progress / 10 * 10;
                progressValue.setText(String.valueOf(mProgress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.check_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res;
                int answer = Integer.parseInt(progressValue.getText().toString());
                if (answerCorrect == answer) {
                    res = "Correct!";
                } else {
                    if (answerCorrect < answer)
                        res = "She was younger";
                    else
                        res = "She was older";
                }

                Snackbar.make(view, "Result: " + res, Snackbar.LENGTH_SHORT).setAction("Action", null).show();

            }
        });

        return rootView;
    }

}
