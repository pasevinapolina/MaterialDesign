package by.fpmi.pasevinapolina.materialremindme.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.fpmi.pasevinapolina.materialremindme.R;

public class FragmentFour extends Fragment {
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
        return rootView;
    }


}
