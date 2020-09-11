package com.dev.banna.googleformapp.google_form;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.dev.banna.googleformapp.R;
import com.dev.banna.googleformapp.base.BaseActivity;
import com.dev.banna.googleformapp.network.ApiClient;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoogleFormActivity extends BaseActivity {

    private static final String TAG = "GoogleFormActivity";

    @BindView(R.id.etFirstName)
    TextInputEditText etFirstName;
    @BindView(R.id.etLastName)
    TextInputEditText etLastName;
    @BindView(R.id.etEmailAdress)
    TextInputEditText etEmailAdress;
    @BindView(R.id.etGithubProjectLink)
    TextInputEditText etGithubProjectLink;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, GoogleFormActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_form);
        ButterKnife.bind(this);

        setUp();

    }

    @Override
    protected void setUp() {

    }

    @OnClick({R.id.iv_back, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_submit:
                showDialog();
                break;
        }
    }

    public void showDialog() {

        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .customView(R.layout.dialog_submit, true)
                .cancelable(true).build();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//        ImageView ivDialogIcon = (ImageView) dialog.findViewById(R.id.iv_dialog_icon);
        TextView tvDialogTitle = (TextView) dialog.findViewById(R.id.tv_dialog_title);
//        TextView tvDialogMessage = (TextView) dialog.findViewById(R.id.tv_message);
        MaterialButton btnSubmit = (MaterialButton) dialog.findViewById(R.id.btn_ok);

        //Todo Set Dialog Icon and Title and Message
        tvDialogTitle.setText(R.string.r_u_sure);
//        tvDialogMessage.setText();


        btnSubmit.setOnClickListener(view1 -> {

            submitGoogleFormApiCall();

            dialog.dismiss();

        });


        dialog.show();

    }

    private void submitGoogleFormApiCall() {
        String email = etEmailAdress.getText().toString().trim(),
                firstName = etFirstName.getText().toString().trim(),
                lastName = etLastName.getText().toString().trim(),
                githubLink = etGithubProjectLink.getText().toString().trim();

        if (firstName.isEmpty()) {
            showMessage("please enter First Name ");
            return;
        }
        if (lastName.isEmpty()) {
            showMessage("please enter Last Name ");
            return;
        }
        if (email.isEmpty()) {
            showMessage("please enter Email ");
            return;
        }
        if (githubLink.isEmpty()) {
            showMessage("please enter Github Link ");
            return;
        }

        ApiClient.getInstance().submitGoogleFormApiCall(email,
                firstName,
                lastName,
                githubLink
        ).enqueue(new Callback<ResponseBody>() {


            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }


}