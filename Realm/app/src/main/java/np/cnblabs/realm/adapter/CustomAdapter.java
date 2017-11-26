package np.cnblabs.realm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import np.cnblabs.realm.R;
import np.cnblabs.realm.realm.DetailData;

/**
 * Created by sanjogstha on 11/26/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private List<DetailData> detailDataList;
    onClickListener onClickListener;

    public CustomAdapter(Context context, List<DetailData> detailDataList) {
        this.detailDataList = detailDataList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final DetailData detailData = detailDataList.get(position);
        holder.email.setText(detailData.getEmail());
        holder.name.setText(detailData.getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onItemClick(detailData.getName());
            }
        });

        holder.email.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onClickListener.onItemLongClick(detailData.getEmail());
                return false;
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, email;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTV);
            email = itemView.findViewById(R.id.emailTV);
        }
    }
    @Override
    public int getItemCount() {
        return detailDataList.size();
    }

    public void setOnClick(onClickListener click){
        this.onClickListener = click;
    }

    public interface onClickListener{
        void onItemLongClick(String email);
        void onItemClick(String name);
    }
}
