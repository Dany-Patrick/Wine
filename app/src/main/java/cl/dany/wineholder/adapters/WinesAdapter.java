package cl.dany.wineholder.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.dany.wineholder.data.Queries;
import cl.dany.wineholder.models.Wine;
import cl.lauragc.wineholder.R;

public class WinesAdapter extends RecyclerView.Adapter<WinesAdapter.ViewHolder> {

    private List<Wine> wines = new Queries().wines();


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_wine, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Wine wine = wines.get(position);
        holder.nameTv.setText(wine.getName());
        holder.ageTv.setText(wine.getAge());
        holder.vineTv.setText(wine.getVine());


        holder.ageTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return wines.size();
    }


    public void update(Wine wine){
        wines.add(wine);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTv;
        private TextView ageTv;
        private TextView vineTv;


        public ViewHolder(View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTv);
            ageTv = itemView.findViewById(R.id.ageTv);
            vineTv = itemView.findViewById(R.id.vineTv);
        }
    }
}