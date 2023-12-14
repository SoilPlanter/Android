package soil.planter.android.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import soil.planter.android.Activities.MasterActivity;
import soil.planter.android.Interfaces.Pagination;
import soil.planter.android.R;

public class SplashScreen extends FrameLayout implements Pagination {
    private static final String TAG = "SplashScreen";
    private static final long MILLIS_SPLASH_TIME = 1000;

    public SplashScreen(Context context) {
        super(context);
        init();
    }

    public SplashScreen(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SplashScreen(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SplashScreen(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.master_activity, this);
        FrameLayout frameLayout = findViewById(R.id.master_container);
        View v = LayoutInflater.from(getContext()).inflate(R.layout.splash_screen,this);
        v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        frameLayout.removeAllViews();
        frameLayout.addView(v);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switchPage(new HomeScreen());

            }
        },MILLIS_SPLASH_TIME);


    }




    @Override
    public void switchPage(Fragment fragment) {
        ((MasterActivity)getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.master_container,new HomeScreen()).commit();

    }
}
