package soil.planter.android.Views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

import soil.planter.android.R;

public class ImageButton extends RoundView {

    public ImageButton(@NonNull Context context) {
        super(context);
        initData();
    }

    public ImageButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();

    }

    public ImageButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();

    }

    public ImageButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initData();

    }

    private void initData() {
        imageView.setVisibility(VISIBLE);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Glide.with(imageView).load("https://images.unsplash.com/photo-1697588833877-48ef048c50ef?auto=format&fit=crop&q=80&w=2200&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D").centerCrop().into(imageView);
        parent.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.green_prime)));
    }
}
