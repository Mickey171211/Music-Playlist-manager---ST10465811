package za.ac.iie.musicplaylistmanager_st10465811

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songTitles = arrayListOf<String>()
        val artistNames = arrayListOf<String>()
        val songRatings = arrayListOf<Int>()
        val songComments = arrayListOf<String>()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val titleInput = findViewById<EditText>(R.id.songTitleInput)
            val artistInput = findViewById<EditText>(R.id.artistNameInput)
            val ratingInput = findViewById<EditText>(R.id.ratingInput)
            val commentInput = findViewById<EditText>(R.id.commentInput)

            val addButton = findViewById<Button>(R.id.addButton)
            val viewDetailsButton = findViewById<Button>(R.id.viewDetailsButton)
            val exitButton = findViewById<Button>(R.id.exitButton)

            addButton.setOnClickListener{
                val title = titleInput.text.toString()
                val artist = artistInput.text.toString()
                val rating = ratingInput.text.toString().toIntOrNull() ?: 0
                val comment = commentInput.text.toString()

                if (title.isNotBlank() && artist.isNotBlank() && rating in 1..5) {
                    songTitles.add(title)
                    artistNames.add(artist)
                    songRatings.add(rating)
                    songComments.add(comment)

                    Toast.makeText(this, "Song added", Toast.LENGTH_SHORT).show()

                    title

                }

            }

        }

    }
}