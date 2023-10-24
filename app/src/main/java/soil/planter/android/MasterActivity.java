package soil.planter.android;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import soil.planter.android.Views.TopBar;

public class MasterActivity extends AppCompatActivity implements Pagination{
    private FrameLayout container;
    private TopBar topBar;
    private static final String TAG = "MasterActivity";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_activity);
        fragmentManager = getSupportFragmentManager();

        container = findViewById(R.id.master_container);
        topBar = findViewById(R.id.topbar);
        new Paginator().initPagination(this);
        switchPage(new SplashScreen());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG, "run: 123" );
                switchPage(new HomeScreen());


            }
        },1500);

    }

    @Override
    public void switchPage(Fragment fragment) {
        fragmentManager.beginTransaction().replace(container.getId(),fragment).commit();


    }
}
