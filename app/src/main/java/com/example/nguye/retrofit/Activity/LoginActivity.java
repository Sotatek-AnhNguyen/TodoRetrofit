package com.example.nguye.retrofit.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nguye.retrofit.Model.DataLogin;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.Presenter.MainPresenter;
import com.example.nguye.retrofit.R;
import com.example.nguye.retrofit.Utils.MyShared;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by nguye on 28/05/2018.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, MainView {
    public static final int REQOK =1;
    private EditText mEdtEmailLogin;
    private EditText mEdtPassLogin;
    private Button mBtLogin;
    private TextView mTvCreate;
    private MainPresenter mainPresenter;
    private MyShared myShared;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mainPresenter = new MainPresenter(this, this);
        myShared = new MyShared(this);
        initView();
    }

    private void initView() {
        mEdtEmailLogin = findViewById(R.id.mEdtEmailLogin);
        mEdtPassLogin = findViewById(R.id.mEdtPassLogin);
        mBtLogin = findViewById(R.id.mBtLogin);
        mTvCreate = findViewById(R.id.mTvCreate);
        mEdtEmailLogin.setText(myShared.getData(MyShared.KEY_USER_NAME));
        mEdtPassLogin.setText(myShared.getData(MyShared.KEY_PASSWORD));
        mBtLogin.setOnClickListener(this);
        mTvCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mBtLogin:
                String email = mEdtEmailLogin.getText().toString();
                String pass = mEdtPassLogin.getText().toString();
                myShared.putData(MyShared.KEY_USER_NAME, email);
                myShared.putData(MyShared.KEY_PASSWORD, pass);
                mainPresenter.loadLogin(email, pass);
                break;
            case R.id.mTvCreate:
                Intent intenCr = new Intent(getApplicationContext(), CreateActivity.class);
                startActivityForResult(intenCr, REQOK);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQOK){
            if (resultCode == RESULT_OK){
                mEdtEmailLogin.setText(data.getStringExtra("emailCr"));
                mEdtPassLogin.setText(data.getStringExtra("passCr"));
            }
        }
    }

    @Override
    public void dataMain(List<Datum> listData) {

    }

    @Override
    public void dataLogin(ReData reData) {
        DataLogin dataLogin = new Gson().fromJson(reData.getData(), DataLogin.class);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("Token", dataLogin.getAccessToken());
        startActivity(intent);
    }
}
