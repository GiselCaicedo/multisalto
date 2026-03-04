package com.example.redscate.generated.set1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.redscate.R

@Composable
fun BadgesSet1(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 90.dp)
            .requiredHeight(height = 60.dp)
            .clip(shape = RoundedCornerShape(5.dp))
    ) {
            Image(
                painter = painterResource(id = R.drawable.propiedad1large),
                contentDescription = "Propiedad 1=Large",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 20.dp, y = 20.dp)
                    .requiredSize(size = 20.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .background(color = AppColors.color_RDS_alert)
            )
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 54.dp, y = 24.dp)
                    .requiredSize(size = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = CircleShape)
                        .background(color = AppColors.color_RDS_alert)
                )
            }
    }
}
