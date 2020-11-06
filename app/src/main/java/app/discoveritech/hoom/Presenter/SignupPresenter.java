package app.discoveritech.hoom.Presenter;

import app.discoveritech.hoom.APIConfig.PostWebDataAPI;
import app.discoveritech.hoom.Model.User;
import app.discoveritech.hoom.View.ISignupView;

public class SignupPresenter implements ISignupPresenter {
    ISignupView signupView;
    PostWebDataAPI postWebDataAPI;

    public SignupPresenter(ISignupView signupView) {
        postWebDataAPI = new PostWebDataAPI(signupView);
        this.signupView = signupView;
    }

    @Override
    public void onSignup(String name, String password, String email, String town_id, String address, String postcode) {
        User user = new User("" + name, "" + password, "" + email, "" + town_id, "" + address, "" + postcode);
        boolean checkSignup = user.validateSignup();
        if (checkSignup) {
            postWebDataAPI.PostSignUpData("" + name, "" + password, "" + email, "" + town_id, "" + address, "" + postcode);
        } else {
            signupView.onSignup("All Fields Required");
        }
    }
}
