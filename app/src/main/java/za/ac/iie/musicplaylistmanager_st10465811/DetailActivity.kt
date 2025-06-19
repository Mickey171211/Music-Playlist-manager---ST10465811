package za.ac.iie.musicplaylistmanager_st10465811

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val titles = intent.getStringArrayListExtra("titles") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artist") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val size = listOf(titles.size, artists.size, ratings.size, comments.size).minOrNull() ?:0

        val details = StringBuilder()
        for (i in 0 until size) {
            details.append(" ${titles[i]} - ${artists[i]}\n")
            details.append(" Rating: ${ratings[i]}\n")
            details.append(" Comment: ${comments[i]}\n\n")

        }

        val averageRating = if (ratings.isNotEmpty()) ratings.average()else 0.0

        val detailsView = findViewById<TextView>(R.id.textViewDetails)
        val averageView = findViewById<TextView>(R.id.textViewAverage)
        val backButton = findViewById<Button>(R.id.backButton)

        detailsView.text = details.toString()
        averageView.text = "Average Rating: %.2f".format(averageRating)

        backButton.setOnClickListener {
            finish()
        }

    }
}