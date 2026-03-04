package com.example.redscate.generated.set0

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.redscate.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppBarSet0(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = AppColors.color_RDS_background,
            scrolledContainerColor = AppColors.color_RDS_background,
            titleContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        windowInsets = WindowInsets(0, 0, 0, 0),
        title = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.requiredWidth(width = 233.dp)
            ) {
                Text(
                    text = "SECCION",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 1.36.em,
                    style = AppTypes.type_RDS_Title_Section,
                    modifier = Modifier
                        .requiredWidth(width = 126.dp)
                        .requiredHeight(height = 44.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }
        },
        actions = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .requiredSize(size = 50.dp)
                    .clip(shape = RoundedCornerShape(50.dp))
                    .background(color = AppColors.color_RDS_surface_container)
                    .border(
                        border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                        shape = RoundedCornerShape(50.dp)
                    )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.gc0_icon),
                            contentDescription = "Icon",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        },
        modifier = modifier
    )
}
