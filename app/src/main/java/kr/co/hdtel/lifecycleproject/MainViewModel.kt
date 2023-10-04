package kr.co.hdtel.lifecycleproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {

    private val _liveData = MutableLiveData("ANDROID")
    val liveData: LiveData<String> = _liveData

    private val _stateFlow = MutableStateFlow("ANDROID")
    val stateFlow = _stateFlow.asStateFlow()

    private val _sharedFlow = MutableSharedFlow<String>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun triggerLiveData() {
        Log.d("sss","triggerLiveData()")
        _liveData.value = "LiveData"
    }

    fun triggerStateFlow() {
        _stateFlow.value = "StateFlow"
    }

}