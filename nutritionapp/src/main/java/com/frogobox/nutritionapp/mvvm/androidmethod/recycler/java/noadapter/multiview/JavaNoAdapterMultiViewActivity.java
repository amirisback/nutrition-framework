package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.java.noadapter.multiview;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.frogobox.nutritionapp.R;
import com.frogobox.nutritionapp.model.People;
import com.frogobox.nutritionapp.util.Constant;
import com.frogobox.nutritionframework.recycler.core.INutriViewHolder;
import com.frogobox.nutritionframework.recycler.core.NutriHolder;
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerViewListener;
import com.frogobox.nutritionframework.recycler.core.NutriRvConstant;
import com.frogobox.nutritionframework.recycler.widget.NutriRecyclerView;

import java.util.ArrayList;

public class JavaNoAdapterMultiViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frogo_rv_grid);
        setupDetailActivity("Java No Adapter - Multi View");
        setupNutriRecyclerView();
    }

    private static INutriViewHolder<People> firstCallback() {
        return (view, data) -> {
            // Init component content item recyclerview
            TextView title = view.findViewById(R.id.nutri_rv_grid_type_1_tv_title);
            ImageView photo = view.findViewById(R.id.nutri_rv_grid_type_1_iv_poster);
            title.setText(data.getName());
            Glide.with(view.getContext()).load(NutriRvConstant.LINK_PHOTO_GITHUB).into(photo);
        };
    }

    private static INutriViewHolder<People> secondCallback() {
        return (view, data) -> {
            // Init component content item recyclerview
            TextView title = view.findViewById(R.id.nutri_rv_grid_type_3_tv_title);
            TextView subTitle = view.findViewById(R.id.nutri_rv_grid_type_3_tv_subtitle);
            TextView desc = view.findViewById(R.id.nutri_rv_grid_type_3_tv_desc);
            ImageView photo = view.findViewById(R.id.nutri_rv_grid_type_3_iv_poster);
            title.setText(data.getName());
            subTitle.setText(data.getName());
            desc.setText(NutriRvConstant.DUMMY_LOREM_IPSUM);
            Glide.with(view.getContext()).load(NutriRvConstant.LINK_PHOTO_GITHUB).into(photo);
        };
    }

    private NutriRecyclerViewListener<People> firstListenerType() {
        return new NutriRecyclerViewListener<People>() {
            @Override
            public void onItemLongClicked(People data) {
                Toast.makeText(JavaNoAdapterMultiViewActivity.this, data.getName() + " First", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClicked(People data) {
                Toast.makeText(JavaNoAdapterMultiViewActivity.this, "LAYOUT TYPE 1", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private NutriRecyclerViewListener<People> secondListenerType() {
        return new NutriRecyclerViewListener<People>() {
            @Override
            public void onItemLongClicked(People data) {
                Toast.makeText(JavaNoAdapterMultiViewActivity.this, data.getName() + " Second", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClicked(People data) {
                Toast.makeText(JavaNoAdapterMultiViewActivity.this, "LAYOUT TYPE 2", Toast.LENGTH_SHORT).show();
            }
        };
    }

    private ArrayList<NutriHolder<Object>> data() {
        ArrayList<NutriHolder<Object>> data = new ArrayList<>();
        data.add(new NutriHolder(new People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_1, NutriRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        data.add(new NutriHolder(new People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new NutriHolder(new People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new NutriHolder(new People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new NutriHolder(new People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new NutriHolder(new People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_1, NutriRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        data.add(new NutriHolder(new People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_1, NutriRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        data.add(new NutriHolder(new People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new NutriHolder(new People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_3, NutriRvConstant.OPTION_HOLDER_SECOND, secondCallback(), secondListenerType()));
        data.add(new NutriHolder(new People(Constant.FULL_NAME, ""), R.layout.nutri_rv_grid_type_1, NutriRvConstant.OPTION_HOLDER_FIRST, firstCallback(), firstListenerType()));
        return data;
    }

    private void setupNutriRecyclerView() {

        NutriRecyclerView nutriRecyclerView = findViewById(R.id.nutri_recycler_view);
        nutriRecyclerView.injector()
                .addDataFH(data())
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
