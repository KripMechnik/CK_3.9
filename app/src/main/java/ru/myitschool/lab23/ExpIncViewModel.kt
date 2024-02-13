package ru.myitschool.lab23

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExpIncViewModel : ViewModel() {
    val arrayOfExpenses = MutableLiveData<List<ExpInc>>()

    fun addData(expInc: ExpInc){
        val currentList = arrayOfExpenses.value.orEmpty().toMutableList()
        currentList.add(expInc)
        arrayOfExpenses.value = currentList
    }

    fun deleteData(i: Int){
        val currentList = arrayOfExpenses.value.orEmpty().toMutableList()
        currentList.removeAt(i)
        arrayOfExpenses.value = currentList
    }
}