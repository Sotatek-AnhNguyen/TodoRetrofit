package com.example.nguye.retrofit.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.Presenter.MainPresenter;
import com.example.nguye.retrofit.R;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by nguye on 28/05/2018.
 */

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener, MainView {
    private EditText mEdttitle;
    private Button mBtUpdate;
    private MainPresenter mainPresenter;
    private String title;
    private String acToken;
    private Intent intenUpdate;
    private Datum datum;
    private int pos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        intenUpdate = getIntent();
        mainPresenter = new MainPresenter(this,  this);
        acToken = intenUpdate.getStringExtra("tok");
        datum = (Datum) intenUpdate.getSerializableExtra("dat");
        pos = intenUpdate.getIntExtra("position", 1);
        initView();
    }

    private void initView() {
        mEdttitle = findViewById(R.id.mEdtUpdate);
        mBtUpdate = findViewById(R.id.mBtUpdate);
        mEdttitle.setText(datum.getTitle());
        mBtUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        title = mEdttitle.getText().toString();
        mainPresenter.loadUpdate(datum.getId(), title, acToken);
        datum.setTitle(title);
        intenUpdate.putExtra("reData", datum);
        intenUpdate.putExtra("position", pos);
        setResult(RESULT_OK, intenUpdate);
        finish();
    }

    @Override
    public void dataMain(List<Datum> listData) {

    }

    @Override
    public void dataLogin(ReData reData) {
        Datum datumRe = new Gson().fromJson(reData.getData(), Datum.class);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuupdate, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnUpdate:
                mainPresenter.deleteATodo(datum.getId(), acToken);
                intenUpdate.putExtra("position", pos);
                setResult(RESULT_CANCELED, intenUpdate);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
