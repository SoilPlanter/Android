package soil.planter.android.Views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import soil.planter.android.Tools.ColorManager;
import soil.planter.android.Tools.ColorTheme;
import soil.planter.android.Interfaces.Colorful;
import soil.planter.android.R;

public class AddButton extends RoundView implements Colorful {
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
        parent.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), R.color.green_prime)));
    }

    @Override
    public void theme(ColorTheme theme1) {



    }
}
