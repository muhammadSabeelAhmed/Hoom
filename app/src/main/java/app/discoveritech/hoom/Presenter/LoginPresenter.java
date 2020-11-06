package app.discoveritech.hoom.Presenter;

import app.discoveritech.hoom.APIConfig.PostWebDataAPI;
import app.discoveritech.hoom.Model.User;
import app.discoveritech.hoom.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    ILoginView LoginView;
    PostWebDataAPI postWebDataAPI;

    public LoginPresenter(ILoginView LoginView) {
        postWebDataAPI = new PostWebDataAPI(LoginView);
        this.LoginView = LoginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        boolean checkLogin = user.validateSignin();
        if (checkLogin) {
            postWebDataAPI.PostSigninData("" + email, "" + password);
        } else {
            LoginView.onLogin("All Fields Required");
        }
    }
}
