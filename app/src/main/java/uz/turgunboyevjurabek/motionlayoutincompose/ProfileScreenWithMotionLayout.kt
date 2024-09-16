@file:OptIn(ExperimentalMotionApi::class)

package uz.turgunboyevjurabek.motionlayoutincompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout

@Composable
fun ProfileScreenWithMotionLayout() {
    // Scroll state to track scrolling position
    val scrollState = rememberLazyListState()

    // Calculate progress based on scrolling
    val progress by remember {
        derivedStateOf {
            val firstVisibleItemIndex = scrollState.firstVisibleItemIndex
            val scrollOffset = scrollState.firstVisibleItemScrollOffset
            // Adjust the total scroll range (e.g., 1000 can be fine-tuned)
            val totalScrollRange = 1000f

            (firstVisibleItemIndex * 100f + scrollOffset) / totalScrollRange
        }
    }

    // MotionLayout with start and end constraint sets
    MotionLayout(
        start = ConstraintSet {
            val profilePic = createRefFor("profilePic")
            constrain(profilePic) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                width = Dimension.value(100.dp)
                height = Dimension.value(100.dp)
            }
        },
        end = ConstraintSet {
            val profilePic = createRefFor("profilePic")
            constrain(profilePic) {
                top.linkTo(parent.top, margin = 48.dp)
                start.linkTo(parent.start)
                width = Dimension.value(50.dp)
                height = Dimension.value(50.dp)
            }
        },
        progress = progress.coerceIn(0f, 1f), // Ensure progress stays within 0 to 1
        modifier = Modifier.fillMaxSize()
    ) {
        // Profile Picture component inside MotionLayout
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .layoutId("profilePic")
        )
    }

    // LazyColumn for scrolling content
    LazyColumn(
        state = scrollState,
        modifier = Modifier.fillMaxSize()
    ) {
        items(100) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Gray)
            )
        }
    }
}
