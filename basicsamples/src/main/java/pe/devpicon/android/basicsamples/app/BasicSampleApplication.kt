package pe.devpicon.android.basicsamples.app

import android.app.Application
import com.facebook.stetho.Stetho
import com.raizlabs.android.dbflow.config.FlowManager

/**
 * Created by devpicon on 2/19/18.
 */
class BasicSampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FlowManager.init(this)
        Stetho.initializeWithDefaults(this);
    }
}