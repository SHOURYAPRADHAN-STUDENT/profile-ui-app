package com.example.profileuiapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Surface(
        color = Color(0xFF181818),
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            TopAppBar(
                title = { Text("Profile", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    FilledTonalButton(
                        onClick = { /* Handle support */ },
                        colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color(0xFF232323))
                    ) {
                        Icon(Icons.Default.SupportAgent, contentDescription = "Support", tint = Color(0xFFAAAAAA))
                        Text("support", color = Color(0xFFAAAAAA), fontSize = 15.sp)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF181818))
            )

            // Avatar, Name, Member Since, Edit button, Phone, Email
            Row(
                Modifier
                    .padding(20.dp, 10.dp, 16.dp, 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.profile_shourya), // Place your image as profile_shourya.png in drawable
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(18.dp))
                Column {
                    Text("shourya pradhan", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(0xFFCCCCCC))
                    Text("member since Dec, 2020", color = Color(0xFFAAAAAA), fontSize = 16.sp)
                    Spacer(Modifier.height(4.dp))
                    Text("Phone: 7982075019n", color = Color(0xFFBBBBBB), fontSize = 15.sp)
                    Text("Email: shourya.cutee@gmail.com", color = Color(0xFFBBBBBB), fontSize = 15.sp)
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = { /* edit */ }) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color(0xFFAAAAAA))
                }
            }

            // Garage Card
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF222222)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    Modifier.padding(18.dp, 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF282828)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_car),
                            contentDescription = "Garage",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(Modifier.width(13.dp))
                    Column {
                        Text("get to know your vehicles, inside out", color = Color(0xFFAAAAAA), fontSize = 13.sp)
                        Text("CRED garage →", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                }
            }

            // Info rows
            ProfileInfoRow("credit score", "757", highlight = true)
            ProfileInfoRow("lifetime cashback", "₹3")
            ProfileInfoRow("bank balance", "check")

            // Rewards & Benefits
            SectionHeader("YOUR REWARDS & BENEFITS")
            ProfileInfoRow("cashback balance", "₹0")
            ProfileInfoRow("coins", "26,46,583")
            ProfileInfoRow("win upto Rs 1000", "refer and earn", showArrow = false, subLabel = true)

            // Transactions & Support
            SectionHeader("TRANSACTIONS & SUPPORT")
            Text(
                "all transactions",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 17.sp,
                modifier = Modifier.padding(start = 16.dp, top = 10.dp)
            )
        }
    }
}

@Composable
fun ProfileInfoRow(label: String, value: String, highlight: Boolean = false, showArrow: Boolean = true, subLabel: Boolean = false) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                label,
                color = if (highlight) Color(0xFFAAAAAA) else Color(0xFFAAAAAA),
                fontWeight = if (highlight) FontWeight.Medium else FontWeight.Normal,
                fontSize = 16.sp
            )
            if (subLabel) Text(value, color = Color(0xFFBBBBBB), fontSize = 13.sp)
        }
        Spacer(Modifier.weight(1f))
        if (!subLabel)
            Text(
                value,
                color = if (highlight) Color(0xFF36D47C) else Color.White,
                fontWeight = if (highlight) FontWeight.Bold else FontWeight.Medium,
                fontSize = 17.sp
            )
        if (showArrow) Icon(
            painterResource(R.drawable.ic_arrow_right),
            contentDescription = "Arrow",
            tint = Color(0xFF999999),
            modifier = Modifier.size(20.dp).padding(start = 6.dp)
        )
    }
    Divider(color = Color(0xFF232323), thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp))
}

@Composable
fun SectionHeader(text: String) {
    Text(
        text,
        color = Color(0xFF888888),
        fontWeight = FontWeight.Bold,
        letterSpacing = 2.sp,
        fontSize = 13.sp,
        modifier = Modifier.padding(start = 16.dp, top = 30.dp, bottom = 10.dp)
    )
}