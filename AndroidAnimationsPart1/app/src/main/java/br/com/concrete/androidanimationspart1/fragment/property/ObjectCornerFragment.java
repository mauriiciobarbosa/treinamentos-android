package br.com.concrete.androidanimationspart1.fragment.property;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.com.concrete.androidanimationspart1.R;
import br.com.concrete.androidanimationspart1.fragment.AnimationFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ObjectCornerFragment extends Fragment implements AnimationFragment {

    View view;

    public static ObjectCornerFragment newInstance() {
        return new ObjectCornerFragment();
    }

    public ObjectCornerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_base, container, false);
        view = layout.findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "run", Toast.LENGTH_SHORT).show();
            }
        });
        return layout;
    }

    @Override
    public void runAnimation() {
        view.animate().translationXBy(45f).start();
    }
}
