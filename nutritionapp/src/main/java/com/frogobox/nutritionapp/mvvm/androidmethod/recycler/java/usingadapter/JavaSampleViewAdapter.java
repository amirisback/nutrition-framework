package com.frogobox.nutritionapp.mvvm.androidmethod.recycler.java.usingadapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.frogobox.nutritionapp.R;
import com.frogobox.nutritionapp.model.People;
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerNotifyListener;
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerViewAdapter;
import com.frogobox.nutritionframework.recycler.core.NutriRecyclerViewHolder;

import org.jetbrains.annotations.NotNull;


/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * NutriRecyclerViewAdapter
 * Copyright (C) 20/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogorecyclerviewadapter.javasample
 */
public class JavaSampleViewAdapter extends NutriRecyclerViewAdapter<People> {
    @NonNull
    @Override
    public NutriRecyclerViewHolder<People> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JavaSampleViewHolder(viewLayout(parent));
    }

    static class JavaSampleViewHolder extends NutriRecyclerViewHolder<People> {

        private TextView tvExample = itemView.findViewById(R.id.nutri_rv_list_type_1_tv_title);

        JavaSampleViewHolder(@NotNull View view) {
            super(view);
        }

        @Override
        public void initComponent(People data, int position, @NonNull NutriRecyclerNotifyListener<People> listener) {
            tvExample.setText(data.getName());
        }
    }

}
