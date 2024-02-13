package ru.myitschool.lab23

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.myitschool.lab23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recycler: RecyclerView
    private lateinit var button: FloatingActionButton
    private lateinit var viewModel: ExpIncViewModel
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[ExpIncViewModel::class.java]

        recycler = binding.efExpensesRv
        recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = RecyclerViewAdapter(this, viewModel)



        viewModel.arrayOfExpenses.observe(this, Observer {
            adapter.notifyDataSetChanged()
        })
        recycler.adapter = adapter



        button = binding.addFab
        button.setOnClickListener {
            Dialog().show(supportFragmentManager, "Dialog")
        }

    }

}
