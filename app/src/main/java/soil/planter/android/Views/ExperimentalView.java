package soil.planter.android.Views;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.ParcelUuid;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuBuilder;

import com.makeramen.roundedimageview.RoundedImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

import soil.planter.android.R;
import soil.planter.android.Tools.BluetoothManager;

public class ExperimentalView extends FrameLayout implements BluetoothManager.BlueToothListener {
    private Button findDeviceBtn;
    private Button startBlueToothBtn;

    private Button endBlueToothBtn;
    LinearLayout deviceContainer;
    private RoundedImageView roundedImageViewBtONOFF;


    private static final int REQUEST_ENABLE_BT = 7;
    //private ArrayList<BTDevice> devices;

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
  //     findDeviceBtn = findViewById(R.id.btn_find_devices_ex);
  //     roundedImageViewBtONOFF = findViewById(R.id.image_bt_on_off);
  //     endBlueToothBtn = findViewById(R.id.btn_end_blue);
  //     deviceContainer = findViewById(R.id.device_container_ex);

  //     BluetoothManager bluetoothManager = BluetoothManager.getInstance();

  //     startBlueToothBtn = findViewById(R.id.btn_start_blue);

  //     startBlueToothBtn.setOnClickListener(new OnClickListener() {
  //         @Override
  //         public void onClick(View view) {
  //             bluetoothManager.startBluetooth();
  //         }
  //     });
  //     endBlueToothBtn.setOnClickListener(new OnClickListener() {
  //         @Override
  //         public void onClick(View view) {
  //             bluetoothManager.endBluetooth();

  //         }
  //     });

  //     findDeviceBtn.setOnClickListener(new OnClickListener() {
  //         @Override
  //         public void onClick(View view) {
  //             bluetoothManager.discovery(new BluetoothManager.Discovery() {
  //                 @Override
  //                 public void addDevice(BTDevice device) {
  //                     if (!devices.stream().anyMatch(btDevice -> btDevice.getAdress().equals(device.getAdress())))
  //                         devices.add(device);
  //                     updateListDevicesView();
  //                 }
  //             });
  //             new Handler().postDelayed(new Runnable() {
  //                 @Override
  //                 public void run() {
  //                     bluetoothManager.endDiscovery();

  //                 }
  //             },12000);

  //         }
  //     });
  //     bluetoothManager.listenBT(this);


    }

    private void updateListDevicesView() {
        deviceContainer.removeAllViews();
     //   for (BTDevice btDevice : devices){
     //       TextView view = new TextView(getContext());
//
     //       view.setText(btDevice.getName());
     //       deviceContainer.addView(view);
     //   }
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


