package kra.bdm.retrofit


import com.google.gson.annotations.SerializedName

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)