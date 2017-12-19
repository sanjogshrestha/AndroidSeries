package np.cnblabs.listview.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import np.cnblabs.listview.R;

/**
 * Created by sanjogstha on 11/19/17.
 * Innovisto LLC
 * sanjogshrestha.nepal@gmail.com
 */

public class CustomAdapter extends ArrayAdapter<String> {
    private String[] values;
    private Context context;
    private int[] drawables;
    private ViewHolder holder;

    CustomAdapter(@NonNull Context context, String[] values, int[] drawables) {
        super(context, R.layout.custom_view,values);
        this.context = context;
        this.values = values;
        this.drawables = drawables;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater != null) {
            convertView = layoutInflater.inflate(R.layout.custom_view, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.title);
            holder.textView.setText(values[position]);
            Drawable image = ContextCompat.getDrawable(context, drawables[position]);
            image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
            holder.textView.setCompoundDrawables(image, null, null, null);
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public String getItem(int position) {
        return values[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public  class ViewHolder {
        TextView textView;
    }
}
