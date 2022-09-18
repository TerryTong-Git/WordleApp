package com.example.wordleproject


import com.example.wordleproject.FourLetterWordList
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        guess

        val wordToGuess = FourLetterWordList.getRandomFourLetterWord()

        var button = findViewById<Button>(R.id.guess_button)
        var reset = findViewById<Button>(R.id.reset)
        var answer = findViewById<TextView>(R.id.right_answer)
        var entries = findViewById<TextView>(R.id.guess_text)
        var attempts = findViewById<TextView>(R.id.result)


        var display_right = StringBuilder()
        var display_left = StringBuilder()
        answer.text = wordToGuess
        answer.visibility = View.GONE
        var counter = 0
        button.setOnClickListener {



            val input = findViewById<EditText>(R.id.user_input)
            val strValue = input.text.toString().uppercase()

            counter ++
            var returned = checkGuess(strValue, wordToGuess)
            display_right.append("\nGuess\n")
            display_right.append("Check")
            entries.text = display_right

            display_left.append("\n"+ strValue + "\n")
            display_left.append(returned.toString())

            attempts.text = display_left

            if (counter >= 3) {
                Toast.makeText(it.context , "Enough turns", Toast.LENGTH_SHORT).show()
                answer.visibility = View.VISIBLE
                button.isClickable = false
                reset.visibility=View.VISIBLE
                reset.setOnClickListener {
                    counter = 0
                    button.setOnClickListener {
                        button.isClickable = true
                        counter ++
                        var returned = checkGuess(strValue, wordToGuess)
                        entries.text = strValue
                        attempts.text = returned
                    }
                }
                reset.visibility = View.INVISIBLE

            }

        }

        }
    }


/**
 * Parameters / Fields:
 *   wordToGuess : String - the target word the user is trying to guess
 *   guess : String - what the user entered as their guess
 *
 * Returns a String of 'O', '+', and 'X', where:
 *   'O' represents the right letter in the right place
 *   '+' represents the right letter in the wrong place
 *   'X' represents a letter not in the target word
 */
private fun checkGuess(guess: String, wordToGuess: String) : String {
    var result = ""
    for (i in 0..3) {
        if (guess[i] == wordToGuess[i]) {
            result += "O"
        }
        else if (guess[i] in wordToGuess) {
            result += "+"
        }
        else {
            result += "X"
        }
    }
    return result
}