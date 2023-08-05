package pnj.uas.ti.tugas

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ImplicitActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit)

        val searchButton: Button = findViewById(R.id.searchButton)
        val mapButton: Button = findViewById(R.id.mapButton)
        val chooseButton: Button = findViewById(R.id.chooseButton)
        val returnButton: Button = findViewById(R.id.returnButton)

        searchButton.setOnClickListener{
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.google.com/"))
            startActivity(intent)
        }

        mapButton.setOnClickListener{
            // Map point based on address
            val mapIntent: Intent = Uri.parse(
                "geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California"
            ).let { location ->
                // Or map point based on latitude/longitude
                // val location: Uri = Uri.parse("geo:37.422219,-122.08364?z=14") // z param is zoom level
                Intent(Intent.ACTION_VIEW, location)
            }
        }

        chooseButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)

            // Create intent to show chooser
            val chooser = Intent.createChooser(intent, /* title */ null)

            // Try to invoke the intent.
            try {
                startActivity(chooser)
            } catch (e: ActivityNotFoundException) {
                // Define what your app should do if no activity can handle the intent.
                val toast = Toast.makeText(this,"No application to be used", Toast.LENGTH_SHORT)
            }
        }

        returnButton.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}