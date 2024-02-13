package ru.myitschool.lab23

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

class Dialog(): DialogFragment() {

    private lateinit var addButton: Button
    private lateinit var spinner: Spinner
    private lateinit var viewModel: ExpIncViewModel
    private lateinit var editText: EditText
    private val array = arrayOf("Income", "Expenses")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_content, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ExpIncViewModel::class.java)

        addButton = view.findViewById(R.id.add_button)
        spinner = view.findViewById(R.id.spinner)
        editText = view.findViewById(R.id.expense_amount_edit_text)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, array)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        addButton.setOnClickListener {
            try {
                val expInc = ExpInc(spinner.selectedItem.toString(), editText.text.toString().toDouble())
                viewModel.addData(expInc)
                dismiss()
            } catch (_: Exception){
                Snackbar.make(view, "Неверные данные", Snackbar.LENGTH_LONG).show()
            }

        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }
}