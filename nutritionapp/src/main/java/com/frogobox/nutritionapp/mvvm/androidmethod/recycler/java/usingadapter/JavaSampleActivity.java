package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.java.usingadapter;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.frogobox.nutritionapp.R;
import com.frogobox.nutritionapp.model.People;
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerViewListener;
import com.frogobox.nutritionframework.recycler.widget.NutriRecyclerView;

import java.util.ArrayList;

public class JavaSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frogo_rv_list);
        setupDetailActivity("Java With Adapter");
        setupAdapter();
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

    private ArrayList<People> listData() {
        ArrayList<People> exampleModels = new ArrayList<>();
        // exampleModels.add(new People(Constant.NICK_NAME));
        // exampleModels.add(new People(Constant.NICK_NAME));
        // exampleModels.add(new People(Constant.NICK_NAME));
        // exampleModels.add(new People(Constant.NICK_NAME));
        return exampleModels;
    }

    private void setupAdapter() {
        JavaSampleViewAdapter adapter = new JavaSampleViewAdapter();
        adapter.setupRequirement(R.layout.nutri_rv_list_type_1, listData(), new NutriRecyclerViewListener<People>() {
            @Override
            public void onItemClicked(People data) {
                Toast.makeText(JavaSampleActivity.this, data.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClicked(People data) {
                Toast.makeText(JavaSampleActivity.this, data.getName(), Toast.LENGTH_LONG).show();
            }
        });
        adapter.setupEmptyView(null); // Without Custom View

        NutriRecyclerView nutriRecyclerView = findViewById(R.id.nutri_recycler_view);
        nutriRecyclerView.setAdapter(adapter);
        nutriRecyclerView.isViewLinearVertical(false);
    }

}
