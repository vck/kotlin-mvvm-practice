package com.speda.HelloCompose

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.speda.HelloCompose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()
        setContent {
            HelloComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Box(modifier = Modifier.fillMaxSize()){
                        Text(
                            text = viewModel.counter.value.toString(),
                            modifier = Modifier.align(Alignment.Center),
                            style = MaterialTheme.typography.h4
                        )

                        if(viewModel.counter.value % 2 == 0){
                            Text(
                                text = "EVEN NUMBER",
                                modifier = Modifier.align(Alignment.TopStart).padding(40.dp),
                                style = MaterialTheme.typography.h4
                            )
                        }

                        if(viewModel.counter.value % 2 != 0){
                            Text(
                                text = "ODD NUMBER",
                                modifier = Modifier.align(Alignment.TopStart).padding(40.dp),
                                style = MaterialTheme.typography.h4
                            )
                        }


                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )
                        Button(
                            onClick = { viewModel.onAdd() } ,
                            modifier = Modifier.align(Alignment.BottomCenter).padding(40.dp))
                        {
                            Text(text = "Counter ++")
                        }


                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )

                        Button(
                            onClick = { viewModel.onReset() } ,
                            modifier = Modifier.align(Alignment.BottomCenter).padding(10.dp))
                        {
                            Text(text = "Reset")
                        }

                        Spacer(
                            modifier = Modifier.height(16.dp)
                        )

                        Button(
                            onClick = { viewModel.onRandomNumber() } ,
                            modifier = Modifier.align(Alignment.BottomCenter).padding(10.dp))
                        {
                            Text(text = "Random")
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Screen() {
    Box(modifier = Modifier.fillMaxSize()){
        Text(
            text = "" ,
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.h4
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Button(
            onClick = { /*TODO*/ } ,
            modifier = Modifier.align(Alignment.BottomCenter).padding(40.dp))
        {
                Text(text = "Counter ++")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloComposeTheme {
        Screen()
    }
}