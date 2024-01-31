package com.example.assignment1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment1.ui.theme.Assignment1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NameCard(
                        name = "Sang Hung Ng",
                        mytitle = "BVC Student",
                        phoneNumber = "123-456-7890",
                        email = "s.ng229@mybvc.ca",
                        department = "Software development Department"
                    )
                }
            }
        }
    }
}

@Composable
fun NameCard(
    name: String,
    mytitle : String,
    phoneNumber: String,
    email: String,
    department: String,
    modifier: Modifier = Modifier
) {

    val bgImage = painterResource(id = R.drawable.bg)
    val textColor = Color(android.graphics.Color.parseColor("#082887"))
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = bgImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.1f)  // Adjust the alpha as needed for transparency
        )
        Column(
            modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Displaying the circular image in the middle of the screen
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(220.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                //.padding(8.dp)
            )


            Spacer(modifier = Modifier.height(16.dp))


            // Displaying the name
            Text(
                text = name,
                fontSize =24.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
                modifier = Modifier
                    .padding(8.dp)

            )
            Text(
                text = mytitle,

                color = textColor,
                modifier = Modifier.padding(8.dp)
            )

            // Displaying a horizontal line

            Divider(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp))
            Row(modifier = Modifier
                .padding(8.dp)) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                    tint = textColor,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    color = textColor,
                    text = phoneNumber,
                )
            }
            Row (modifier = Modifier
                .padding(8.dp)){
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    tint = textColor,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    color = textColor,
                    text = email
                )
            }
            Row (modifier = Modifier
                .padding(8.dp)){
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = textColor,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    color = textColor,
                    text = department
                )
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun NameCardPreview() {
    Assignment1Theme {
        NameCard(
            name = "Your Name",
            mytitle = "BVC Student",
            phoneNumber = "123-456-7890",
            email = "your.email@example.com",
            department = "Your Department"
        )
    }
}