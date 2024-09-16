package uz.turgunboyevjurabek.motionlayoutincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import uz.turgunboyevjurabek.motionlayoutincompose.ui.theme.MotionLayoutInComposeTheme
import kotlin.time.Duration

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MotionLayoutInComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ConstraintLayout(
//                        modifier = Modifier
//                            .padding(innerPadding)
//                    ) {
//                        var expanded by remember { mutableStateOf(false) }
//                        val progress by animateFloatAsState(
//                            if (expanded) 1f else 0f,
//                            animationSpec = tween(500),
//                            label = ""
//                        )
//                        val (button, profileHeader) = createRefs()
//                        Row(
//                            modifier = Modifier.fillMaxWidth()
//                                .constrainAs(profileHeader) {
//                                top.linkTo(parent.top)
//                                start.linkTo(parent.start)
//                                end.linkTo(parent.end)
//                            }
//                        ) {
//
//                        }
//                        Button(
//                            modifier = Modifier
//                                .constrainAs(button) {
//                                    top.linkTo(profileHeader.bottom)
//                                    end.linkTo(parent.end)
//                                    start.linkTo(parent.start)
//                                },
//                            onClick = {
//                                expanded = !expanded
//                            }
//                        ) {
//
//                        }
//                    }


                    RecipeDetail()

                }
            }
        }
    }
}