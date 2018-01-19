package com.example.k_matsushita.mvvmsample

import android.support.v7.util.DiffUtil

/**
 * [DiffUtil.Callback] の簡易的な実装
 *
 * @see DiffUtil.Callback
 * Created by k-matsushita on 2018/01/19.
 */
class DiffUtilCallback(private val old: List<*>?, private val new: List<*>?) : DiffUtil.Callback() {

    /**
     * 同じアイテムか？
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = old?.getOrNull(oldItemPosition) == new?.getOrNull(newItemPosition)

    /**
     * 更新される前のリストのサイズ
     */
    override fun getOldListSize() = old?.size ?: 0

    /**
     * 更新されたリストのサイズ
     */
    override fun getNewListSize() = new?.size ?: 0

    /**
     * アイテムの中身が同じか？
     */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = old?.getOrNull(oldItemPosition) == new?.getOrNull(newItemPosition)
}