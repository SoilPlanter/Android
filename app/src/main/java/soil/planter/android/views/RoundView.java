package soil.planter.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.makeramen.roundedimageview.RoundedImageView;

import soil.planter.android.R;

// todo rename roundedcornerview
public class RoundView extends FrameLayout {
    public RoundedImageView imageView;
    public FrameLayout parent;
    public RoundView(@NonNull Context context) {
        super(context);
        init();
    }

    public RoundView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public RoundView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public RoundView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();

    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.roundview,this);
        parent = findViewById(R.id.roundview_parent);
        imageView= findViewById(R.id.image);
    }
}
