import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import androidx.activity.ComponentActivity   
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier.*
import androidx.compose.ui.platform.LocalContext*
import androidx.compose.ui.unit.dp.*

class MainActivity: ComponentActivity() {
  private lateinit var speechRecognizer: SpeechRecognizer

  override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)

  //initialize speech recorder
speechRecogniser = SpeechRecognizer.createSpeechRecognizer(this)

setContent{
  VoiceToTextApp(speechRecognizer)
}
  }

  override fun onDestroy()
  super.onDestroy()
  speechRecognizer.Destroy()
}
}
