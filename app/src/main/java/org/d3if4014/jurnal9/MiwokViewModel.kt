package com.example.ghapi.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.d3if4014.jurnal9.network.MiwokApi
import org.d3if4014.jurnal9.network.MiwokData

class MiwokViewModel : ViewModel() {

    private val _items = MutableLiveData<List<MiwokData>>()
    val items : LiveData<List<MiwokData>> get() = _items

    private val _response = MutableLiveData<String>()
    val response : LiveData<String> get() = _response

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> get() = _loading


    private var vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
        initData()
    }

    private fun initData() {
        _response.value = "Loading ....."
        _loading.value = true
        crScope.launch{
            try{
                val result = MiwokApi.retrofitService.showList()
                Log.i("tesArr", result.toString())
                if(result.size > 0) {
                    _items.value = result
                    _response.value = "OK"
                }
            }catch (t: Throwable){
                _response.value = "Failed, Internet OFF"
                Log.i("tes", t.message.toString())
            }finally {
                _loading.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }

}