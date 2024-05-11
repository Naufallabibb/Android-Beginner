package com.dicoding.androidbeginner

//import android.os.Parcel
//import android.os.Parcelable

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Ayaka(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable

//{
//    constructor(parcel: Parcel) : this(
//        parcel.readString(),
//        parcel.readString(),
//        parcel.readValue(Int::class.java.classLoader) as? Int
//    )
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(name)
//        parcel.writeString(description)
//        parcel.writeValue(photo)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<Ayaka> {
//        override fun createFromParcel(parcel: Parcel): Ayaka {
//            return Ayaka(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Ayaka?> {
//            return arrayOfNulls(size)
//        }
//    }
//}

