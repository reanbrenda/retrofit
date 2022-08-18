package kra.bdm.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kra.bdm.retrofit.databinding.ActivityMainBinding
import okio.IOException
import retrofit2.HttpException
const val Tag="MAINACTIVITY"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        lifecycleScope.launchWhenCreated {
            val response=try {
                RetrofitInstance.api.gettodos()
            }catch(e:IOException){
                Log.e(Tag,"IOEXCEPTION ERROR")
                return@launchWhenCreated
            }catch (e:HttpException){
                Log.e(Tag,"HTTP EXCEPTION ERROR")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body()!=null){
                todoAdapter.todos=response.body()!!
            }else{
                Log.e(Tag,"ERROR loading")
            }

        }
    }
    private fun setupRecyclerView()=binding.rvtodos.apply {
        todoAdapter=TodoAdapter()
        adapter=todoAdapter
        layoutManager=LinearLayoutManager(this@MainActivity)

    }
}