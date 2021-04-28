package com.frogobox.generalframework.util.helper;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * PregnantFashion
 * Copyright (C) 08/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.basemusicplayer.util.helper
 */
public class RawDataHelper {

    public ArrayList<String> fetchData(Context mContext, int sourceRaw) {
        ArrayList<String> dataArrayList = new ArrayList<>();
        Resources res = mContext.getResources();
        InputStream raw_dict = res.openRawResource(sourceRaw);
        BufferedReader reader = new BufferedReader(new InputStreamReader(raw_dict));
        try {
            String column;
            while ((column = reader.readLine()) != null) {
                dataArrayList.add(column);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.shuffle(dataArrayList);
        return dataArrayList;
    }


//    public ArrayList<Fashion> fetchData(String sourceRaw) {
//        ArrayList<Fashion> dataArrayList = new ArrayList<>();
//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader(sourceRaw));
//            String column;
//            while ((column = reader.readLine()) != null) {
//                String[] splitString = column.split(",");
//                ArrayList<String> partTemp = new ArrayList<>();
//                Collections.addAll(partTemp, splitString);
//                Fashion mData = new Fashion(partTemp.get(0), Integer.parseInt(partTemp.get(1)), Double.parseDouble(partTemp.get(2)));
//                dataArrayList.add(mData);
//            }
//            reader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dataArrayList;
//    }


}
