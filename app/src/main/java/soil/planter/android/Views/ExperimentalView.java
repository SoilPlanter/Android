package soil.planter.android.Views;


import android.Manifest;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

import soil.planter.android.R;
import soil.planter.android.Tools.BTConnectThread;
import soil.planter.android.Tools.BluetoothManager;

public class ExperimentalView extends FrameLayout implements BluetoothManager.BlueToothListener {
    private static final String TAG = "ExperimentalView";
    private Button findDeviceBtn;
    private Button startBlueToothBtn;

    private Button endBlueToothBtn;
    private Button btnSendCommand;
    private EditText editText;
    private BluetoothManager bluetoothManager;
    LinearLayout deviceContainer;
    private RoundedImageView roundedImageViewBtONOFF;


    private static final int REQUEST_ENABLE_BT = 7;
    private ArrayList<BluetoothDevice> devices = new ArrayList<>();
    private Handler handler = new Handler();

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
        btnSendCommand = findViewById(R.id.btn_send_command_ex);
        editText = findViewById(R.id.edit_ex_command);

        btnSendCommand.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                bluetoothManager.sendCommand(editText.getText().toString());
                editText.setText("");


            }
        });
        deviceContainer = findViewById(R.id.device_container_ex);

        bluetoothManager = BluetoothManager.getInstance();

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
                handler.removeCallbacksAndMessages(null);
                bluetoothManager.endDiscovery();
                deviceContainer.removeAllViews();
                devices.clear();
                bluetoothManager.discovery(new BluetoothManager.Discovery() {
                    @Override
                    public void addDevice(BluetoothDevice device) {
                        if (!devices.stream().anyMatch(btDevice -> btDevice.getAddress().equals(device.getAddress())))
                            devices.add(device);
                        updateListDevicesView();
                    }
                });
                handler =new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluetoothManager.endDiscovery();

                    }
                }, 2200);

            }
        });
        bluetoothManager.listenBT(this);


    }

    private void updateListDevicesView() {
        deviceContainer.removeAllViews();
        for (BluetoothDevice btDevice : devices) {
            if (btDevice == null)
                continue;
            TextView view = new TextView(getContext());
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    bluetoothManager.connect(new BTConnectThread.BTConnection() {
                        @Override
                        public void connected(boolean isConnected) {
                            Toast.makeText(getContext(), "Connected: " + isConnected, Toast.LENGTH_SHORT).show();
                        }
                    }, btDevice);


                }
            });
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            if (btDevice.getName() != null && !btDevice.getName().equals(""))
                view.setText(btDevice.getName());
            else
                view.setText(btDevice.getAddress());

            deviceContainer.setOrientation(LinearLayout.VERTICAL);
            view.setLayoutParams(new ViewGroup.LayoutParams(200,200));
            deviceContainer.addView(view);
        }
    }

    private void granted() {

        queryKnownDevices();

    }

    private void queryKnownDevices() {

    }

    @Override
    public void listen(boolean isOn) {
        if (isOn)
            roundedImageViewBtONOFF.setBackground(new ColorDrawable(Color.parseColor("#7CFC00")));
        else
            roundedImageViewBtONOFF.setBackground(new ColorDrawable(Color.parseColor("#ff0000")));
    }
}


