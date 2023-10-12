package com.example.alweb29.learnelectriccircuitsapp.test

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.alweb29.learnelectriccircuitsapp.R
import com.example.alweb29.learnelectriccircuitsapp.test.chapters.Chapter
import com.example.alweb29.learnelectriccircuitsapp.test.chapters.ChapterOne
import com.example.alweb29.learnelectriccircuitsapp.test.chapters.ChapterThree
import com.example.alweb29.learnelectriccircuitsapp.test.chapters.ChapterTwo
import com.example.alweb29.learnelectriccircuitsapp.test.questionTypes.MultiAnswerQuestion
import java.util.Objects

class TestQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var progressBar : ProgressBar? = null
    private var tvProgressBar : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null
    private var btnSubmit : Button? = null

    private var questionSet : Chapter? = null

    private var currentQuestion : MultiAnswerQuestion? = null
    private var currentQuestionIndex : Int = -1
    private var selectedQuestions = arrayOf(0,0,0,0)
    private var correctAnswerScore : Int = 0
    private var mSelectedQuestionPosition : Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_question)

        progressBar = findViewById(R.id.progress_bar)
        tvProgressBar = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        when (intent.getStringExtra(Constants.CHAPTER)){
            "1"->{
                questionSet = ChapterOne
            }
            "2"->{
                questionSet = ChapterTwo
            }
            "3"->{
                questionSet = ChapterThree
            }else ->{
                Log.e("error", "Chapter not loaded")
            }
        }

        progressBar?.max = questionSet!!.getTotalNumOfQuestions()
        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionsView()
        setQuestionContent()

    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1, it)
        }
        tvOptionThree?.let {
            options.add(2, it)
        }
        tvOptionFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.basic_choice_tile_selected
            )
        }
        selectedQuestions = arrayOf(0,0,0,0)
    }
    
    private fun setQuestionContent(){

        currentQuestion = questionSet!!.getNextQuestion(currentQuestionIndex)
        tvQuestion?.text = currentQuestion?.question

        progressBar?.progress = currentQuestionIndex+2
        tvProgressBar?.text = "${currentQuestionIndex+2}/${questionSet!!.getTotalNumOfQuestions()}"

        ivImage?.setImageResource(currentQuestion!!.image)
        tvOptionOne?.text = currentQuestion!!.optionOne
        tvOptionTwo?.text = currentQuestion!!.optionTwo
        tvOptionThree?.text = currentQuestion!!.optionThree
        tvOptionFour?.text = currentQuestion!!.optionFour

        if (currentQuestionIndex == questionSet!!.getTotalNumOfQuestions()){
            btnSubmit?.text ="Finish"
        }else{
            btnSubmit?.text ="Next"
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one->{
                if (mSelectedQuestionPosition!=0){
                    tvOptionOne?.let {
                        if (selectedQuestions[0] == 0){
                            selectedOptionView(it, 0)
                        }else{
                            unselectOptionView(it, 0)
                        }
                        mSelectedQuestionPosition=1
                    }
                }
            }

            R.id.tv_option_two->{
                if (mSelectedQuestionPosition!=0){
                    tvOptionTwo?.let {
                        if (selectedQuestions[1] == 0){
                            selectedOptionView(it, 1)
                        }else{
                            unselectOptionView(it, 1)
                        }
                        mSelectedQuestionPosition=1
                    }
                }
            }

            R.id.tv_option_three->{
                if (mSelectedQuestionPosition!=0){

                    tvOptionThree?.let {
                        if (selectedQuestions[2] == 0){
                            selectedOptionView(it, 2)
                        }else{
                            unselectOptionView(it, 2)
                        }
                        mSelectedQuestionPosition=1
                    }
                }
            }

            R.id.tv_option_four->{
                if (mSelectedQuestionPosition!=0){

                    tvOptionFour?.let {
                        if (selectedQuestions[3] == 0){
                            selectedOptionView(it, 3)
                        }else{
                            unselectOptionView(it, 3)
                        }
                        mSelectedQuestionPosition=1
                    }
                }
            }

            R.id.btn_submit->{
                if(mSelectedQuestionPosition == 0){
                    currentQuestionIndex++

                    when{
                        currentQuestionIndex + 2 <= questionSet!!.getTotalNumOfQuestions()->{
                            setQuestion()
                            mSelectedQuestionPosition=1
                        }
                        else ->{
                            val intent = Intent(this, TestResultActivity::class.java)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswerScore)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionSet?.getTotalNumOfQuestions())
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    if (!currentQuestion!!.correctAnswers.contentEquals(selectedQuestions)){
                        defaultOptionsView()
                    }else{
                        correctAnswerScore++
                    }
                    highlightCorrectAnswers()

                    if (currentQuestionIndex + 1 == questionSet!!.getTotalNumOfQuestions()){
                        btnSubmit?.text = "Finish"
                    }else{
                        btnSubmit?.text = "Go To Next Question"
                    }

                    mSelectedQuestionPosition = 0
                }
            }
        }
    }

    private fun highlightCorrectAnswers() {
        val answers: Array<Int>? = currentQuestion?.correctAnswers
        //TODO fix highlighting with more than one answer - only one highlights when more should
        for (answer in answers!!){
            if (answer!=0){
                highlightCorrectAnswer(answers.indexOf(answer)+1, R.drawable.basic_choice_tile)
            }
        }
    }


    private fun highlightCorrectAnswer(answer:Int, drawableView: Int){
        when(answer) {
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
                tvOptionOne?.setTypeface(tvOptionOne?.typeface, Typeface.BOLD)
            }

            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
                tvOptionTwo?.setTypeface(tvOptionTwo?.typeface, Typeface.BOLD)
            }

            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
                tvOptionThree?.setTypeface(tvOptionThree?.typeface, Typeface.BOLD)
            }

            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
                tvOptionFour?.setTypeface(tvOptionFour?.typeface, Typeface.BOLD)
            }
        }
    }


    private fun selectedOptionView(tv:TextView, selectedOptionNumber: Int){

        selectedQuestions[selectedOptionNumber] = 1
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.basic_choice_tile
        )
    }
    private fun unselectOptionView(tv:TextView, selectedOptionNumber: Int){
        selectedQuestions[selectedOptionNumber] = 0
        tv.setTypeface(tv.typeface, Typeface.NORMAL)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.basic_choice_tile_selected
        )
    }


}