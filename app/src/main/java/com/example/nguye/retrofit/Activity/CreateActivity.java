package com.example.nguye.retrofit.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nguye.retrofit.Connect.ApiUtils;
import com.example.nguye.retrofit.Connect.ReService;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.Presenter.MainPresenter;
import com.example.nguye.retrofit.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nguye on 28/05/2018.
 */

public class CreateActivity extends AppCompatActivity implements View.OnClickListener , MainView{
    private EditText mEdtEmailCr;
    private EditText mEdtPassCr;
    private EditText mEdtName;
    private Button mBtCreate;
    private Intent intentCreate;
    private MainPresenter mainPresenter;
    private String emailCr;
    private String passCr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        intentCreate = getIntent();
        mainPresenter = new MainPresenter(this, this);
        initView();
    }

    private void initView() {
        mEdtEmailCr = findViewById(R.id.mEdtEmailCreate);
        mEdtPassCr = findViewById(R.id.mEdtPassCreate);
        mEdtName = findViewById(R.id.mEdtNameCreate);
        mBtCreate = findViewById(R.id.mBtCreate);

        mBtCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        emailCr = mEdtEmailCr.getText().toString();
        passCr = mEdtPassCr.getText().toString();
        String name = mEdtName.getText().toString();
        mainPresenter.loadRegist(emailCr, passCr, name);
    }

    @Override
    public void dataMain(List<Datum> listData) {

    }

    @Override
    public void dataLogin(ReData reData) {
        if (reData.getSuccess()){
            intentCreate.putExtra("emailCr", emailCr);
            intentCreate.putExtra("passCr", passCr);
            setResult(RESULT_OK, intentCreate);
            finish();
        }

    }
}
