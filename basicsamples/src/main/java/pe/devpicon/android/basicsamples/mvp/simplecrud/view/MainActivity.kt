package pe.devpicon.android.basicsamples.mvp.simplecrud.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import pe.devpicon.android.basicsamples.R
import pe.devpicon.android.basicsamples.model.Customer
import pe.devpicon.android.basicsamples.mvp.simplecrud.contract.MainContract
import pe.devpicon.android.basicsamples.mvp.simplecrud.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View, View.OnClickListener {
    override fun populateForm(customer: Customer?) {
        customer?.let {
            edittext_id.setText("${customer.id}")
            edittext_fullname.setText(customer.name)
            edittext_age.setText("${customer.age}")
        }
    }

    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        presenter.loadAllCustomers()

        button_save.setOnClickListener(this)
        button_update.setOnClickListener(this)
        button_delete.setOnClickListener(this)
        button_read.setOnClickListener(this)
        button_wipe_data.setOnClickListener(this)

    }

    override fun showCustomers(results: MutableList<Customer>) {

        var result = ""

        if (results.size > 0) {
            results.forEach { result += "id = [${it.id}] - name = [${it.name}] - age = [${it.age}] \n" }
        } else {
            result = getString(R.string.nothing_to_show)
        }
        textview_results.text = result
    }

    override fun onClick(v: View?) = when (v?.id) {
        button_save.id -> {
            presenter.saveCustomer(edittext_fullname.text.toString(),
                    edittext_age.text.toString())
        }
        button_wipe_data.id -> presenter.wipeAllData()
        button_update.id -> {
            presenter.updateCustomer(
                    edittext_id.text.toString(),
                    edittext_fullname.text.toString(),
                    edittext_age.text.toString())
        }
        button_delete.id -> {
            presenter.deleteCustomer(edittext_id.text.toString())
        }
        button_read.id -> {
            presenter.readCustomer(edittext_id.text.toString())
        }
        else -> doNothing()
    }

    fun doNothing(){}


    override fun cleanForm() {
        edittext_fullname.text.clear()
        edittext_age.text.clear()
        edittext_fullname.requestFocus()
    }

}
