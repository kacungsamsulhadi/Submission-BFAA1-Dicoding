package com.example.myrecyclerview

import android.content.Context
import android.content.res.TypedArray

object dummy {

    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataPhoto: TypedArray

    private fun prepare(context: Context){
        dataUsername = context.resources.getStringArray(R.array.username)
        dataName = context.resources.getStringArray(R.array.name)
        dataLocation = context.resources.getStringArray(R.array.location)
        dataCompany = context.resources.getStringArray(R.array.company)
        dataRepository = context.resources.getStringArray(R.array.repository)
        dataFollower = context.resources.getStringArray(R.array.followers)
        dataFollowing = context.resources.getStringArray(R.array.following)
        dataPhoto = context.resources.obtainTypedArray(R.array.img)
    }
    fun listOfUser(context: Context):ArrayList<Hero>{
        val listOfHero = ArrayList<Hero>()
        prepare(context)

        for (position in dataUsername.indices){
            val hero = Hero(
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataCompany[position],
                dataRepository[position],
                dataFollower[position],
                dataFollowing[position],
                dataPhoto.getResourceId(position, 0),
            )
            listOfHero.add(hero)
        }
        return listOfHero
    }
}