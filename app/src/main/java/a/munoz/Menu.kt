package a.munoz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.youtube.player.YouTubeStandalonePlayer
import java.lang.IllegalArgumentException

class Menu : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSingle =findViewById<Button>(R.id.btn_single)
        val btnPlaylist =findViewById<Button>(R.id.btn_playlist)

        //btnSingle.setOnClickListener(View.OnClickListener { p0 -> TODO("Not yet implemented") })
        //val listener = object : View.OnClickListener{}

        btnSingle.setOnClickListener(this)
        btnPlaylist.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val intent = when(view.id) {
            R.id.btn_single -> YouTubeStandalonePlayer.createVideoIntent(
                this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID_KEY)
            R.id.btn_playlist -> YouTubeStandalonePlayer.createPlaylistIntent(
                this, getString(R.string.GOOGLE_API_KEY), PLAYLIST_ID_KEY, 0, 0, true, false)
            else -> throw IllegalArgumentException("Invalid Button")

        }

        startActivity(intent)
    }
}