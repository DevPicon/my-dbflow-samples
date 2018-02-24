package pe.devpicon.android.basicsamples.model

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import pe.devpicon.android.basicsamples.database.CustomerDatabase

/**
 * Created by devpicon on 2/19/18.
 */
@Table(database = CustomerDatabase::class)
data class Customer(@PrimaryKey(autoincrement = true)
                    var id : Int = 0,
                    @Column var name : String? = null,
                    @Column var age : Int = 0 ) : BaseModel()