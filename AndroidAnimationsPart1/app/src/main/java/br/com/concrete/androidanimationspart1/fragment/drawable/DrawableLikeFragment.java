package br.com.concrete.androidanimationspart1.fragment.drawable;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.concrete.androidanimationspart1.R;
import br.com.concrete.androidanimationspart1.fragment.AnimationFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawableLikeFragment extends Fragment implements AnimationFragment {

    View view;
    AnimationDrawable animation;
    boolean isFully;

    public static DrawableLikeFragment newInstance() {
        return new DrawableLikeFragment();
    }

    public DrawableLikeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_base, container, false);
        view = layout.findViewById(R.id.view);
        view.setBackgroundResource(R.drawable.like_animation);
        animation = (AnimationDrawable) view.getBackground();
        return layout;
    }

    @Override
    public void runAnimation() {

        if (animation.isRunning()) return;

        animation.start();

        isFully = !isFully;
        final int res = isFully ? R.drawable.dislike_animation : R.drawable.like_animation;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.setBackgroundResource(res);
                animation = (AnimationDrawable) view.getBackground();
            }
        }, 700L);


    }
}
