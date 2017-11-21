package np.cnblabs.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import np.cnblabs.recyclerview.R;
import np.cnblabs.recyclerview.model.Movie;

/**
 * Created by sanjogstha on 11/20/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<Movie> movieList;
    private Context context;

    OnClickListener listener;
    public CustomAdapter(Context context, List<Movie> movieList) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.category.setText(movie.getCategory());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, category, year;
        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTV);
            category = itemView.findViewById(R.id.categoryTV);
            year = itemView.findViewById(R.id.yearTV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(title);
                }
            });
        }
    }

    public void setOnClick(OnClickListener listener){
        this.listener = listener;
    }

    public interface OnClickListener{
        void onClick(View view);
    }
}
