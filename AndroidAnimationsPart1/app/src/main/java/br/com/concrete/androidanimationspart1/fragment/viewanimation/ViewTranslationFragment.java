package br.com.concrete.androidanimationspart1.fragment.viewanimation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.concrete.androidanimationspart1.R;
import br.com.concrete.androidanimationspart1.fragment.AnimationFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewTranslationFragment extends Fragment implements AnimationFragment {

    View view;
    boolean plus;

    public static ViewTranslationFragment newInstance() {
        return new ViewTranslationFragment();
    }

    public ViewTranslationFragment() {
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
        view.animate()
                .translationY(getNewValue())
                .setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(1000)
                .start();
    }

    private float getNewValue() {
        plus = !plus;
        return plus ? 45 : -45;
    }
}
