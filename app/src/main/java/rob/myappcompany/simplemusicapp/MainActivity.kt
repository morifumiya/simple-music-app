package rob.myappcompany.simplemusicapp

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // 5) mpを横断的に使えるようにここに書く(このクラスでしか使わないならprivate & 初期化しろエラーが出たら lateinit var)
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 3) MediaPlayer をひとまずここに用意

        // 1) view を取得->ボタン押下でテキストを赤色
        val tv: TextView = findViewById(R.id.tv)
        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            tv.setTextColor(Color.RED)
        }
        // 2) 音楽ファイルをres/rawディレクトリに入れる
        // 4) MediaPlayer を再生（ここでは起動と同時）
        mp = MediaPlayer.create(this, R.raw.sonata)
        mp.isLooping = true
        mp.start()
    }

    // 6) 再開
    override fun onResume() {
        super.onResume()
        mp.start()
    }


    // 5) 一時停止
    override fun onPause() {
        super.onPause()
        mp.pause()
    }

    // 7) 終了・メモリの解放
    override fun onDestroy() {
        super.onDestroy()
        mp.stop() // 終了・停止
        mp.release() // 解放
    }
}
