package com.example.socialspark

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Tag for logging purposes throughout the app
    private val TAG = "SocialSparkApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity created and layout set.")

        // 1. Initialize views by finding them from the layout
        val etTimeOfDay = findViewById<EditText>(R.id.etTimeOfDay)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // 2. Set up the submit button click listener
        btnSubmit.setOnClickListener {
            val inputTime = etTimeOfDay.text.toString().trim()
            Log.d(TAG, "Submit button clicked. User input: '\$inputTime'")
            
            // Call our logic function to get the spark
            val sparkSuggestion = getSparkSuggestion(inputTime)
            
            // Display the result in the TextView
            tvResult.text = sparkSuggestion
            Log.d(TAG, "Displayed spark: '\$sparkSuggestion'")
        }

        // 3. Set up the reset button click listener
        btnReset.setOnClickListener {
            Log.d(TAG, "Reset button clicked. Clearing fields.")
            etTimeOfDay.text.clear()
            tvResult.text = ""
        }
    }

    /**
     * Determines the social spark suggestion based on the provided time of day.
     * Utilizes if/else-if statements rather than a when expression per requirements.
     */
    private fun getSparkSuggestion(time: String): String {
        // Convert to lowercase to make the checks case-insensitive
        val timeLower = time.lowercase()

        return if (timeLower == "morning") {
            Log.d(TAG, "Matched condition: morning")
            "Send a Good Morning text to a family member \uD83C\uDF05"
        } else if (timeLower == "mid-morning") {
            Log.d(TAG, "Matched condition: mid-morning")
            "Reach out to a colleague with a quick Thank you \uD83D\uDE4F"
        } else if (timeLower == "afternoon") {
            Log.d(TAG, "Matched condition: afternoon")
            "Share a funny meme or interesting link with a friend \uD83D\uDE04"
        } else if (timeLower == "afternoon snack time") {
            Log.d(TAG, "Matched condition: afternoon snack time")
            "Send a quick thinking of you message \uD83D\uDCAD"
        } else if (timeLower == "dinner") {
            Log.d(TAG, "Matched condition: dinner")
            "Call a friend or relative for a 5-minute catch-up \uD83D\uDCDE"
        } else if (timeLower == "after dinner" || timeLower == "night") {
            Log.d(TAG, "Matched condition: after dinner or night")
            "Leave a thoughtful comment on a friend's post \uD83C\uDF19"
        } else {
            // Error handling for empty or unrecognized input
            Log.e(TAG, "Unrecognized or empty input: '\$time'. Triggering error message.")
            "Oops! Try entering Morning, Afternoon, or Dinner to get your spark! \u2728"
        }
    }
}
