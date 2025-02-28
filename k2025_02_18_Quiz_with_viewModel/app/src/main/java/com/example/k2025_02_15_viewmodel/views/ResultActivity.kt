package com.example.k2025_02_15_viewmodel.views

import android.content.Intent
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.k2025_02_15_viewmodel.MainActivity
import com.example.k2025_02_15_viewmodel.R
import com.example.k2025_02_15_viewmodel.views.ui.theme.BooleanQuestionsAppTheme

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val score = intent.getIntExtra("score", 0)
        val skippedQuestions = intent.getIntExtra("skippedCount", 0)
        val arithmeticCorrect = intent.getIntExtra("arithmeticCorrect", 0)
        val spaceCorrect = intent.getIntExtra("spaceCorrect", 0)
        val quantumCorrect = intent.getIntExtra("quantumCorrect", 0)

        setContent {
            BooleanQuestionsAppTheme {
                ResultScreen(
                    score = score,
                    skippedQuestions = skippedQuestions,
                    arithmeticCorrect = arithmeticCorrect,
                    spaceCorrect = spaceCorrect,
                    quantumCorrect = quantumCorrect,
                    activity = this
                )
            }
        }
    }
}

@Composable
fun ResultScreen(
    score: Int,
    skippedQuestions: Int,
    arithmeticCorrect: Int,
    spaceCorrect: Int,
    quantumCorrect: Int,
    activity: ComponentActivity
) {
    Column(modifier = Modifier
            .fillMaxSize()
            .background(
            Brush.verticalGradient(
                colors = listOf(Color(0xFF2E7D32), Color(0xFF81C784), Color(0xFFFAFAFA))
            )),
        horizontalAlignment = Alignment.CenterHorizontally,

    )
    {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = stringResource(R.string.quiz_results),
            style = MaterialTheme.typography.displayMedium,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.elevatedCardElevation(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),

            ) {
                Text(text = stringResource(R.string.final_score, score), style = MaterialTheme.typography.bodyMedium )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = stringResource(R.string.skipped_questions, skippedQuestions), style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = stringResource(R.string.categories), style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(8.dp))

                Text( text = stringResource(R.string.arithmetic_correct, arithmeticCorrect),  style = MaterialTheme.typography.bodySmall)
                Text(text = stringResource(R.string.space_correct, spaceCorrect),  style = MaterialTheme.typography.bodySmall)
                Text(text = stringResource(R.string.quantum_correct, quantumCorrect),  style = MaterialTheme.typography.bodySmall)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                activity.startActivity(Intent(activity, MainActivity::class.java))
                activity.finish()
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSurface),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.restart_quiz), color = MaterialTheme.colorScheme.surface)
        }
    }
}
