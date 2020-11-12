package app.discoveritech.hoom.GeneralClasses;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.ArrayList;

import app.discoveritech.hoom.Model.Companies;
import app.discoveritech.hoom.Model.Services;
import app.discoveritech.hoom.Model.Town;
import app.discoveritech.hoom.R;

public class Global {
    public static String device_back_tag = "";
    public static ArrayList<Town> townsList = new ArrayList<Town>();
    public static ArrayList<Companies> companiesList = new ArrayList<Companies>();
    public static ArrayList<Services> servicesList = new ArrayList<Services>();
    public static ArrayList<String> addressArray = new ArrayList<>();
    public static KProgressHUD mKProgressHUD;

    public static void changeFragment(Context context, Fragment fragment, String key, String value) {
        if (!key.isEmpty()) {
            Bundle i = new Bundle();
            i.putString(key, value);
            fragment.setArguments(i);
        }
        FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadein,
                R.anim.fadeout);
        transaction.replace(R.id.signup_frame, fragment);
        transaction.addToBackStack(device_back_tag);
        transaction.commit();
    }


    public static void changeMainFragment(Context context, Fragment fragment, String key, String value) {
        if (!key.isEmpty()) {
            Bundle i = new Bundle();
            i.putString(key, value);
            fragment.setArguments(i);
        }
        FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadein,
                R.anim.fadeout);
        transaction.replace(R.id.main_frame, fragment);
        transaction.addToBackStack(device_back_tag);
        transaction.commit();
    }

    public static void changeActivity(Context context, Activity activity) {
        Intent in = new Intent();
        in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        in.setClass(context, activity.getClass());
        context.startActivity(in);
    }
}
