package kr.co.hdtel.lifecycleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kr.co.hdtel.lifecycleproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpBinding()
        setUpObserve()
    }

    private fun setUpBinding() {
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = viewModel
        }
    }

    private fun setUpObserve() {
        viewModel.liveData.observe(this) {
            Log.d("sss","observe liveData...${it}")
            binding.livedataTv.text = it
        }

        lifecycleScope.launchWhenStarted {
            viewModel.stateFlow.collectLatest {
                binding.stateFlowTv.text = it
            }
        }
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