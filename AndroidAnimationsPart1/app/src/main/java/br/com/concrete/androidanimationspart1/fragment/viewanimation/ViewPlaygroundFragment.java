package br.com.concrete.androidanimationspart1.fragment.viewanimation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import br.com.concrete.androidanimationspart1.R;
import br.com.concrete.androidanimationspart1.fragment.AnimationFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPlaygroundFragment extends Fragment implements AnimationFragment {

    View view;

    public static ViewPlaygroundFragment newInstance() {
        return new ViewPlaygroundFragment();
    }

    public ViewPlaygroundFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_base, container, false);
        view = layout.findViewById(R.id.view);
        return layout;
    }

    @Override
    public void runAnimation() {
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.view_animation);
        view.startAnimation(animation);
    }
}
