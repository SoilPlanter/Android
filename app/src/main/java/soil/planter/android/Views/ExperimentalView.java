package soil.planter.android.Views;


import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.Manifest;
import android.widget.Button;
import android.widget.FrameLayout;


import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.Set;

import soil.planter.android.R;
import soil.planter.android.Tools.BluetoothManager;

public class ExperimentalView extends FrameLayout implements BluetoothManager.BT {
    private Button findDeviceBtn;
    private Button startBlueToothBtn;

    private Button endBlueToothBtn;
    private RoundedImageView roundedImageViewBtONOFF;


    private static final int REQUEST_ENABLE_BT = 7;

    public ExperimentalView(Context context) {
        super(context);
        init();
    }

    public ExperimentalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public ExperimentalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public ExperimentalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();

    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.experimental_view, this);
        findDeviceBtn = findViewById(R.id.btn_find_devices_ex);
        roundedImageViewBtONOFF = findViewById(R.id.image_bt_on_off);
        endBlueToothBtn = findViewById(R.id.btn_end_blue);
        BluetoothManager bluetoothManager = BluetoothManager.getInstance();

        startBlueToothBtn = findViewById(R.id.btn_start_blue);
        startBlueToothBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                bluetoothManager.startBluetooth();
            }
        });
        endBlueToothBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                bluetoothManager.endBluetooth();

            }
        });

        findDeviceBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                bluetoothManager.discovery();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluetoothManager.endDiscovery();

                    }
                },12000);

            }
        });
        bluetoothManager.listenBT(this);


    }

    private void granted() {

        queryKnownDevices();

    }

    private void queryKnownDevices() {

    }

    @Override
    public void listener(boolean isOn) {
        if (isOn)
            roundedImageViewBtONOFF.setBackground(new ColorDrawable(Color.parseColor("#7CFC00")));
        else
            roundedImageViewBtONOFF.setBackground(new ColorDrawable(Color.parseColor("#ff0000")));
    }
}
