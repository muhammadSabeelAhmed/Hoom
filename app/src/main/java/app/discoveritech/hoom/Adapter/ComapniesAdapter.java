package app.discoveritech.hoom.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import app.discoveritech.hoom.Model.Companies;
import app.discoveritech.hoom.R;

public class ComapniesAdapter extends RecyclerView.Adapter<ComapniesAdapter.ViewHolder> {
    private List<Companies> companiesList;

    public ComapniesAdapter(List<Companies> companies) {
        companiesList = companies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.companies_item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.compName.setText(companiesList.get(position).getName());
        holder.compCost.setText(companiesList.get(position).getEstimated_price());
        holder.ratingBar.setRating(Float.parseFloat(companiesList.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return companiesList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView compName;
        TextView compCost;
        RatingBar ratingBar;

        ViewHolder(View v) {
            super(v);
            compName = v.findViewById(R.id.comp_name);
            compCost = v.findViewById(R.id.comp_estimatedCost);
            ratingBar = v.findViewById(R.id.ratingBar);
            ratingBar.setNumStars(5);
            ratingBar.setStepSize(0.1f);
            ratingBar.setIsIndicator(true);

        }
    }
}
