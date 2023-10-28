package com.mta.uiapp.ui

import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mta.uiapp.R.drawable
import com.mta.uiapp.R.string

@RequiresApi(VERSION_CODES.M)
@Composable
fun HomeScreen(
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(horizontal = 16.dp)
  ) {
    GreetingRow(
      name = "Tommy", imgResource = painterResource(id = drawable.ic_wave_round)
    )
    SearchTextField()
    Spacer(modifier = Modifier.height(32.dp))
    UpcomingAppointmentSection()
    Spacer(modifier = Modifier.height(16.dp))
    ConsultNowCard()
    Spacer(modifier = Modifier.height(16.dp))
    DoctorSpecialitiesSection()
    Spacer(modifier = Modifier.height(16.dp))
    TopDoctorsSection()
    Spacer(modifier = Modifier.height(8.dp))
    AvailableDoctorsSection()
    Spacer(modifier = Modifier.height(16.dp))
  }
}

@Composable
fun UpcomingAppointmentSection() {
  Column(modifier = Modifier.fillMaxWidth()) {
    Text(text = "Upcoming Appointment", fontSize = 18.sp)
    Spacer(modifier = Modifier.height(16.dp))
    ElevatedCard(
      elevation = CardDefaults.cardElevation(
        defaultElevation = 3.dp
      ),
      colors = CardDefaults.cardColors(
        containerColor = Color.White,
      ),
      modifier = Modifier
        .fillMaxWidth()
    ) {
      Column(modifier = Modifier.padding(8.dp)) {
        Row(
          modifier = Modifier
            .fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
            Image(
              painter = painterResource(id = drawable.img_doctor), contentDescription = null,
              modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(10.dp)),
              contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
              modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceAround
            ) {
              Text(text = "Dr. Tommy", style = MaterialTheme.typography.titleMedium)
              Spacer(modifier = Modifier.height(8.dp))
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  imageVector = Outlined.DateRange, contentDescription = null,
                  modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Dec 14, 2023", fontSize = 14.sp)
              }
              Spacer(modifier = Modifier.height(8.dp))
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  painter = painterResource(id = drawable.ic_clock), contentDescription = null,
                  modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "08:00 - 09:00 AM", fontSize = 14.sp)
              }

            }
          }
          Box(
            modifier = Modifier
              .border(
                width = 0.2.dp, color = Color(0xFFFFA500), shape = RoundedCornerShape(size = 5.dp)
              )
              .width(63.dp)
              .height(22.dp)
              .background(color = Color(0xFFFEFEE1), shape = RoundedCornerShape(size = 5.dp))
              .padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
          ) {
            Text(
              text = "Upcoming", color = Color(0xFFFFA500), fontSize = 10.sp,
            )
          }
        }
        Spacer(
          modifier = Modifier.height(8.dp)
        )
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Cancel")
          }
          Button(onClick = { /*TODO*/ }) {
            Image(
              painter = painterResource(id = drawable.ic_videocall), contentDescription = null
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Call")
          }
        }
      }
    }

  }
}

@Composable
fun Category(name: String = "General") {
  Box(
    modifier = Modifier
      .border(width = 1.dp, color = Color(0xFF8EB0FF), shape = RoundedCornerShape(size = 7.dp))
      .background(color = Color(0xFFEBF1FF), shape = RoundedCornerShape(size = 7.dp))
      .padding(start = 10.dp, top = 8.dp, end = 10.dp, bottom = 8.dp)
  ) {
    Text(
      text = name
    )
  }
}

@Composable
fun TopDoctorsSection() {
  Column {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Text(text = "Top Doctors", fontSize = 18.sp)
      TextButton(onClick = { /*TODO*/ }) {
        Text(
          text = "View All", color = Color(0xFF5185FE), style = MaterialTheme.typography.titleMedium
        )

      }
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
      modifier = Modifier
        .horizontalScroll(rememberScrollState())
    ) {
      Category(name = "All")
      Spacer(modifier = Modifier.width(8.dp))
      Category(name = "General")
      Spacer(modifier = Modifier.width(8.dp))
      Category(name = "Abuse Recovery")
      Spacer(modifier = Modifier.width(8.dp))
      Category(name = "Eating Disorder")

    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .horizontalScroll(rememberScrollState())

    ) {
      DoctorCard()
      DoctorCard()
    }
  }
}

@Composable
fun AvailableDoctorsSection() {
  Column {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Text(text = "Available Doctors", fontSize = 18.sp)
      TextButton(onClick = { /*TODO*/ }) {
        Text(
          text = "View All", color = Color(0xFF5185FE), style = MaterialTheme.typography.titleMedium
        )

      }
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .horizontalScroll(rememberScrollState())

    ) {
      DoctorCard()
      DoctorCard()
    }
  }
}

@Composable
fun DoctorCard(
  name: String = "Dr. Tommy",
  img: Painter = painterResource(id = drawable.img_doctor),
  modifier: Modifier = Modifier,
) {
  ElevatedCard(
    elevation = CardDefaults.cardElevation(
      defaultElevation = 3.dp
    ),
    colors = CardDefaults.cardColors(
      containerColor = Color.White,
    ),
    modifier = Modifier
      .width(200.dp)
      .padding(3.dp)
  ) {
    Column(
      modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()
    ) {
      Image(
        painter = img,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
          .fillMaxWidth()
          .height(100.dp)
          .clip(shape = RoundedCornerShape(8.dp))
      )
      Row(
        modifier = Modifier
          .padding(vertical = 8.dp)
          .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(text = name, style = MaterialTheme.typography.titleMedium)
        Row(
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(
            imageVector = Icons.Default.Star, contentDescription = "star", tint = Color(0xFF5185FE),
            modifier = Modifier.size(16.dp)
          )
          Text(text = "4.5 (320)", style = MaterialTheme.typography.bodySmall)
        }
      }
      Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = drawable.ic_briefcase), contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Therapist", style = MaterialTheme.typography.titleSmall)
      }
      Spacer(modifier = Modifier.height(8.dp))
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .background(Color(0xFFF9F9FB))
          .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Column {
          Text(text = "Experience", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
          Text(text = "12 years", style = MaterialTheme.typography.titleSmall)
        }
        Column {
          Text(text = "Fees", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
          Text(text = "30000 MMK", style = MaterialTheme.typography.titleSmall)
        }
      }
      Button(modifier = Modifier.fillMaxWidth(), onClick = { }) {
        Text(text = "Make Appointment")
      }
    }
  }
}

@Composable
fun GreetingRow(
  name: String,
  imgResource: Painter,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 32.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween

  ) {
    Text(
      text = "Welcome, $name", style = TextStyle(
      fontSize = 18.sp,
      fontWeight = FontWeight(600),
    )
    )
    Image(
      painter = imgResource,
      contentDescription = "image description",
      contentScale = ContentScale.FillBounds
    )
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField() {
  var text by remember { mutableStateOf(TextFieldValue("")) }
  return OutlinedTextField(
    modifier = Modifier
      .fillMaxWidth(),
    value = text,
    leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon") },
    onValueChange = {
      text = it
    },
    placeholder = { Text(text = stringResource(string.how_are_you_feeling_today)) },
  )
}

@Composable
fun ConsultNowCard() {
  ElevatedCard(
    elevation = CardDefaults.cardElevation(
      defaultElevation = 6.dp
    ), colors = CardDefaults.cardColors(
    containerColor = Color.White,
  ),
    modifier = Modifier
      .fillMaxWidth()
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(16.dp)
    ) {
      Column(modifier = Modifier.weight(1f)) {
        Text(
          text = "Consult With Top Specialists",
          textAlign = TextAlign.Left,
          style = MaterialTheme.typography.titleMedium
        )
        Text(
          text = "Consult with top doctors \n" +
            "over Video calls and Recover\n" +
            "your mental Health",
          textAlign = TextAlign.Left,
          style = MaterialTheme.typography.bodySmall,
          modifier = Modifier.padding(vertical = 8.dp)
        )
        Button(
          onClick = { /*TODO*/ }) {
          Text(text = "Consult Now")
        }
      }
      Image(
        painter = painterResource(id = drawable.img_consultant),
        contentDescription = "Consultant's picture.",
        modifier = Modifier.size(120.dp)
      )
    }
  }
}

@RequiresApi(VERSION_CODES.M)
@Composable
fun DoctorSpecialitiesSection() {
  Column(modifier = Modifier.fillMaxWidth()) {
    Text(text = "Doctor Specialities", fontSize = 18.sp)
    Spacer(modifier = Modifier.height(16.dp))
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween
    )
    {
      RoundIconBoxWithLabel(
        icon = painterResource(id = drawable.ic_workplace), label = "Workplace",
      )
      RoundIconBoxWithLabel(
        icon = painterResource(id = drawable.ic_abuse), label = "Abuse",
      )
      RoundIconBoxWithLabel(
        icon = painterResource(id = drawable.ic_anxiety), label = "Anxiety",
      )
      RoundIconBoxWithLabel(
        icon = painterResource(id = drawable.ic_disorder), label = "Disorder",
      )

    }
    Spacer(modifier = Modifier.height(16.dp))
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween
    )
    {
      RoundIconBoxWithLabel(
        icon = painterResource(id = drawable.ic_depression), label = "Depression",
      )
      RoundIconBoxWithLabel(
        icon = painterResource(id = drawable.ic_youth_support), label = "Youth Support",
      )
      RoundIconBoxWithLabel(
        icon = painterResource(id = drawable.ic_sex_edu), label = "Sex Edu",
      )
      RoundIconBoxWithLabel(
        icon = painterResource(id = drawable.ic_lgbt), label = "LGBTQ+",
      )

    }
  }
}

@RequiresApi(VERSION_CODES.M)
@Composable
fun RoundIconBoxWithLabel(
  icon: Painter,
  label: String,
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Box(
      modifier = Modifier
        .background(color = Color(0xFFEBF1FF), shape = RoundedCornerShape(100.dp))
        .padding(22.dp)
    ) {
      Image(painter = icon, contentDescription = null, modifier = Modifier.size(30.dp))
    }
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = label, style = MaterialTheme.typography.labelMedium, color = Color.Gray)
  }
}