package soil.planter.android;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import soil.planter.android.Views.RoundView;

public class AddButton extends RoundView implements Colorful{
    private boolean isBeingPressed = false;
    private boolean hasBeenPressed = false;
    private boolean backgroundOnClicked = false;

    public AddButton(@NonNull Context context) {
        super(context);
        initData();
    }

    public AddButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();

    }

    public AddButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();

    }

    public AddButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        ColorManager.initColorful(this);
        initData();

    }

    private void initData() {
        imageView.setVisibility(VISIBLE);
        parent.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(),R.color.green_prime)));
    }

    @Override
    public void theme(ColorTheme theme1) {


    }
}
