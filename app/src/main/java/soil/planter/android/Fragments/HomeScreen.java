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

public class HomeScreen extends Fragment implements Pagination
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_screen,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        },1000);
    }

    @Override
    public void switchPage(Fragment fragment) {
        getParentFragmentManager().beginTransaction().replace(R.id.master_container, new HomeScreen()).commit();
    }
}
