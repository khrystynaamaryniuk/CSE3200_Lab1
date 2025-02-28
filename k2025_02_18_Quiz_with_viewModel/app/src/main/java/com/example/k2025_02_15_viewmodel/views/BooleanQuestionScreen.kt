package com.example.k2025_02_15_viewmodel.views

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.k2025_02_15_viewmodel.model.BooleanQuestion
import com.example.k2025_02_15_viewmodel.viewmodel.QuizViewModel
import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.k2025_02_15_viewmodel.R
import com.example.k2025_02_15_viewmodel.views.ui.theme.*


@Composable
fun BooleanQuestionScreen(context: Context, viewModel: QuizViewModel = viewModel()) {
    val questions = viewModel.questions

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(questions) { question ->
                BooleanQuestionItem(
                    item = question,
                    onAnswer = { answer -> viewModel.checkAnswer(question, answer) },
                    onSkip = { viewModel.skipQuestion(question) }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                viewModel.submitQuiz()
                val intent = Intent(context, ResultActivity::class.java).apply {
                    putExtra("score", viewModel.score.value)
                    putExtra("skippedCount", viewModel.skippedCount.value)
                    putExtra("arithmeticCorrect", viewModel.arithmeticCorrect.value)
                    putExtra("spaceCorrect", viewModel.spaceCorrect.value)
                    putExtra("quantumCorrect", viewModel.quantumCorrect.value)
                }
                context.startActivity(intent)
                 },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.submit_quiz), color = Color(0xFFE8F5E9))
        }
    }
}

@Composable
fun BooleanQuestionItem(
    item: BooleanQuestion,
    onAnswer: (Boolean) -> Unit,
    onSkip: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor =MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = item.text, fontSize = 18.sp, color =MaterialTheme.colorScheme.onSurface)

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { onAnswer(true) }, colors = ButtonDefaults.buttonColors(containerColor =  MediumGreen2 )) {
                    Text(stringResource(R.string.true_button), color = SoftWhite)
                }
                Button(onClick = { onAnswer(false) }, colors = ButtonDefaults.buttonColors(containerColor = DarkGreen)) {
                    Text(stringResource(R.string.false_button),color = SoftWhite)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { onSkip() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.skip_button), color = Color.White)
            }
        }
    }
}

