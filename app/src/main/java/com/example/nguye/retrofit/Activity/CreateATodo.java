package com.example.nguye.retrofit.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nguye.retrofit.Activity.ViewInterface.CreateATodoView;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Presenter.CreateATodoPresenter;
import com.example.nguye.retrofit.R;

/**
 * Created by nguye on 28/05/2018.
 */

public class CreateATodo extends AppCompatActivity implements View.OnClickListener, CreateATodoView {
    private EditText mEdtTitle;
    private Button mBtController;
    private Intent intentC;
    private CreateATodoPresenter createATodoPresenter;
    private String token;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        intentC = getIntent();
        createATodoPresenter = new CreateATodoPresenter(this);
        token = intentC.getStringExtra("auth");
        initView();
    }

    private void initView() {
        mEdtTitle = findViewById(R.id.mEdtUpdate);
        mBtController = findViewById(R.id.mBtUpdate);
        mBtController.setText("Create");
        mBtController.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String title = mEdtTitle.getText().toString();
        if (title.isEmpty()){
            Toast.makeText(getApplicationContext(), "Kiểm tra thông tin nhập", Toast.LENGTH_SHORT).show();
            return;
        }
        createATodoPresenter.loadCreateATodo(title, token);
    }

    @Override
    public void dataCreateATodo(Datum datum) {
        intentC.putExtra("data", datum);
        setResult(RESULT_OK, intentC);
        finish();
    }
}
