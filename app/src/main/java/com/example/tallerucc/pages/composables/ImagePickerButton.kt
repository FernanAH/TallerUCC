package com.example.tallerucc.pages.composables

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tallerucc.ui.theme.DarkBlue
import com.example.tallerucc.ui.theme.LightBlue
import com.example.tallerucc.ui.theme.Typography
import com.example.tallerucc.ui.theme.White

@Composable
fun ImagePickerButton(onImageSelected: (Uri?) -> Unit) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        onImageSelected(uri)
    }

    Button(
        modifier = Modifier
            .padding(horizontal = 16.dp),
//            .border(
//                width = 1.dp,
//                color = LightBlue,
//                shape = RoundedCornerShape(25.dp)
//            ),
        onClick = { launcher.launch("image/*") },
        colors = ButtonDefaults.buttonColors(
            containerColor = LightBlue,
        )
    ) {
        Text(
            text = "Seleccionar una o varias imágenes",
            style = Typography.titleSmall,
//            color = LightBlue
        )
    }
}
