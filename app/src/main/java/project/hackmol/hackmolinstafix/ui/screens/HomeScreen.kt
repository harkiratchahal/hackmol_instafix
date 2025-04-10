
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import project.hackmol.hackmolinstafix.ui.theme.backgroundColor
import project.hackmol.hackmolinstafix.ui.theme.cardColor
import project.hackmol.hackmolinstafix.ui.theme.primaryColor
import project.hackmol.hackmolinstafix.ui.theme.secondaryColor
import project.hackmol.hackmolinstafix.ui.theme.subtextColor
import project.hackmol.hackmolinstafix.ui.theme.textColor

@Composable
fun InstaFixHomeScreen() {


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)

        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(primaryColor, secondaryColor)
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "InstaFix",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Welcome back, User",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = cardColor),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "You've saved 0 repairs with InstaFix",
                        color = textColor,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Progress indicator
                    LinearProgressIndicator(
                        progress = 0.8f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = primaryColor,
                        trackColor = Color(0xFFE5E7EB)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "80% progress to next eco-badge",
                        color = textColor,
                        fontSize = 14.sp
                    )
                }
            }

            Text(
                text = "What do you need help with today?",
                modifier = Modifier.padding(horizontal = 16.dp),
                color = textColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Services grid - First row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                ServiceCard(
                    title = "AI Diagnosis",
                    description = "Upload a photo for instant diagnosis",
                    icon = { Icons.AIIcon() },
                    primaryColor = primaryColor,
                    modifier = Modifier.weight(1f)
                )

                // Book a Pro Card
                ServiceCard(
                    title = "Book a Pro",
                    description = "Find verified professionals nearby",
                    icon = { Icons.ProIcon() },
                    primaryColor = primaryColor,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Services grid - Second row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Track Repair Card
                ServiceCard(
                    title = "Track Repair",
                    description = "Real-time updates on your repair",
                    icon = { Icons.TrackIcon() },
                    primaryColor = primaryColor,
                    modifier = Modifier.weight(1f)
                )

                // Eco Impact Card
                ServiceCard(
                    title = "Eco Impact",
                    description = "View your carbon footprint savings",
                    icon = { Icons.EcoIcon() },
                    primaryColor = primaryColor,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F3FF)) ,
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Offline Booking Available",
                        color = textColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Request services even without internet access",
                        color = subtextColor,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.height(40.dp)
                    ) {
                        Text("Learn More")
                    }
                }
            }
        }


        BottomNavigationBar(
            primaryColor = primaryColor,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun ServiceCard(
    title: String,
    description: String,
    icon: @Composable () -> Unit,
    primaryColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(160.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = primaryColor.copy(alpha = 0.1f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                color = Color(0xFF1F2937),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = description,
                color = Color(0xFF6B7280),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                lineHeight = 16.sp
            )
        }
    }
}

@Composable
fun BottomNavigationBar(
    primaryColor: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp),
        color = Color.White,
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(
                icon = { Icons.FixIcon(tint = primaryColor) },
                label = "AI Fix",
                isSelected = true,
                primaryColor = primaryColor
            )

            BottomNavItem(
                icon = { Icons.ProIcon(tint = Color.Gray) },
                label = "Book Pro",
                isSelected = false,
                primaryColor = primaryColor
            )

            BottomNavItem(
                icon = { Icons.TrackIcon(tint = Color.Gray) },
                label = "Track",
                isSelected = false,
                primaryColor = primaryColor
            )

            BottomNavItem(
                icon = { Icons.ProfileIcon(tint = Color.Gray) },
                label = "Profile",
                isSelected = false,
                primaryColor = primaryColor
            )
        }
    }
}

@Composable
fun BottomNavItem(
    icon: @Composable () -> Unit,
    label: String,
    isSelected: Boolean,
    primaryColor: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        icon()

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = label,
            color = if (isSelected) primaryColor else Color.Gray,
            fontSize = 12.sp
        )
    }
}

object Icons {
    @Composable
    fun AIIcon(tint: Color = Color(0xFF8B5CF6)) {
        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_add),
            contentDescription = "AI Diagnosis",
            tint = tint
        )
    }

    @Composable
    fun ProIcon(tint: Color = Color(0xFF8B5CF6)) {
        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_manage),
            contentDescription = "Book a Pro",
            tint = tint
        )
    }

    @Composable
    fun TrackIcon(tint: Color = Color(0xFF8B5CF6)) {
        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_mylocation),
            contentDescription = "Track Repair",
            tint = tint
        )
    }

    @Composable
    fun EcoIcon(tint: Color = Color(0xFF8B5CF6)) {
        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_save),
            contentDescription = "Eco Impact",
            tint = tint
        )
    }

    @Composable
    fun FixIcon(tint: Color = Color(0xFF8B5CF6)) {
        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_help),
            contentDescription = "AI Fix",
            tint = tint
        )
    }

    @Composable
    fun ProfileIcon(tint: Color = Color(0xFF8B5CF6)) {
        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_myplaces),
            contentDescription = "Profile",
            tint = tint
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InstaFixHomeScreenPreview() {
    MaterialTheme {
        InstaFixHomeScreen()
    }
}