package br.com.concrete.androidanimationspart1.fragment.property;


import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;

import br.com.concrete.androidanimationspart1.R;
import br.com.concrete.androidanimationspart1.fragment.AnimationFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ObjectFloatFragment extends Fragment implements AnimationFragment {

    View view;
    boolean plus;

    public static ObjectFloatFragment newInstance() {
        return new ObjectFloatFragment();
    }

    public ObjectFloatFragment() {
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
        Keyframe keyframe1 = Keyframe.ofFloat(0f, view.getY());
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f, view.getY() - 90);
        Keyframe keyframe3 = Keyframe.ofFloat(1f, view.getY());
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder
                .ofKeyframe("Y", keyframe1, keyframe2, keyframe3);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolder);
        animator.setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

}
