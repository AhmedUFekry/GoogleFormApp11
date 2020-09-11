package com.dev.banna.googleformapp.network;

import com.dev.banna.googleformapp.network.models.HoursResponse;
import com.dev.banna.googleformapp.network.models.SkillsResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";
    private static final String FORM_BASE_URL = "https://docs.google.com/forms/d/e/";
    

    private ApiService mService;
    private static ApiClient INSTANCE;

    public ApiClient() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = mRetrofit.create(ApiService.class);
    }

    public static ApiClient getInstance() {
        if (INSTANCE == null)
            INSTANCE = new ApiClient();
        return INSTANCE;
    }


    public Call<List<SkillsResponse>> getIQSkillsApiCall() {
        return mService.getIQSkillsApiCall();
    }

    public Call<List<HoursResponse>> getHoursApiCall() {
        return mService.getHoursApiCall();
    }

    public Call<ResponseBody> submitGoogleFormApiCall(String EmailAddress,
                                                      String Name,
                                                      String LastName,
                                                      String LinkToProject) {
        return mService.submitGoogleFormApiCall(EmailAddress, Name, LastName, LinkToProject);
    }
}
