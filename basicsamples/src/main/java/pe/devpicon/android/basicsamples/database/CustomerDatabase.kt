package pe.devpicon.android.basicsamples.database

import com.raizlabs.android.dbflow.annotation.Database

/**
 * Created by devpicon on 2/19/18.
 */
@Database(name = CustomerDatabase.NAME, version = CustomerDatabase.VERSION)
class CustomerDatabase {
    companion object {
        const val NAME = "customer"
        const val VERSION = 1
    }
}