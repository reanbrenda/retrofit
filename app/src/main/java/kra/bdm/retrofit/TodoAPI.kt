package kra.bdm.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TodoAPI {
    @GET("/todos")
   /* fun gettodos(@Query("key")Key:String):Response<List<Todo>>*//*
    @POST("/create")
    fun createtodos(@Body TODO :Todo):Response<Createtodo>*/
    suspend fun gettodos():Response<List<Todo>>
}