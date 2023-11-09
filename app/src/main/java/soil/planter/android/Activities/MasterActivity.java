package soil.planter.android.Activities;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import soil.planter.android.Adapter.ViewPagerExperimental;
import soil.planter.android.R;
import soil.planter.android.Fragments.SplashScreen;
import soil.planter.android.Tools.BluetoothManager;
import soil.planter.android.Views.ExperimentalView;
import soil.planter.android.Views.TopBar;

public class MasterActivity extends AppCompatActivity {
    private FrameLayout container;
    private ViewPager2 viewPager;
    private BluetoothManager bluetoothManager;
    private TopBar topBar;
    private static final String TAG = "MasterActivity";
    private FragmentManager fragmentManager;

    @Override
    protected void onStart() {
        super.onStart();
        bluetoothManager = new BluetoothManager(this);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        fragmentManager = getSupportFragmentManager();

        viewPager.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(viewPager);
        viewPager.setAdapter(new ViewPagerExperimental(new ViewPagerExperimental.Splash() {
            @Override
            public void display() {
                fragmentManager.beginTransaction().replace(R.id.master_container, new SplashScreen()).commit();
            }
        }));
    }
    private void initViews() {
        container = findViewById(R.id.master_container);
        topBar = findViewById(R.id.topbar);
        viewPager = new ViewPager2(this);

    }

}
