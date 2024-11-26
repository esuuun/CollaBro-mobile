package com.example.collabro.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.collabro.R
import com.example.collabro.ui.theme.Background
import com.example.collabro.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Scaffold(
        content = { contentPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Background)
                    .padding(contentPadding)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically // Align back icon and search bar vertically
                ) {
                    // Back icon
                    Icon(
                        painter = painterResource(id = R.drawable.backicon),
                        contentDescription = "Back",
                        tint = Primary,
                        modifier = Modifier.size(24.dp) // Adjust the icon size
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Add spacing between the back icon and search bar

                    // Search bar
                    androidx.compose.material3.SearchBar(
                        modifier = Modifier.weight(1f), // Let the SearchBar take up remaining space
                        query = text,
                        onQueryChange = {
                            text = it
                        },
                        onSearch = {
                            active = false
                        },
                        active = active,
                        onActiveChange = {
                            active = it
                        },
                        placeholder = {
                            Text(text = "Find your next opportunities...")
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.search),
                                contentDescription = "Search icon",
                                tint = Primary
                            )
                        },
                        colors = SearchBarDefaults.colors(
                            containerColor = Color.White,
                            dividerColor = Color.Gray,
                            inputFieldColors = SearchBarDefaults.inputFieldColors(
                                focusedTextColor = Color.Black,
                                cursorColor = Primary
                            )
                        )
                    ) { }
                }
            }
        }
    )
}
