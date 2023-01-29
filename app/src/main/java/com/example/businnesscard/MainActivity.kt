package com.example.businnesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businnesscard.ui.theme.BusinnessCardTheme
import com.example.businnesscard.ui.theme.Shapes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinnessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}

@Composable
fun Contacts(text: String, icon: Painter = painterResource(R.drawable.email)) {
    val radius: Shape = RoundedCornerShape(16.dp)
    Row(
        Modifier
            .fillMaxWidth()
            .shadow(10.dp, shape = radius)
            .background(
                Color.White
            )
            .clip(radius)
            .padding(top = 16.dp, bottom = 16.dp, start = 32.dp, end = 32.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = "icon",
            modifier = Modifier.width(32.dp))
        Spacer(Modifier.width(52.dp))
        Text(text, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun Profile(name: String, title: String){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.profil),
            contentDescription = "image profile",
            modifier = Modifier.clip(RoundedCornerShape(100))
        )
        Spacer(Modifier.height(10.dp))
        Text(name, style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        ))
        Text(title, textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinnessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Column(Modifier.padding(16.dp)) {
                    Profile("Septa Alfauzan", "Software Engiiner")
                }
                Spacer(Modifier.height(20.dp))
                Column(Modifier.padding(16.dp)) {
                    Contacts(text = "alfauzansepta@gmail.com", painterResource(R.drawable.email))
                    Spacer(Modifier.height(16.dp))
                    Contacts(text = "082132351498", painterResource(R.drawable.phone))
                    Spacer(Modifier.height(16.dp))
                    Contacts(text = "@septaalfauzan", painterResource(R.drawable.twitter))
                }
            }
        }
    }
}