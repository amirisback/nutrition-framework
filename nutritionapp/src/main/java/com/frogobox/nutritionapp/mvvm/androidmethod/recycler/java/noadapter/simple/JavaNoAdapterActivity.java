package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.java.noadapter.simple;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.frogobox.nutritionapp.R;
import com.frogobox.nutritionapp.model.People;
import com.frogobox.nutritionframework.recycler.core.INutriViewAdapter;
import com.frogobox.nutritionframework.recycler.widget.NutriRecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class JavaNoAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frogo_rv_list);
        setupDetailActivity("Java No Adapter");
        setupNutriRecyclerView();
    }

    private ArrayList<People> listData() {
        ArrayList<People> exampleModels = new ArrayList<>();
        // exampleModels.add(new People(Constant.NICK_NAME));
        // exampleModels.add(new People(Constant.NICK_NAME));
        // exampleModels.add(new People(Constant.NICK_NAME));
        // exampleModels.add(new People(Constant.NICK_NAME));
        return exampleModels;
    }

    private void setupNutriRecyclerView() {

        INutriViewAdapter frogoViewAdapterCallback = new INutriViewAdapter<People>() {
            @Override
            public void onItemLongClicked(@NonNull View view, People data, int position) {
                // setup item long clicked on frogo recycler view
                Toast.makeText(JavaNoAdapterActivity.this, data.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClicked(@NonNull View view, People data, int position) {
                // setup item clicked on frogo recycler view
                Toast.makeText(JavaNoAdapterActivity.this, data.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void setupInitComponent(@NonNull View view, People data, int position) {
                // Init component content item recyclerview
                TextView tvExample = view.findViewById(R.id.nutri_rv_list_type_1_tv_title);
                tvExample.setText(data.getName());
            }
        };

        NutriRecyclerView nutriRecyclerView = findViewById(R.id.nutri_recycler_view);

        nutriRecyclerView.injector()
                .addData(listData())
                .addCustomView(R.layout.nutri_rv_list_type_1)
                .addEmptyView(null)
                .addCallback(frogoViewAdapterCallback)
                .createLayoutStaggeredGrid(2)
                .build();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    private void setupDetailActivity(String title) {
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0f);
    }

}