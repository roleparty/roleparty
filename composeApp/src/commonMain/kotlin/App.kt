import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import app.roleparty.service.createCampaign
import app.roleparty.service.rolepartyHttpClient
import kotlinx.coroutines.launch

@Composable
fun App() {
    RolepartyTheme {
        Scaffold {
            val coroutineScope = rememberCoroutineScope()
            var response by remember { mutableStateOf("") }

            coroutineScope.launch {
                response = rolepartyHttpClient.createCampaign()
            }

            Text(response)
        }
    }
}