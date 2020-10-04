package umairayub.madialogdemoapp

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

import umairayub.madialog.MaDialog
import umairayub.madialog.MaDialogListener

class MainActivity : AppCompatActivity() {

    private val msg: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis scelerisque, turpis et fringilla malesuada, leo velit ullamcorper enim, quis iaculis metus urna ut ligula. Sed malesuada lacinia massa, a accumsan justo condimentum vel."
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn1.setOnClickListener {
            MaDialog.Builder(this@MainActivity)
                    .setMessage(msg)
                    .build()
        }
        btn2.setOnClickListener {
            MaDialog.Builder(this@MainActivity)
                    .setTitle("Basic With Title")
                    .setMessage(msg)
                    .build()
        }
        btn3.setOnClickListener {
            MaDialog.Builder(this@MainActivity)
                    .setMessage(msg)
                    .setButtonOrientation(LinearLayout.HORIZONTAL)
                    .AddNewButton(R.style.AppTheme, "Yes", object : MaDialogListener {
                        override fun onClick() {
                        }
                    })
                    .AddNewButton(R.style.AppTheme, "No", object : MaDialogListener {
                        override fun onClick() {
                        }
                    })
                    .build()
        }
        btn4.setOnClickListener {
            MaDialog.Builder(this@MainActivity)
                    .setTitle("Basic with Title + Buttons")
                    .setMessage(msg)
                    .AddNewButton(R.style.AppTheme, "Yes", object : MaDialogListener {
                        override fun onClick() {

                        }
                    })
                    .AddNewButton(R.style.AppTheme, "Cancel", object : MaDialogListener {
                        override fun onClick() {

                        }
                    })
                    .build()
        }
        btn5.setOnClickListener {
            MaDialog.Builder(this@MainActivity)
                    .setTitle("Basic with Image + Title + Buttons")
                    .setMessage(msg)
                    .setMessageTextColor(Color.WHITE)
                    .setTitleTextColor(Color.WHITE)
                    .setBackgroundColor(Color.BLUE)
                    .setPositiveButtonTextColor(Color.GREEN)
                    .setNegativeButtonTextColor(Color.RED)
                    .setImage(R.drawable.image)
                    .setPositiveButtonText("Yes")
                    .setNegativeButtonText("No")
                    .setPositiveButtonListener(object : MaDialogListener {
                        override fun onClick() {

                        }
                    })
                    .setNegativeButtonListener(object : MaDialogListener {
                        override fun onClick() {

                        }
                    })

                    .build()
        }
        btn6.setOnClickListener {
            MaDialog.Builder(this@MainActivity)
                    .setTitle("Basic with GIF + Title + Buttons")
                    .setMessage(msg)
                    .setGif(R.drawable.dragon)
                    .AddNewButton(R.style.AppTheme, "Yes", object : MaDialogListener {
                        override fun onClick() {

                        }
                    })
                    .AddNewButton(R.style.AppTheme, "Cancel", object : MaDialogListener {
                        override fun onClick() {

                        }
                    })
                    .build()
        }

        btn7.setOnClickListener {
            val uri = Uri.parse("https://github.com/umairayub79/MaDialog") // missing 'http://' will cause crashed
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

    }


}
