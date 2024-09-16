@file:OptIn(ExperimentalMotionApi::class, ExperimentalFoundationApi::class)

package uz.turgunboyevjurabek.motionlayoutincompose

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
@SuppressLint("RememberReturnType")
@Composable
fun ProfileHeader(
//    modifier: Modifier = Modifier,
//    progress: Float // Progress qiymatini uzatish
) {
    val context = LocalContext.current

    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }


    val draggedDownAnchorTop = with(LocalDensity.current) { 200.dp.toPx() }
    val anchors = DraggableAnchors {
        AnchoredDraggableCardState.DRAGGED_DOWN at draggedDownAnchorTop
        AnchoredDraggableCardState.DRAGGED_UP at 0f
    }
    val density = LocalDensity.current
    val anchoredDraggableState = remember {
        AnchoredDraggableState(
            initialValue = AnchoredDraggableCardState.DRAGGED_DOWN,
            anchors = anchors,
            positionalThreshold = { distance: Float -> distance * 0.5f },
            velocityThreshold = { with(density) { 100.dp.toPx() } },
            animationSpec = tween(),
        )
    }

    val offset = if (anchoredDraggableState.offset.isNaN()) 0f else anchoredDraggableState.offset
    val progress = (1 - (offset / draggedDownAnchorTop)).coerceIn(0f, 1f)

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        val properties = motionProperties(id = "profile_pic")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .layoutId("box")
        )
        Image(
            painter = painterResource(id = R.drawable.jetpack_compose),
            contentDescription = null,
            modifier = Modifier
                .layoutId("profile_pic")
                .clip(CircleShape)
                .border(
                    2.dp,
                    properties.value.color("background"),
                    shape = CircleShape
                )
        )
        Text(
            text = "Jetpack Compose",
            fontSize = 24.sp,
            color = properties.value.color("background"),
            modifier = Modifier
                .layoutId("username")
        )
    }
}
