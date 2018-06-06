package com.example.nguye.retrofit.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nguye.retrofit.Activity.ViewInterface.CreateView;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.Presenter.CreatePresenter;
import com.example.nguye.retrofit.R;

/**
 * Created by nguye on 28/05/2018.
 */

public class CreateActivity extends AppCompatActivity implements View.OnClickListener , CreateView {
    private EditText mEdtEmailCr;
    private EditText mEdtPassCr;
    private EditText mEdtName;
    private Button mBtCreate;
    private Intent intentCreate;
    private CreatePresenter createPresenter;
    private String emailCr;
    private String passCr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        intentCreate = getIntent();
        createPresenter = new CreatePresenter(this);
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
        createPresenter.loadRegist(emailCr, passCr, name);
    }

    @Override
    public void regist(ReData reData) {
        if (reData.getSuccess()){
            intentCreate.putExtra("emailCr", emailCr);
            intentCreate.putExtra("passCr", passCr);
            setResult(RESULT_OK, intentCreate);
            finish();
        }
    }
}
