@Composable 
fun VoiceToTextApp(speechRecognizer: SpeechRecognizer) {
  val context = LocalContext.current
  
  var recognizedText by remember{ mutableStateOf{""}}
  var isListening by remember{ mutableStateOf(false)}
  var permissionGranted by remember{ mutableStateOf(false)}
  
 val permissionLauncher = rememberLauncherForActivityResult(
   contract = activityResultContracts.RequestPermission(), 
   onResult = { granted -> permissionGranted = granted )
   )

//request permission of first composition
   LaunchedEffect(Unit) {
     permissionGranted = ContextCompat.checkSelfPermission(
   context, Manifest.permission.RECORD_AUDIO
   ) ==  PackageManager.PERMISSION_GRANTED

     if (permissionGranted) {
       permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
     }
   }

   //setup recognition listener

   DisposableEffect(speechRecognizer) {
     val listener = object : RecognitionListener{
       override fun onReadyForSpeech(params: Bundle?) {}
       override fun onBeginningOfSpeech() {}
       override fun onRMSChanged(rmsdB: Float) {
       override fun onBufferReceived(buffer: ByteArray?) {}
       override fun onEndOfSpeech() {
         isListening = false
       }
       override fun onError(error: Int) {
         isListening = false
         recognizedText = "Error recognizing speech. Kindly, try again! Thank you!"
       }

       override fun onResults(results: Bundle?) {
         val matches = results?.getStringArraylist(SpeechRecognizer.RESULTS_RECOGNITION)
         if (!matches.isNullorEmpty()) {
           recognizedText = matches[0]
         }
         is Listening = false
       }
       override fun onPartialResults(partialResults: Bundle?) {
         val matches = partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
           if (!matches.isNullorEmpty()) {
             recognizedText = matches[0]
           }
       }
       override fun onEvent(eventType: Int, params: Bundle?) {}
       }
       speechRecognizer.setRecognitionListener(listener)
       
      onDispose{
     speechRecognizer.setRecognitionListener(null)
      }
     }

     Scaffold {
      topbar = {
        TopAppbar(title = { Text ("Voice To Text App")})
      }
      ) { padding ->
        Column(
          modifier = Modifier
            .padding(padding)
            .padding(16.dp)
           fillMaxSize(),
          verticalArrangement = Arrangement.Top
          ) {
       Text (
        text = if
       style = MaterialTheme.typography.h6,
      modifier = Modifier
      .fillMaxWidth()
      .weight(1f)
      .padding(8.dp)
      )

      Button(
        onClick = {
          if (!permissionGranted)
             permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
             return@Button
        }

if (!isListening) {
  val intent
  putExtra(








         
