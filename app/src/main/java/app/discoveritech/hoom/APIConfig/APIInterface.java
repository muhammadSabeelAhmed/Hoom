package app.discoveritech.hoom.APIConfig;

import java.util.List;

import app.discoveritech.hoom.Model.Companies;
import app.discoveritech.hoom.Model.Services;
import app.discoveritech.hoom.Model.Town;
import app.discoveritech.hoom.Model.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInterface {

    @FormUrlEncoded
    @POST("login")
    Call<User> signInUser(@Field("email") String email,
                          @Field("password") String password);

    @FormUrlEncoded
    @POST("customer/create")
    Call<User> signUpUser(@Field("name") String name,
                          @Field("password") String password,
                          @Field("role_id") String role_id,
                          @Field("email") String email,
                          @Field("town_id") String town_id,
                          @Field("address") String address,
                          @Field("postcode") String postcode,
                          @Field("street") String street);

    @GET("town")
    Call<List<Town>> getTownsWithAuth(@Header("Authorization") String Bearer);

    @GET("towns")
    Call<List<Town>> getTowns();

    @FormUrlEncoded
    @POST("companies")
    Call<List<Companies>> getCompanies(@Header("Authorization") String Bearer,
                                       @Field("service_id") String service_id);

    @FormUrlEncoded
    @POST("get-service")
    Call<List<Services>> getServices(@Header("Authorization") String Bearer,
                                     @Field("company_id") String company_id);

}
