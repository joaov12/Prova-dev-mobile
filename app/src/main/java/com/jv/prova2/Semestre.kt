package com.jv.prova2

import android.os.Parcel
import android.os.Parcelable

data class Semestre(val ano: Int, val semestre: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(ano)
        parcel.writeString(semestre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Semestre> {
        override fun createFromParcel(parcel: Parcel): Semestre {
            return Semestre(parcel)
        }

        override fun newArray(size: Int): Array<Semestre?> {
            return arrayOfNulls(size)
        }
    }
}
