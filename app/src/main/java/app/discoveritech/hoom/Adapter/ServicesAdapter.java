package app.discoveritech.hoom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.igenius.customcheckbox.CustomCheckBox;

import java.util.List;

import app.discoveritech.hoom.Model.Services;
import app.discoveritech.hoom.R;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {
    Context context;
    private List<Services> servicesList;

    public ServicesAdapter(List<Services> services, Context context) {
        this.context = context;
        servicesList = services;
    }

    @NonNull
    @Override
    public ServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.services_item_list, parent, false);
        ServicesAdapter.ViewHolder vh = new ServicesAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesAdapter.ViewHolder holder, int position) {
        holder.customCheckBox.setChecked(false);
        holder.serviceName.setText(servicesList.get(position).getService_detail());
        holder.serviceCost.setText(servicesList.get(position).getPrice());
        holder.service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.customCheckBox.isChecked()) {
                    holder.customCheckBox.setChecked(false);
                } else {
                    holder.customCheckBox.setChecked(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return servicesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout service;
        CustomCheckBox customCheckBox;
        TextView serviceName;
        TextView serviceCost;

        ViewHolder(View v) {
            super(v);
            customCheckBox = v.findViewById(R.id.service_checkbox);
            serviceName = v.findViewById(R.id.service_name);
            serviceCost = v.findViewById(R.id.service_cost);
            service = v.findViewById(R.id.service);
        }
    }
}
