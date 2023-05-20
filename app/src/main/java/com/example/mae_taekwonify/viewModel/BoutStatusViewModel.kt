package com.example.mae_taekwonify.viewModel
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mae_taekwonify.models.BoutStatus
import com.example.mae_taekwonify.models.Followed
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class BoutStatusViewModel : ViewModel() {
    val state = mutableStateOf(mutableListOf(BoutStatus()))
    init {
        getBoutData()
    }

    private fun getBoutData(){
        viewModelScope.launch {
            state.value = getBoutDataFromFireStore()
        }
    }
}

suspend fun getBoutDataFromFireStore(): MutableList<BoutStatus> {

    val db = FirebaseFirestore.getInstance()
    var data = BoutStatus()
    var dataList: ArrayList<BoutStatus> = ArrayList()


    try {

        db.collection("SparringBout").get().await().map {
            val result = it.toObject(BoutStatus::class.java)
            data = result
            dataList.add(data)
        }
    } catch (e: FirebaseFirestoreException) {
        Log.d("error", "getDataFromFireStore: $e")
    }
    return dataList
}