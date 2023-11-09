package soil.planter.android.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import soil.planter.android.Interfaces.Pagination;
import soil.planter.android.R;

public class SplashScreen extends Fragment implements Pagination {
    private static final long MILLIS_SPLASH_TIME = 1000;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.splash_screen,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switchPage(new HomeScreen());

            }
        },MILLIS_SPLASH_TIME);
    }

    @Override
    public void switchPage(Fragment fragment) {
        getParentFragmentManager().beginTransaction().replace(R.id.master_container, new HomeScreen()).commit();

    }
}
