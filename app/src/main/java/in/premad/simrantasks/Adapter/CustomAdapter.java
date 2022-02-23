package in.premad.simrantasks.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.premad.simrantasks.R;
import in.premad.simrantasks.Utils.Name;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<Name> mNames;

    public CustomAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.layout_list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (mNames != null) {
            Name name = mNames.get(position);
            holder.nameView.setText(name.getName());
        } else {
            holder.nameView.setText("No name");
        }
    }

    public void setNames(List<Name> names) {
        mNames = names;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mNames != null) {
            return mNames.size();
        } else {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.name_view);
        }
    }
}

