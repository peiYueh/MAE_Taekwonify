package com.example.mae_taekwondo.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mae_taekwonify.models.Participants
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class ParticipantDataViewModel : ViewModel (){

    val state = mutableStateOf(mutableListOf(Participants()))

    init {
        getParticipantData()
    }

    private fun getParticipantData(){
        viewModelScope.launch {
            state.value = getParticipantDataFromFireStore()
        }
    }


}


//retrieve data
suspend fun getParticipantDataFromFireStore(): ArrayList<Participants> {

    val db = FirebaseFirestore.getInstance()
    var data = Participants()
    var dataList: ArrayList<Participants> = ArrayList()


    try {

        db.collection("Participant").get().await().map {
            val result = it.toObject(Participants::class.java)
            data = result
            dataList.add(data)
        }
    } catch (e: FirebaseFirestoreException) {
        Log.d("error", "getDataFromFireStore: $e")
    }
    return dataList
}

