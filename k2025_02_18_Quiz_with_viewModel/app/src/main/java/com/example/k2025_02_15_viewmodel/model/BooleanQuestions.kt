package com.example.k2025_02_15_viewmodel.model

enum class QuestionType {
    ARITHMETIC,
    SPACE,
    QUANTUM
}

data class BooleanQuestion(val id: Int, val text: String, val isTrue: Boolean, val questionType: QuestionType)

val booleanQuestionsList = listOf<BooleanQuestion> (
    BooleanQuestion(1,"2+2 = 7", false, QuestionType.ARITHMETIC),
    BooleanQuestion(2, "10 divided by 2 is 4", false,QuestionType.ARITHMETIC),
    BooleanQuestion(3,"The number 7 is a prime number", true, QuestionType.ARITHMETIC),
    BooleanQuestion(4,"Multiplying any number by 1 gives the same number", true, QuestionType.ARITHMETIC),
    BooleanQuestion(5,"A square has four equal sides", true, QuestionType.ARITHMETIC),
    BooleanQuestion(6,"Saturn is the largest planet", false,QuestionType.SPACE),
    BooleanQuestion(7,"Jupiter is the largest planet", true, QuestionType.SPACE),
    BooleanQuestion(8,"The Earth is the third planet from the sun", true, QuestionType.SPACE),
    BooleanQuestion(9,"The Earth is between venus and mars", true, QuestionType.SPACE),
    BooleanQuestion(10,"The closest planet to the Sun is Mercury", true, QuestionType.SPACE),
    BooleanQuestion(11,"Electrons are larger than atoms", false, QuestionType.QUANTUM),
    BooleanQuestion(12,"Light can behave as both a particle and a wave", true, QuestionType.QUANTUM),
    BooleanQuestion(13,"Electrons have a negative charge", true, QuestionType.QUANTUM),
    BooleanQuestion(14,"In our solar system, uranus is the farthest planet from our sun", false, QuestionType.QUANTUM),
    BooleanQuestion(15,"The smallest unit of light is called a photon", true, QuestionType.QUANTUM),
   )
