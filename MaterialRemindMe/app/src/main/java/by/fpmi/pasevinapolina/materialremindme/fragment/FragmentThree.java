package by.fpmi.pasevinapolina.materialremindme.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import by.fpmi.pasevinapolina.materialremindme.R;


public class FragmentThree extends Fragment {
    ImageView photoView;
    public FragmentThree() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        //photoView = (ImageView) view.findViewById(R.id.photoView);
        return view;
    }

    public ImageView getPhotoView() {
        return photoView;
    }
}
