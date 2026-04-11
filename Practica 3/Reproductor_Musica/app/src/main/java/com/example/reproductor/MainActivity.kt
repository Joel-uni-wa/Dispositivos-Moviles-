package com.example.reproductor

import android.app.Activity
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button

//Reproductor de musica
//Autor: Joel Matias Choquepata Guarniz
//FC: 04/10/2026
class MainActivity : Activity() {

    private var mediaPlayer: MediaPlayer? = null
    private var currentSong: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)

        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnPause = findViewById<Button>(R.id.btnPause)
        val btnStop = findViewById<Button>(R.id.btnStop)

        // seleccionar canción
        btn1.setOnClickListener { loadSong(R.raw.musica1) }
        btn2.setOnClickListener { loadSong(R.raw.musica2) }
        btn3.setOnClickListener { loadSong(R.raw.musica3) }

        //  PLAY
        btnPlay.setOnClickListener {
            mediaPlayer?.start()
        }

        // ⏸ PAUSE
        btnPause.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
            }
        }

        // STOP
        btnStop.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
            currentSong = null
        }
    }

    private fun loadSong(song: Int) {
        try {
            mediaPlayer?.release()

            mediaPlayer = MediaPlayer.create(this, song)
            currentSong = song
            mediaPlayer?.start()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}