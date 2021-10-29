package GoSPBratsk.gospbratsk

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val youtubeLink = Uri.parse( "https://spbratsk.ru")


        val resultLauncher =  registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result->



            if (result.resultCode == RESULT_OK)
                result.data?.data.toString()
            else Toast.makeText(this,"NO", Toast.LENGTH_LONG).show()
        }

        val button: Button = findViewById(R.id.button1)
        //   val link = Uri.parse("https://odin.study")
        val intent = Intent(Intent.ACTION_VIEW,youtubeLink)
        // intent.type = "file/"
        button.setOnClickListener {

            resultLauncher.launch(intent)

        }



    }
}