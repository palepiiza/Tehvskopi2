package com.example.tehvskopi2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.tehvskopi2.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {
    val questions = arrayOf("apa yang kamu minum saat kerja ?",
                            "apa yang kamu minum saat kamu relax ?",
                            "apa yang kamu minum saat kamu nonton film ?")

    var coffe_score = 0
    var teh_score = 0
    var current_q = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Quiz.."

        val binding: FragmentQuizBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_quiz, container, false)

        binding.questionText.text = questions[current_q]
        binding.kopiBtn.setOnClickListener {
            coffe_score++
            nextQuestion(binding)
        }
        binding.tehBtn.setOnClickListener {
            teh_score++
            nextQuestion(binding)
        }

        return binding.root
    }

    fun nextQuestion(binding: FragmentQuizBinding) {
        current_q++

        if (current_q < questions.size) {
            binding.questionText.text = questions[current_q]
            Toast.makeText(context, "berhasil! coffe " + coffe_score + " / teh" + teh_score, Toast.LENGTH_SHORT).show()
        }
        else{
            var result = ""
            if (coffe_score >= 1 && teh_score >= 1) {
                result = "kamu suka dua duanya"
            } else if (coffe_score < 1) {
                result = "kamu pecinta kopi"
            } else {
                result = "kamu pecinta teh"
            }
            view?.findNavController()?.navigate(QuizFragmentDirections.actionQuizFragmentToFinishFragment(result))
        }


    }
    }