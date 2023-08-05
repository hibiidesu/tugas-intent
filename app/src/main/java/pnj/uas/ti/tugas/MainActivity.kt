package pnj.uas.ti.tugas

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val alertButton: Button = findViewById(R.id.alertButton)
        val toastButton: Button = findViewById(R.id.toastButton)

        alertButton.setOnClickListener{
            intent = Intent(applicationContext, ImplicitActivity::class.java)
            startActivity(intent)
            finish()
        }

        toastButton.setOnClickListener{
            intent = Intent(applicationContext, BiodataActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}