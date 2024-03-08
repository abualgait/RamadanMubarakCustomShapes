package com.muhammadsayed.ramadanmubark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muhammadsayed.ramadanmubark.ui.theme.RamadanMubarkTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RamadanMubarkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RamadanMubark()
                }
            }
        }
    }
}


@Composable
fun RamadanMubark(image: Int = R.drawable.ramadan_1) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val random = Random.Default

    val imageBrush =
        ShaderBrush(
            ImageShader(
                ImageBitmap.imageResource(id = image)
            )
        )

    Box {
        repeat(10) {

            val YOffsetDp = random.nextDp(10, 200)
            val latternSize = random.nextDp(20, 40)



            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Canvas(modifier = Modifier.width(1.dp)) {
                    drawLine(
                        color = Color.Black,
                        start = Offset((screenWidth / 10).times(it).toPx(), 0f),
                        end = Offset((screenWidth / 10).times(it).toPx(), YOffsetDp.toPx()),
                        strokeWidth = 1.dp.toPx()
                    )
                }

                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .offset((screenWidth / 10).times(it), YOffsetDp)
                        .size(latternSize)
                        .clip(IslamicPatternShape()),
                    contentScale = ContentScale.Crop
                )
            }

        }


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier,
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(IslamicPatternShape()),
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(id = R.drawable.ramadan_1),
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(-45f)
                        .size(350.dp)
                        .clip(NewMoonShape())
                        .rotate(45f), contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "RAMADAN MUBARK", fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold, letterSpacing = 5.sp, style = TextStyle(
                    brush = imageBrush,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 36.sp
                )

            )

        }
    }

}

private fun Random.nextDp(min: Int, max: Int): Dp {
    val randomValue = this.nextInt(min, max)
    return randomValue.dp
}

@Preview(showBackground = true)
@Composable
fun RamadanMubarkPreview() {
    RamadanMubarkTheme {
        RamadanMubark()
    }
}

