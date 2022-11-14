package com.example.circleever

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import java.util.*
import kotlin.random.Random.Default.nextInt
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.circleever.NoticeSection.NoticeRepository
import com.example.circleever.NoticeSection.NoticeViewModel
import com.example.circleever.data.Notices
import com.example.circleever.NoticeSection.OnError
import com.example.circleever.NoticeSection.OnSuccess
import com.example.circleever.SocietySection.SocietyListItem
import com.example.circleever.ui.theme.SeaGreen
import com.example.circleever.ui.theme.Warmyellow
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import kotlinx.coroutines.flow.asStateFlow


@Composable
fun NoticeList(noticeViewModel: NoticeViewModel = viewModel(factory = NoticeViewModelFactory(NoticeRepository()))
){

    when (val noticeList =
        noticeViewModel.noticeStateFlow.asStateFlow().collectAsState().value){
        is OnError -> {
            Text(text = "Please try after sometime.")
        }

        is OnSuccess -> {
            val listOfNotices = noticeList.querySnapshot?.toObjects(Notices::class.java)
            listOfNotices?.let {
                LazyColumn(){
                    items(listOfNotices) {
                        NoticeCard(notices = it)
                    }
                }
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun NoticeCard(
//    societyName: String,   // society name - which uploads notice.
//    noticeId: String,
//    noticeTitle: String,
//    noticeDetails: String,
//    noticeURL: String,
//    description: String,
    notices:Notices,
    modifier: Modifier = Modifier,
){
    Card(
       modifier = modifier,

        shape = MaterialTheme.shapes.large
    ){
        Image(painter = painterResource(
            id = R.drawable.sampleicon
        ),
            contentDescription = null,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .fillMaxWidth()
                .aspectRatio(3f / 2f)
            )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = notices.noticeTitle,
            style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = notices.noticeDetails,
                style = MaterialTheme.typography.body2
            )
            Spacer(modifier = Modifier.height(8.dp))
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                mainAxisSpacing = 8.dp,
                mainAxisSize = SizeMode.Wrap
            ){
                AssistChip(
                    onClick = { },
                    colors = AssistChipDefaults.assistChipColors(
                        leadingIconContentColor = SeaGreen
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Like")
                    }
                )
                AssistChip(
                    onClick = { },
                    colors = AssistChipDefaults.assistChipColors(
                        leadingIconContentColor = SeaGreen
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Share,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = "Share with others")
                    }
                )
            }
        }
    }
}


class NoticeViewModelFactory(private val noticeRepository: NoticeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(NoticeViewModel::class.java)) {
            return NoticeViewModel(NoticeRepository()) as T
        }
        throw IllegalStateException()
    }
}