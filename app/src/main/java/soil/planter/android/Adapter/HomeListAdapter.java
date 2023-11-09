package soil.planter.android.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import soil.planter.android.Post;
import soil.planter.android.R;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder> {
    private ArrayList<Post> posts = new ArrayList<Post>();

    private static final int TITLE = 1;
    private static final int PLANTERS = 2;
    private static final int PLANTS = 3;
    private static final int TITLE_POSTS = 4;
    private static final int POSTS = 5;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch(viewType){
            case TITLE:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.roundview,parent));
            case PLANTERS:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.planter_view,parent));
            case PLANTS:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view,parent));
            case TITLE_POSTS:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view,parent));
            default: POSTS:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view,parent));


        }
    }

    @Override
    public int getItemViewType(int position) {
        switch(position){
            case 0:
                return TITLE;
            case 1:
                return PLANTERS;
            case 2:
                return PLANTS;
            case 3:
                return TITLE_POSTS;
            default:
                return POSTS;


        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4+ posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
