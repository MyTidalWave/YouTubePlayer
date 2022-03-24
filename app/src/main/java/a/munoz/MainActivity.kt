package a.munoz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPlaySingle = findViewById<Button>(R.id.btn_SingleVideo)
        val btnSubMenu = findViewById<Button>(R.id.btn_SubMenu)

        btnPlaySingle.setOnClickListener(this)
        btnSubMenu.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = when(view.id){
            R.id.btn_SingleVideo -> Intent(this, YouTubePlayerActivity::class.java)
            R.id.btn_SubMenu -> Intent(this, Menu::class.java)
            else -> throw IllegalArgumentException("Invalid button")
        }
        startActivity(intent)

    }
}