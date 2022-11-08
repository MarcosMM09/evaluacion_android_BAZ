package com.example.myapplication.retroData

import com.google.gson.annotations.SerializedName


data class retroDataRequest(@SerializedName("page") var page:Int, @SerializedName("data") var respuesta: List<String>) {

}