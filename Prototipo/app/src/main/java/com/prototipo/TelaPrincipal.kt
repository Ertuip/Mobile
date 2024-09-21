package com.prototipo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.prototipo.screens.Configs
import com.prototipo.screens.Inicio

data class BottomNavItens(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@Composable
fun TelaPrincipal() {
    val BottomListItens = listOf(
        BottomNavItens("Início", Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home),
        BottomNavItens("Configurações", Icons.Filled.Settings, unselectedIcon = Icons.Outlined.Settings)
    )
    var selectedItens by remember {
        mutableStateOf(0)
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            NavigationBar {
                BottomListItens.forEachIndexed {index, itens ->
                    NavigationBarItem(
                        selected = selectedItens == index,
                        onClick = {
                            selectedItens = index
                        },
                        label = {
                            Text(
                                itens.label,
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = itens.selectedIcon,
                                contentDescription = "Botão de ${itens.label}"
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(Modifier.padding(innerPadding), selectedItens)
    }
}

@Composable
fun ContentScreen(modifier: Modifier, selectedIndex: Int) {
    when(selectedIndex) {
        0 -> Inicio()
        1 -> Configs()
    }
}