package br.com.concrete.androidanimationspart1.fragment.property;


import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import br.com.concrete.androidanimationspart1.R;
import br.com.concrete.androidanimationspart1.fragment.AnimationFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ValueTextFragment extends Fragment implements AnimationFragment {

    View view;
    private TextView text;
    private Spinner spinner;

    private static final Map<String, Interpolator> interpolatorMap;

    static {
        interpolatorMap = new HashMap<>();
        interpolatorMap.put("AccelerateDecelerateInterpolator", new AccelerateDecelerateInterpolator());
        interpolatorMap.put("BounceInterpolator", new BounceInterpolator());
        interpolatorMap.put("AccelerateInterpolator", new AccelerateInterpolator());
        interpolatorMap.put("FastOutSlowInInterpolator", new FastOutSlowInInterpolator());
        interpolatorMap.put("AnticipateOvershootInterpolator", new AnticipateOvershootInterpolator());
        interpolatorMap.put("FastOutLinearInInterpolator", new FastOutLinearInInterpolator());
        interpolatorMap.put("DecelerateInterpolator", new DecelerateInterpolator());
        interpolatorMap.put("LinearOutSlowInInterpolator", new LinearOutSlowInInterpolator());
    }

    public static ValueTextFragment newInstance() {
        return new ValueTextFragment();
    }

    public ValueTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_base_text, container, false);
        view = layout.findViewById(R.id.view);
        text = (TextView) layout.findViewById(R.id.text);
        spinner = (Spinner) layout.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_item,
                interpolatorMap.keySet().toArray(new String[0]));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return layout;
    }

    @Override
    public void runAnimation() {
        int oldValue = Integer.valueOf(text.getText().toString());
        ValueAnimator animator = ValueAnimator.ofInt(oldValue, getRandomNumber());
        animator.setInterpolator(interpolatorMap.get(spinner.getSelectedItem().toString()));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                text.setText(String.valueOf(valueAnimator.getAnimatedValue()));
            }
        });
        animator.setDuration(2000);
        animator.start();
    }

    private int getRandomNumber() {
        return new Random().nextInt(10000);
    }
}
