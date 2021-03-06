package com.frogobox.nutritionframework.recycler.core

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.frogobox.nutritionframework.log.NLog
import com.frogobox.nutritionframework.recycler.core.NutriRvConstant.NUTRI_RV_TAG

/*
 * Created by Faisal Amir
 * =========================================
 * NutriRecyclerViewAdapter
 * Copyright (C) 29/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.base
 * 
 */
abstract class NutriRecyclerBindingAdapter<T, VB : ViewBinding> :
    RecyclerView.Adapter<NutriRecyclerBindingHolder<T, VB>>() {

    protected var listenerView: NutriRecyclerBindingListener<T, VB>? = null

    protected var listenerNotify = object : NutriRecyclerNotifyListener<T> {

        override fun nutriNotifyData(): MutableList<T> {
            return innerNutriNotifyData()
        }

        override fun nutriNotifyDataSetChanged() {
            innerNutriNotifyDataSetChanged()
        }

        override fun nutriNotifyItemChanged(data: T, position: Int, payload: Any) {
            innerNutriNotifyItemChanged(data, position, payload)
        }

        override fun nutriNotifyItemChanged(data: T, position: Int) {
            innerNutriNotifyItemChanged(data, position)
        }

        override fun nutriNotifyItemInserted(data: T, position: Int) {
            innerNutriNotifyItemInserted(data, position)
        }

        override fun nutriNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
            innerNutriNotifyItemMoved(data, fromPosition, toPosition)
        }

        override fun nutriNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
            innerNutriNotifyItemRangeChanged(data, positionStart, payload)
        }

        override fun nutriNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
            innerNutriNotifyItemRangeChanged(data, positionStart)
        }

        override fun nutriNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
            innerNutriNotifyItemRangeInserted(data, positionStart)
        }

        override fun nutriNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
            innerNutriNotifyItemRangeRemoved(positionStart, itemCount)
        }

        override fun nutriNotifyItemRemoved(position: Int) {
            innerNutriNotifyItemRemoved(position)
        }

    }

    protected val listData = mutableListOf<T>()

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: NutriRecyclerBindingHolder<T, VB>, position: Int) {
        NLog.d("$NUTRI_RV_TAG - listData : ${listData.size}")
        holder.bindItem(listData[position], position, listenerView, listenerNotify)
    }


    // Notify Data List
    fun innerNutriNotifyData() : MutableList<T> {
        return listData
    }

    // Notify Data Set Changed
    fun innerNutriNotifyDataSetChanged() {
        notifyDataSetChanged()
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyDataSetChanged")
    }

    // Notify Data Item Changed
    fun innerNutriNotifyItemChanged(data: T, position: Int, payload: Any) {
        listData[position] = data
        notifyItemChanged(position, payload)
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged : ${data.toString()}")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged : $position")
    }

    // Notify Data Item Changed
    fun innerNutriNotifyItemChanged(data: T, position: Int) {
        listData[position] = data
        notifyItemChanged(position)
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged : ${data.toString()}")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged : $position")
    }

    // Notify Data Item Inserted
    fun innerNutriNotifyItemInserted(data: T, position: Int) {
        listData.add(position, data)
        notifyItemInserted(position)
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemInserted")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemInserted : ${data.toString()}")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemInserted : $position")
    }

    // Notify Data Item Moved
    fun innerNutriNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
        listData.removeAt(fromPosition)
        listData.add(toPosition, data)
        notifyItemMoved(fromPosition, toPosition)
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemMoved")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemMoved : ${data.toString()}")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemMoved : $fromPosition")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemMoved : $toPosition")
    }

    // Notify Data Item Range Changed
    fun innerNutriNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size, payload)
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : ${data.toString()}")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : $positionStart")
    }

    // Notify Data Item Range Changed
    fun innerNutriNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : ${data.toString()}")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : $positionStart")
    }

    // Notify Data Item Range Inserted
    fun innerNutriNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeInserted")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : ${data.toString()}")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : $positionStart")
    }

    // Notify Data Item Range Removed
    fun innerNutriNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        listData.subList(positionStart, (positionStart + itemCount)).clear()
        notifyItemRangeRemoved(positionStart, itemCount)
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeRemoved")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeRemoved : $positionStart")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeRemoved : $itemCount")
    }

    // Notify Data Item Removed
    fun innerNutriNotifyItemRemoved(position: Int) {
        listData.removeAt(position)
        notifyItemRemoved(position)
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRemoved")
        NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRemoved : $position")
    }

    fun setupData(data: List<T>?) {
        this.listData.clear()

        if (data != null) {
            this.listData.addAll(data)
        }
    }

    fun setupListener(listener: NutriRecyclerBindingListener<T, VB>?) {
        if (listener != null) {
            listenerView = listener
        }
    }

    fun setupRequirement(
        data: List<T>?,
        listener: NutriRecyclerBindingListener<T, VB>?
    ) {

        if (listener != null) {
            listenerView = listener
        }

        this.listData.clear()

        if (data != null) {
            this.listData.addAll(data)
        }
    }

}