package com.frogobox.nutritionframework.recycler.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.nutritionframework.R
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
abstract class NutriRecyclerViewAdapter<T> :
    RecyclerView.Adapter<NutriRecyclerViewHolder<T>>() {

    var hasEmptyView = false
    var hasMultiHolder = false
    var hasNestedView = false

    protected var listenerView: NutriRecyclerViewListener<T>? = null

    protected var listenerNotify = object : NutriRecyclerNotifyListener<T> {

        override fun nutriNotifyData(): MutableList<T> {
            return listData
        }

        override fun nutriNotifyDataSetChanged() {
            notifyDataSetChanged()
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyDataSetChanged")
        }

        override fun nutriNotifyItemChanged(data: T, position: Int, payload: Any) {
            listData[position] = data
            notifyItemChanged(position, payload)
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged : ${data.toString()}")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged : $position")
        }

        override fun nutriNotifyItemChanged(data: T, position: Int) {
            listData[position] = data
            notifyItemChanged(position)
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged : ${data.toString()}")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemChanged : $position")
        }

        override fun nutriNotifyItemInserted(data: T, position: Int) {
            listData.add(position, data)
            notifyItemInserted(position)
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemInserted")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemInserted : ${data.toString()}")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemInserted : $position")
        }

        override fun nutriNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
            listData.removeAt(fromPosition)
            listData.add(toPosition, data)
            notifyItemMoved(fromPosition, toPosition)
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemMoved")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemMoved : ${data.toString()}")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemMoved : $fromPosition")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemMoved : $toPosition")
        }

        override fun nutriNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
            listData.addAll(positionStart, data)
            notifyItemRangeChanged(positionStart, data.size, payload)
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : ${data.toString()}")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : $positionStart")
        }

        override fun nutriNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
            listData.addAll(positionStart, data)
            notifyItemRangeChanged(positionStart, data.size)
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : ${data.toString()}")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : $positionStart")
        }

        override fun nutriNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
            listData.addAll(positionStart, data)
            notifyItemRangeChanged(positionStart, data.size)
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeInserted")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : ${data.toString()}")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeChanged : $positionStart")
        }

        override fun nutriNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
            listData.subList(positionStart, (positionStart + itemCount)).clear()
            notifyItemRangeRemoved(positionStart, itemCount)
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeRemoved")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeRemoved : $positionStart")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRangeRemoved : $itemCount")
        }

        override fun nutriNotifyItemRemoved(position: Int) {
            listData.removeAt(position)
            notifyItemRemoved(position)
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRemoved")
            NLog.d("$NUTRI_RV_TAG - NutriNotifyListener : nutriNotifyItemRemoved : $position")
        }

    }

    protected val listPosition = HashMap<Int, Int>()
    protected val sharedPool = RecyclerView.RecycledViewPool()

    protected val frogoHolder = mutableListOf<NutriHolder<T>>()
    protected val listData = mutableListOf<T>()
    protected val listDataNested = mutableListOf<MutableList<T>>()
    protected var listCount = 0

    protected var layoutRv: Int = 0
    protected var customLayoutRestId: Int = 0
    protected var emptyLayoutResId: Int = R.layout.nutri_container_empty_view

    fun bindNestedHolder() {

    } // component view

    override fun getItemCount(): Int {

        return if (hasNestedView) {
            listDataNested.size
        } else {
            if (hasMultiHolder) {
                if (hasEmptyView) {
                    listCount = if (frogoHolder.size == 0) {
                        1
                    } else {
                        frogoHolder.size
                    }
                    listCount
                } else {
                    frogoHolder.size
                }
            } else {
                if (hasEmptyView) {
                    listCount = if (listData.size == 0) {
                        1
                    } else {
                        listData.size
                    }
                    listCount
                } else {
                    listData.size
                }
            }
        }
    }

    override fun onBindViewHolder(holder: NutriRecyclerViewHolder<T>, position: Int) {

        NLog.d("$NUTRI_RV_TAG - hasMultiHolder : $hasMultiHolder")
        NLog.d("$NUTRI_RV_TAG - hasEmptyView : $hasEmptyView")
        NLog.d("$NUTRI_RV_TAG - listCount : $listCount")
        NLog.d("$NUTRI_RV_TAG - frogoHolder : ${frogoHolder.size}")
        NLog.d("$NUTRI_RV_TAG - listData : ${listData.size}")

        if (hasNestedView) {
            bindNestedHolder()
        } else {
            if (hasMultiHolder) {
                if (hasEmptyView) {
                    if (frogoHolder.size != 0) {
                        holder.bindItem(
                            frogoHolder[position].data,
                            position,
                            frogoHolder[position].listener,
                            listenerNotify
                        )
                    }
                } else {
                    holder.bindItem(
                        frogoHolder[position].data,
                        position,
                        frogoHolder[position].listener,
                        listenerNotify
                    )
                }
            } else {
                if (hasEmptyView) {
                    if (listData.size != 0) {
                        holder.bindItem(listData[position], position, listenerView, listenerNotify)
                    }
                } else {
                    holder.bindItem(listData[position], position, listenerView, listenerNotify)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (hasMultiHolder) {
            if (frogoHolder.size != 0) {
                frogoHolder[position].option
            } else {
                super.getItemViewType(position)
            }
        } else {
            super.getItemViewType(position)
        }
    }

    override fun onViewRecycled(holder: NutriRecyclerViewHolder<T>) {
        if (hasNestedView) {
            val position = holder.adapterPosition
            val nestedHolder = holder as NutriNestedHolder<T>
            listPosition[position] =
                nestedHolder.getLinearLayoutManager().findFirstVisibleItemPosition()
        }
        super.onViewRecycled(holder)
    }

    fun layoutHandling() {
        if (hasMultiHolder) {
            if (customLayoutRestId != 0) {
                layoutRv = if (frogoHolder.isNotEmpty()) {
                    customLayoutRestId
                } else {
                    emptyLayoutResId
                }
            }
        } else {
            if (customLayoutRestId != 0) {
                layoutRv = if (listData.isNotEmpty()) {
                    customLayoutRestId
                } else {
                    emptyLayoutResId
                }
            }
        }
    }

    fun viewLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layoutRv, parent, false)
    }

    fun viewLayout(parent: ViewGroup, layoutResId: Int): View {
        customLayoutRestId = layoutResId
        layoutHandling()
        return LayoutInflater.from(parent.context).inflate(layoutRv, parent, false)
    }

    fun setupNestedView() {
        hasNestedView = true
    }

    fun setupMultiHolder() {
        hasMultiHolder = true
    }

    fun setupEmptyView(emptyView: Int?) {
        hasEmptyView = true
        if (emptyView != null) {
            emptyLayoutResId = emptyView
        }
        layoutHandling()
    }

    fun setupDataNested(data: List<MutableList<T>>?) {
        this.listDataNested.clear()

        if (data != null) {
            this.listDataNested.addAll(data)
        }
    }

    fun setupData(data: List<T>?) {
        this.listData.clear()

        if (data != null) {
            this.listData.addAll(data)
        }
    }

    fun setupListener(listener: NutriRecyclerViewListener<T>?) {
        if (listener != null) {
            listenerView = listener
        }
    }

    fun setupCustomLayout(customViewId: Int) {
        customLayoutRestId = customViewId
    }

    fun setupRequirement(
        customViewId: Int,
        data: List<T>?,
        listener: NutriRecyclerViewListener<T>?
    ) {

        if (listener != null) {
            listenerView = listener
        }

        this.listData.clear()

        if (data != null) {
            this.listData.addAll(data)
        }

        customLayoutRestId = customViewId
        layoutHandling()
    }

    fun setupRequirement(viewHolder: List<NutriHolder<T>>) {
        frogoHolder.addAll(viewHolder)
    }

}