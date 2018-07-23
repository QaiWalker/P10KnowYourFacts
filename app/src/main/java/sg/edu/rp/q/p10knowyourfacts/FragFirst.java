package sg.edu.rp.q.p10knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragFirst extends Fragment {

    Button btnChangeColour;


    public FragFirst() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View myFragmentView = inflater.inflate(R.layout.fragment_first, container, false);
        btnChangeColour = myFragmentView.findViewById(R.id.btnChangeColour);
        btnChangeColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomColour = new Random();
                myFragmentView.setBackgroundColor(Color.rgb(randomColour.nextInt(256), randomColour.nextInt(256), randomColour.nextInt(256)));
            }
        });
        return myFragmentView;

    }

}
