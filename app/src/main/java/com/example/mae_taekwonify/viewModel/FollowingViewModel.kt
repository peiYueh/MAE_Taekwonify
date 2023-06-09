package com.example.mae_taekwonify.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mae_taekwonify.models.Followed
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class FollowingViewModel : ViewModel(){
    val state = mutableStateOf(mutableListOf(Followed()))
    init {
        getParticipantData()
    }
    private fun getParticipantData(){
        viewModelScope.launch {
            state.value = getFollowingDataFromFireStore()
        }
    }
}
//retrieve data
suspend fun getFollowingDataFromFireStore(): ArrayList<Followed> {
    val db = FirebaseFirestore.getInstance()
    var data = Followed()
    var dataList: ArrayList<Followed> = ArrayList()
    try {
        db.collection("FollowingFollowers").get().await().map {
            val result = it.toObject(Followed::class.java)
            data = result
            dataList.add(data)
        }
    } catch (e: FirebaseFirestoreException) {
        Log.d("error", "getDataFromFireStore: $e")
    }
    return dataList
}
