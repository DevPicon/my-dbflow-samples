package pe.devpicon.android.basicsamples.mvp.start

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start.*
import pe.devpicon.android.basicsamples.R
import pe.devpicon.android.basicsamples.mvp.simplecrud.view.MainActivity

/**
 * Created by devpicon on 2/24/18.
 */
class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        button_basic_crud.setOnClickListener{ startActivity(Intent(this, MainActivity::class.java)) }
    }
}