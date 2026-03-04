import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

@Composable
fun Buttons(modifier: Modifier = Modifier) {
    Surface(
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(1.dp, Color(0xff8a38f5)),
        modifier = modifier
                .clip(shape = RoundedCornerShape(5.dp))
        ) {
        Box(
            modifier = Modifier
                        .requiredWidth(width = 1609.dp)
                        .requiredHeight(height = 500.dp)
            ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = (-289.5).dp,
                                                y = (-205).dp)
                                .requiredWidth(width = 140.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_surface_container)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = (-684.5).dp,
                                                y = (-205).dp)
                                .requiredWidth(width = 140.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_surface_container)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline_inactive),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container_inactive,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = 105.5.dp,
                                                y = (-205).dp)
                                .requiredWidth(width = 140.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_alert)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = 500.5.dp,
                                                y = (-205).dp)
                                .requiredWidth(width = 140.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_success)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = 155.5.dp,
                                                y = (-105).dp)
                                .requiredWidth(width = 240.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_alert)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = 550.5.dp,
                                                y = (-105).dp)
                                .requiredWidth(width = 240.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_success)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = (-239.5).dp,
                                                y = (-105).dp)
                                .requiredWidth(width = 240.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_surface_container)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = (-634.5).dp,
                                                y = (-105).dp)
                                .requiredWidth(width = 240.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_surface_container)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline_inactive),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container_inactive,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = 192.dp,
                                                y = (-5).dp)
                                .requiredWidth(width = 313.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_alert)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = 587.dp,
                                                y = (-5).dp)
                                .requiredWidth(width = 313.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_success)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = (-203).dp,
                                                y = (-5).dp)
                                .requiredWidth(width = 313.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_surface_container)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = (-598).dp,
                                                y = (-5).dp)
                                .requiredWidth(width = 313.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_surface_container)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline_inactive),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container_inactive,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = 208.dp,
                                                y = 95.dp)
                                .requiredWidth(width = 345.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_alert)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = 603.dp,
                                                y = 95.dp)
                                .requiredWidth(width = 345.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_success)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = (-187).dp,
                                                y = 95.dp)
                                .requiredWidth(width = 345.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_surface_container)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = (-582).dp,
                                                y = 95.dp)
                                .requiredWidth(width = 345.dp)
                                .requiredHeight(height = 50.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_surface_container)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline_inactive),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container_inactive,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = (-187).dp,
                                                y = 200.dp)
                                .requiredWidth(width = 345.dp)
                                .requiredHeight(height = 60.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_surface_container)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = (-582).dp,
                                                y = 200.dp)
                                .requiredWidth(width = 345.dp)
                                .requiredHeight(height = 60.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_surface_container)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline_inactive),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container_inactive,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = 208.dp,
                                                y = 200.dp)
                                .requiredWidth(width = 345.dp)
                                .requiredHeight(height = 60.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_alert)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(x = 603.dp,
                                                y = 200.dp)
                                .requiredWidth(width = 345.dp)
                                .requiredHeight(height = 60.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = AppColors.color_RDS_success)
                                .border(border = BorderStroke(2.dp, AppColors.color_RDS_outline),
                                                shape = RoundedCornerShape(10.dp))
                ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                                        .fillMaxSize()
                    ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                        verticalAlignment = Alignment.CenterVertically
                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon),
                            contentDescription = "Icon",
                            modifier = Modifier
                                                        .requiredSize(size = 30.dp))
                        Text(
                            text = "LABEL",
                            color = AppColors.color_RDS_on_surface_container,
                            lineHeight = 1.4.em,
                            style = AppTypes.type_RDS_Label_Button,
                            modifier = Modifier
                                                        .wrapContentHeight(align = Alignment.CenterVertically))
                        }
                    }
                }
            }
        }
 }

@Preview(widthDp = 1609, heightDp = 500)
@Composable
private fun ButtonsPreview() {
    Buttons(Modifier)
 }