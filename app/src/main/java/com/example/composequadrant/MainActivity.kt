package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrantApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(modifier.fillMaxSize()) {
        val boxHeight = maxHeight / 2
        val boxWidth = maxWidth / 2
        // First quadrant
        ComposableInfoCard(
            title = stringResource(R.string.first_title),
            description = stringResource(R.string.first_description),
            backgroundColor = Color(0xFFEADDFF),
            modifier = Modifier
                .size(boxWidth, boxHeight)
                .align(Alignment.TopStart)
        )
        // Second quadrant
        ComposableInfoCard(
            title = stringResource(R.string.second_title),
            description = stringResource(R.string.second_description),
            backgroundColor = Color(0xFFD0BCFF),
            modifier = Modifier
                .size(boxWidth, boxHeight)
                .align(Alignment.TopEnd)
        )
        // Third quadrant
        ComposableInfoCard(
            title = stringResource(R.string.third_title),
            description = stringResource(R.string.third_description),
            backgroundColor = Color(0xFFB69DF8),
            modifier = Modifier
                .size(boxWidth, boxHeight)
                .align(Alignment.BottomStart)
        )
        // Fourth quadrant
        ComposableInfoCard(
            title = stringResource(R.string.fourth_title),
            description = stringResource(R.string.fourth_description),
            backgroundColor = Color(0xFFF6EDFF),
            modifier = Modifier
                .size(boxWidth, boxHeight)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
private fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxHeight()
            .background(backgroundColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        val boxHeight = maxHeight / 2
        val boxWidth = maxWidth / 1
        ComposeText(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp).size(boxWidth, boxHeight).align(Alignment.Center),
        )
        ComposeText(
            text = description,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ComposeText(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Unspecified
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeQuadrantAppPreview() {
    ComposeQuadrantTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ComposeQuadrantApp(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}