package kr.co.hdtel.lifecycleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.co.hdtel.lifecycleproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding by lazy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBinding()
    }

    private fun setUpBinding() {
//        binding = DataB
    }

    fun clickLiveDataBtn() {

    }

    fun clickFlowBtn() {

    }

    override fun onStop() {
        super.onStop()
        Log.d("sss","***** onStop call() *****")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("sss","***** onDestroy call() *****")
    }
}