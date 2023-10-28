package com.mta.uiapp.ui

import android.graphics.drawable.Icon
import android.os.Build.VERSION_CODES
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mta.uiapp.R

@RequiresApi(VERSION_CODES.M)
@Composable
fun DoctorDetailScreen() {
  Column(
    modifier = Modifier
      .fillMaxSize()
  ) {
    TopColumn()
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
      Spacer(modifier = Modifier.height(16.dp))
      AboutDoctor(
        text = "Dr. Sandy is a top specialist at London Bridge Hospital at London.She has achieved several awards and recognition for is contribution and service in her own field. She is available for private consultation. "
      )
      Spacer(modifier = Modifier.height(16.dp))
      DateSection()
      Spacer(modifier = Modifier.height(16.dp))
      TimeSlot()
      Spacer(modifier = Modifier.height(16.dp))
      PatientDetail()
      Spacer(modifier = Modifier.height(16.dp))
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientDetail() {
  Column {
    Text(text = "Full name")
    Spacer(modifier = Modifier.height(8.dp))
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
      modifier = Modifier
        .fillMaxWidth(),
      value = text,
      onValueChange = {
        text = it
      },
      placeholder = { Text(text = "Enter your name") },
    )
    Spacer(modifier = Modifier.height(16.dp))
    Age()
    Spacer(modifier = Modifier.height(16.dp))
    Gender()
    Spacer(modifier = Modifier.height(16.dp))
    Text(text = "Write your problem")
    Spacer(modifier = Modifier.height(8.dp))
    var body by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
      modifier = Modifier
        .fillMaxWidth()
        .height(150.dp),
      value = body,
      onValueChange = {
        body = it
      },
      singleLine = false,
      maxLines = 5,
      placeholder = { Text(text = "Write your problem", fontSize = 15.sp) }
    )
    Spacer(modifier = Modifier.height(8.dp))
    Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
      Text("Book Appointment")
    }
  }
}

@Composable
fun TimeSlot() {
  Column {
    Text(text = "Time Slot")
    Spacer(modifier = Modifier.height(8.dp))
    OptionsDialog(optionText = "8:00 AM - 9:00 AM")
  }
}

@Composable
fun Gender() {
  Column {
    Text(text = "Gender")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
      Button(onClick = { /*TODO*/ }) {
        Text(text = "Male")
      }
      Spacer(modifier = Modifier.width(8.dp))
      OutlinedButton(onClick = { /*TODO*/ }) {
        Text(text = "Female")
      }
    }

  }
}

@Composable
fun Age() {
  Column {
    Text(text = "Age")
    Spacer(modifier = Modifier.height(8.dp))
    OptionsDialog(optionText = "26 - 30")
  }
}

@Composable
fun OptionsDialog(optionText: String) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .background(
        color = Color(0x146B779A),
        shape = RoundedCornerShape(size = 10.dp)
      )
      .padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text(text = optionText)
    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
  }
}

@Composable
fun DateSection() {
  Column(modifier = Modifier.fillMaxWidth()) {
    Text(text = "Date")
    Spacer(modifier = Modifier.height(8.dp))
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
      DateItem(modifier = Modifier.weight(1f), day = "MON", date = 11)
      Spacer(modifier = Modifier.width(4.dp))
      DateItem(modifier = Modifier.weight(1f), day = "TUE", date = 11, selected = true)
      Spacer(modifier = Modifier.width(4.dp))
      DateItem(modifier = Modifier.weight(1f), day = "WED", date = 11)
      Spacer(modifier = Modifier.width(4.dp))
      DateItem(modifier = Modifier.weight(1f), day = "THU", date = 11)
      Spacer(modifier = Modifier.width(4.dp))
      DateItem(modifier = Modifier.weight(1f), day = "FRI", date = 11)
    }
  }
}

@Composable
fun DateItem(
  modifier: Modifier = Modifier,
  day: String,
  date: Int,
  selected: Boolean = false,
) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
      .border(
        width = 1.dp, color = if (selected) Color(0xFF5185FE) else Color.Gray,
        shape = RoundedCornerShape(size = 15.dp)
      )
      .padding(horizontal = 8.dp, vertical = 24.dp)
  ) {
    Text(text = day, color = Color.Gray)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "$date")
  }
}

@Composable
fun AboutDoctor(text: String) {
  Column {
    Text(text = "About Doctor", style = MaterialTheme.typography.titleMedium)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = text, fontSize = 14.sp)
  }
}

@RequiresApi(VERSION_CODES.M)
@Composable
fun ItemCard(
  label: String,
  value: String,
  color: Color,
  icon: Painter,
  modifier: Modifier = Modifier,
) {
  ElevatedCard(
    colors = CardDefaults.cardColors(
      containerColor = Color.White,
    ),
    modifier = modifier
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp, top = 0.dp, 16.dp, 16.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Box(
        modifier = Modifier
          .width(49.dp)
          .height(63.dp)
          .clip(RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp))
          .background(
            color = color,
          )
      ) {
        Image(
          painter = icon,
          contentDescription = null,
          modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 8.dp)
        )
      }
      Spacer(modifier = Modifier.height(8.dp))
      Text(text = value, fontSize = 14.sp)
      Text(text = label, fontSize = 12.sp, color = Color.Gray)
    }
  }
}

@RequiresApi(VERSION_CODES.M)
@Composable
fun TopColumn() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
      .background(Color(0xFFF7F7F7))
      .padding(16.dp)
  ) {
    IconButton(onClick = {

    }) {
      Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
    }
    Column(
      modifier = Modifier.fillMaxWidth(),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Image(
        modifier = Modifier
          .border(
            width = 2.dp, color = Color(0xFFDEDEDE), shape = RoundedCornerShape(size = 90.dp)
          )
          .padding(2.dp)
          .width(90.dp)
          .height(90.dp)
          .background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(size = 90.dp))
          .clip(CircleShape),
        painter = painterResource(id = R.drawable.img_doctor),
        contentDescription = "image description",
        contentScale = ContentScale.Crop,
      )
      Spacer(modifier = Modifier.height(8.dp))
      Text(text = "Dr. Phyo", style = MaterialTheme.typography.titleLarge)
      Text(text = "Therapist", style = MaterialTheme.typography.titleSmall)
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      ItemCard(
        modifier = Modifier.weight(1f),
        label = "Experience",
        value = "10 Yrs",
        color = Color(0xFFFDF1F3),
        icon = painterResource(
          id = R.drawable.icon_experience
        )
      )
      Spacer(modifier = Modifier.width(8.dp))
      ItemCard(
        modifier = Modifier.weight(1f),
        label = "Ratings",
        value = "4.5",
        color = Color(0xFFD6E3FF),
        icon = painterResource(
          id = R.drawable.ic_outlined_star
        )
      )
      Spacer(modifier = Modifier.width(8.dp))
      ItemCard(
        modifier = Modifier.weight(1f),
        label = "Fees",
        value = "3000 K",
        color = Color(0xFFFEF6EC),
        icon = painterResource(
          id = R.drawable.ic_fee
        )
      )
    }
  }
}