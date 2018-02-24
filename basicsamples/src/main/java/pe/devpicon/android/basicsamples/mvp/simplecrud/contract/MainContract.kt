package pe.devpicon.android.basicsamples.mvp.simplecrud.contract

import pe.devpicon.android.basicsamples.model.Customer

/**
 * Created by devpicon on 2/19/18.
 */
interface MainContract {
    interface View{
        fun showCustomers(results: MutableList<Customer>)
        fun cleanForm()
        fun populateForm(customer: Customer?)
    }
    interface Presenter{
        fun loadAllCustomers()
        fun saveCustomer(fullname: String, age: String)
        fun wipeAllData()
        fun updateCustomer(id: String, fullname: String, age: String)
        fun deleteCustomer(id: String)
        fun readCustomer(id: String)
    }
}