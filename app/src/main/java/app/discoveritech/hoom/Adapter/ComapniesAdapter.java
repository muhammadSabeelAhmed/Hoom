package app.discoveritech.hoom.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

import app.discoveritech.hoom.APIConfig.PostWebDataAPI;
import app.discoveritech.hoom.Fragments.ServicesFragment;
import app.discoveritech.hoom.GeneralClasses.Global;
import app.discoveritech.hoom.LocalDatabase.PreferencesHandler;
import app.discoveritech.hoom.Model.Companies;
import app.discoveritech.hoom.Presenter.ServicesPresenter;
import app.discoveritech.hoom.R;
import app.discoveritech.hoom.View.IServiceView;

public class ComapniesAdapter extends RecyclerView.Adapter<ComapniesAdapter.ViewHolder> implements IServiceView {
    private List<Companies> companiesList;
    ServicesPresenter servicesPresenter;
    PreferencesHandler preferencesHandler;
    Context context;

    public ComapniesAdapter(List<Companies> companies, Context context) {
        this.context = context;
        companiesList = companies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.companies_item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        servicesPresenter = new ServicesPresenter(this);
        preferencesHandler = new PreferencesHandler();
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.compName.setText(companiesList.get(position).getName());
        holder.compCost.setText(companiesList.get(position).getEstimated_price());
        holder.ratingBar.setRating(Float.parseFloat(companiesList.get(position).getId()));
        holder.company_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.mKProgressHUD.show();
                servicesPresenter.onGetServices(preferencesHandler.getBearerToken(), companiesList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return companiesList.size();
    }

    @Override
    public void onGetService(String message) {
        if (message.equals("Services Success")) {
            FancyToast.makeText(context, "Looking for Services", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
            openServices();
        } else {
            FancyToast.makeText(context, "" + message, FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
        }
    }

    private void openServices() {
        Global.changeMainFragment(context, new ServicesFragment(), "", "");
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView compName;
        TextView compCost;
        SimpleRatingBar ratingBar;
        CardView company_card;

        ViewHolder(View v) {
            super(v);
            company_card = v.findViewById(R.id.company_card);
            compName = v.findViewById(R.id.comp_name);
            compCost = v.findViewById(R.id.comp_estimatedCost);
            ratingBar = v.findViewById(R.id.ratingBar);
            ratingBar.setNumberOfStars(5);
            ratingBar.setStepSize(0.1f);
        }
    }
}
