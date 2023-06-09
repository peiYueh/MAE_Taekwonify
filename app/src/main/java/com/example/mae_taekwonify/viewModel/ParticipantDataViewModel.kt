package com.example.mae_taekwondo.viewModel

import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mae_taekwonify.models.Following
import com.example.mae_taekwonify.models.ModifyParticipant
import com.example.mae_taekwonify.models.Participants
import com.google.firebase.firestore.CollectionReference
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

    fun updateParticipantDataToFireStore(
        ContactNumber:String,
        DOB:String,
        EmailAdd:String,
        Name:String,
        Password:String,
        Team:String,
        profilePic:String ,
        Event:String,
        Gender:String,
        id:String,
        context: android.content.Context
    ){
        val db = FirebaseFirestore.getInstance()
        db.collection("Participant").document(id)
            .delete()
            .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error Modifying Participant", e) }
        val dbase: FirebaseFirestore = FirebaseFirestore.getInstance()
        val dbUsers: CollectionReference = dbase.collection("Participant")
        val participantDetails = ModifyParticipant(ContactNumber, DOB, EmailAdd, Name, Password,Team,
            profilePic, Event, Gender, id)
        dbUsers.document(id).set(participantDetails).addOnSuccessListener {
            Toast.makeText(
                context,
                "Modified!",
                Toast.LENGTH_SHORT
            ).show()

        }.addOnFailureListener { e ->

            Toast.makeText(context, "Fail to Modify \n$e", Toast.LENGTH_SHORT).show()
        }
    }

}
////retrieve data

suspend fun getParticipantDataFromFireStore(): MutableList<Participants> {
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


