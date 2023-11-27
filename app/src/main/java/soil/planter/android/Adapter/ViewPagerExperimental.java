package soil.planter.android.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import soil.planter.android.Fragments.SplashScreen;
import soil.planter.android.R;
import soil.planter.android.Views.ExperimentalView;

public class ViewPagerExperimental extends RecyclerView.Adapter {

    public ViewPagerExperimental() {
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
    public FrameLayout container;
    private View view;
    public ViewHolder1(View view) {
        super(view);
        this.view = view;
        container = view.findViewById(R.id.master_container);
    }
}
class ViewHolderExperimental extends RecyclerView.ViewHolder {
    public ViewHolderExperimental(View view) {
        super(view);
    }
}
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            SplashScreen view = new SplashScreen(parent.getContext());
            view.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            return new ViewHolder1(view);
        } else if (viewType == 1) {
            View view = new ExperimentalView(parent.getContext());
            view.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return new ViewHolderExperimental(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {

        } else if (position == 1) {
        }
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}


