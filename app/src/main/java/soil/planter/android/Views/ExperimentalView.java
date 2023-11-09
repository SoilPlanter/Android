package soil.planter.android.Views;


import android.content.Context;
import android.content.pm.PackageManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.Manifest;
import android.widget.Button;
import android.widget.FrameLayout;


import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.util.Set;

import soil.planter.android.R;

public class ExperimentalView extends FrameLayout {
    private Button findDeviceBtn;


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
        findDeviceBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                granted();
            }
        });


    }

    private void granted() {

        queryKnownDevices();

    }

    private void queryKnownDevices() {

    }
}
