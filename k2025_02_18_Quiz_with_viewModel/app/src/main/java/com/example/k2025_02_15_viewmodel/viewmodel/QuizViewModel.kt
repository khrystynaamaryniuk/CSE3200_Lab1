package com.example.k2025_02_15_viewmodel.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.k2025_02_15_viewmodel.model.BooleanQuestion
import com.example.k2025_02_15_viewmodel.model.QuestionType
import com.example.k2025_02_15_viewmodel.model.booleanQuestionsList

class QuizViewModel : ViewModel() {
    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score

    private val _skippedCount = MutableStateFlow(0)
    val skippedCount: StateFlow<Int> = _skippedCount

    private val _arithmeticCorrect = MutableStateFlow(0)
    val arithmeticCorrect: StateFlow<Int> = _arithmeticCorrect

    private val _spaceCorrect = MutableStateFlow(0)
    val spaceCorrect: StateFlow<Int> = _spaceCorrect

    private val _quantumCorrect = MutableStateFlow(0)
    val quantumCorrect: StateFlow<Int> = _quantumCorrect

    val questions: List<BooleanQuestion> = booleanQuestionsList

    private val answeredQuestions = mutableSetOf<Int>() // Track by ID
    private val skippedQuestions = mutableSetOf<Int>() // Track by ID


    fun checkAnswer(question: BooleanQuestion, userAnswer: Boolean) {
        viewModelScope.launch {
            if (question.id in answeredQuestions || question.id in skippedQuestions) return@launch

            if (question.isTrue == userAnswer) {
                _score.value += 1
                when (question.questionType) {
                    QuestionType.ARITHMETIC -> _arithmeticCorrect.value += 1
                    QuestionType.SPACE -> _spaceCorrect.value += 1
                    QuestionType.QUANTUM -> _quantumCorrect.value += 1
                }
            }

            answeredQuestions.add(question.id)

        }
    }

    fun skipQuestion(question: BooleanQuestion) {
        viewModelScope.launch {
            if (question.id in answeredQuestions || question.id in skippedQuestions) return@launch
            _skippedCount.value += 1
            skippedQuestions.add(question.id)

        }
    }



    fun submitQuiz() {
        viewModelScope.launch {
        }
    }


}
