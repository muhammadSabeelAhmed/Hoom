package app.discoveritech.hoom.APIConfig;

import android.content.Context;
import android.util.Log;

import java.util.List;

import app.discoveritech.hoom.GeneralClasses.Global;
import app.discoveritech.hoom.LocalDatabase.PreferencesHandler;
import app.discoveritech.hoom.Model.Companies;
import app.discoveritech.hoom.Model.Town;
import app.discoveritech.hoom.Model.User;
import app.discoveritech.hoom.View.ICompaniesView;
import app.discoveritech.hoom.View.ILoginView;
import app.discoveritech.hoom.View.ISignupView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostWebDataAPI {
    APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
    ILoginView loginView;
    ICompaniesView iCompaniesView;
    ISignupView signupView;
    PreferencesHandler preferencesHandler;
    String API = "POSTWEBDATAAPI";
    Context context;

    public PostWebDataAPI() {
    }

    public PostWebDataAPI(ILoginView loginView) {
        preferencesHandler = new PreferencesHandler();
        this.loginView = loginView;
    }

    public PostWebDataAPI(ICompaniesView companiesView) {
        preferencesHandler = new PreferencesHandler();
        this.iCompaniesView = companiesView;
    }

    public PostWebDataAPI(ISignupView signupView) {
        preferencesHandler = new PreferencesHandler();
        this.signupView = signupView;
    }

    public PostWebDataAPI(Context context) {
        this.context = context;
    }

    public void PostSigninData(String email, String password) {
        Call<User> call = apiInterface.signInUser(email, password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user.getMessage().equals("success")) {
                        String token = user.getToken();
                        Log.d(API, "login token:" + token);
                        preferencesHandler.setBearerToken(token);
                        loginView.onLogin("Login Success");
                    } else {
                        loginView.onLogin("" + user.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loginView.onLogin(t.getMessage());
                Log.d("MyResponse", "Failure");

            }
        });
    }

    public void PostSignUpData(String name, String password, String email, String town_id, String address, String postal_code, String street) {
        Call<User> call = apiInterface.signUpUser("" + name, "" + password, "3", "" + email, "" + town_id, "" + address, "" + postal_code, "" + street);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    if (user.getToken() != null && !user.getToken().isEmpty()) {
                        preferencesHandler.setBearerToken(user.getToken());
                        signupView.onSignup("Signup Success");
                    } else {
                        signupView.onSignup("" + user.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loginView.onLogin(t.getMessage());
                Log.d("MyResponse", "Failure");

            }
        });
    }

    public void GetAllTowns() {
        Call<List<Town>> call = apiInterface.getTowns();
        call.enqueue(new Callback<List<Town>>() {
            @Override
            public void onResponse(Call<List<Town>> call, Response<List<Town>> response) {
                if (response.isSuccessful()) {
                    Global.townsList.clear();
                    List<Town> towns = response.body();
                    Global.townsList.addAll(towns);
                }
            }

            @Override
            public void onFailure(Call<List<Town>> call, Throwable t) {
                Log.d("MyResponse", "Failure");

            }
        });
    }


    public void getCompanies(String token, String service_id) {
        Call<List<Companies>> call = apiInterface.getCompanies("Bearer " + token, service_id);
        call.enqueue(new Callback<List<Companies>>() {
            @Override
            public void onResponse(Call<List<Companies>> call, Response<List<Companies>> response) {
                if (response.isSuccessful()) {
                    Global.companiesList.clear();
                    List<Companies> companies = response.body();
                    Global.companiesList.addAll(companies);
                    iCompaniesView.onComapnies("Companies Success");
                }
            }

            @Override
            public void onFailure(Call<List<Companies>> call, Throwable t) {
                iCompaniesView.onComapnies(t.getMessage());
                Log.d("MyResponse", "Failure");

            }
        });
    }
}
