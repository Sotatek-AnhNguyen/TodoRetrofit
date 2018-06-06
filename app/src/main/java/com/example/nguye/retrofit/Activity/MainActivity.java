package com.example.nguye.retrofit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.nguye.retrofit.Activity.ViewInterface.MainView;
import com.example.nguye.retrofit.Adapter.AdapterMain;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.Presenter.MainPresenter;
import com.example.nguye.retrofit.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    public static final int CODECREATE = 1;
    private AdapterMain adapterMain;
    private RecyclerView recyclerView;
    private ArrayList<Datum> arrData;
    private Intent intent;
    private MainPresenter mainPresenter;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = getIntent();
        mainPresenter = new MainPresenter(this);
        token = intent.getStringExtra("Token");
        mainPresenter.loadDataMain(token);
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.mRcvMain);
        arrData = new ArrayList<>();
        adapterMain = new AdapterMain(this, arrData, token);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterMain);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumain, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnCreate:
                Intent intencreate = new Intent(this, CreateATodo.class);
                intencreate.putExtra("auth", token);
                startActivityForResult(intencreate, CODECREATE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODECREATE){
            if (resultCode == RESULT_OK){
                arrData.add((Datum) data.getSerializableExtra("data"));
                adapterMain.notifyDataSetChanged();
            }
        }

        if (requestCode == AdapterMain.RECODEADAP){
            if (resultCode == RESULT_OK){
                arrData.set(data.getIntExtra("position", 1), (Datum) data.getSerializableExtra("reData"));
                adapterMain.notifyDataSetChanged();
            }
            if (resultCode == RESULT_CANCELED){
                arrData.remove(data.getIntExtra("position", 1));
                adapterMain.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void dataMain(List<Datum> listData) {
        arrData.addAll(listData);
        adapterMain.notifyDataSetChanged();
    }
}
