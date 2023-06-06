package com.example.mae_taekwonify.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mae_taekwondo.viewModel.getParticipantDataFromFireStore
import com.example.mae_taekwonify.models.Chat
import com.example.mae_taekwonify.models.Participants
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ChatViewModel : ViewModel() {

    val state = mutableStateOf(mutableListOf(Chat()))

    init {
        getChatData()
    }

    private fun getChatData(){
        viewModelScope.launch {
            state.value = getChatDataFromFireStore()
        }
    }

}

//retrieve data
suspend fun getChatDataFromFireStore(): MutableList<Chat> {

    val db = FirebaseFirestore.getInstance()
    var data = Chat()
    var dataList: ArrayList<Chat> = ArrayList()


    try {

        db.collection("ChatSupport").get().await().map {
            val result = it.toObject(Chat::class.java)
            data = result
            dataList.add(0,data)
        }
    } catch (e: FirebaseFirestoreException) {
        Log.d("error", "getDataFromFireStore: $e")
    }
    return dataList
}
