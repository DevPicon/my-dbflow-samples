package pe.devpicon.android.basicsamples.mvp.presenter

import com.raizlabs.android.dbflow.sql.language.SQLite
import pe.devpicon.android.basicsamples.model.Customer
import pe.devpicon.android.basicsamples.model.Customer_Table
import pe.devpicon.android.basicsamples.mvp.contract.MainContract

/**
 * Created by devpicon on 2/19/18.
 */
class MainPresenter(val view: MainContract.View) : MainContract.Presenter {
    override fun readCustomer(id: String) {
        val customer = SQLite.select().from(Customer::class.java)
                .where(Customer_Table.id.eq(id.toInt())).querySingle()
        view.populateForm(customer)
    }

    override fun deleteCustomer(id: String) {
        Customer(id.toInt()).delete()
        loadAllCustomers()
    }

    override fun updateCustomer(id: String, fullname: String, age: String) {
        Customer(id.toInt(), fullname, age.toInt()).update()
        loadAllCustomers()
    }

    override fun wipeAllData() {
        SQLite.delete().from(Customer::class.java)
                .async()
                .success { loadAllCustomers() }
                .execute()
    }

    override fun loadAllCustomers() {
        val results : MutableList<Customer> = SQLite.select()
                .from(Customer::class.java)
                .queryList()
        view.showCustomers(results)
    }

    override fun saveCustomer(fullname: String, age: String) {
        save(fullname, age)
        loadAllCustomers()
        view.cleanForm()
    }

    private fun save(fullname: String, age: String) {
        Customer(0, fullname, age.toInt()).save()
    }

}