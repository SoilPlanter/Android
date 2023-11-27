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
    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // Permission is granted. Continue the action or workflow in your
                    // app.
                } else {
                    // Explain to the user that the feature is unavailable because the
                    // feature requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                }
            });
    @Override
    protected void onStart() {
        super.onStart();
        bluetoothManager = BluetoothManager.getInstance();
        bluetoothManager.setActivity(this);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPermsissions();
        initViews();
        fragmentManager = getSupportFragmentManager();

        viewPager.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setContentView(viewPager);
        viewPager.setAdapter(new ViewPagerExperimental());
    }

    private void getPermsissions() {
        requestPermissionLauncher.launch(
                Manifest.permission.BLUETOOTH_SCAN);
        requestPermissionLauncher.launch(
                Manifest.permission.BLUETOOTH_CONNECT);
        requestPermissionLauncher.launch(
                Manifest.permission.ACCESS_COARSE_LOCATION);
        requestPermissionLauncher.launch(
                Manifest.permission.ACCESS_FINE_LOCATION);
        requestPermissionLauncher.launch(
                Manifest.permission.BLUETOOTH);
    }

    private void initViews() {
        container = findViewById(R.id.master_container);
        topBar = findViewById(R.id.topbar);
        viewPager = new ViewPager2(this);

    }

}
