package com.diegusmich.intouch.data.model.decorators

import com.diegusmich.intouch.data.model.DataModel
import com.google.firebase.firestore.DocumentSnapshot

/**
 * Extension function that convert Firebase DocumentSnapshot in Model
 * adopting the Decorator Pattern
 *
 * @since 0.2.2
 */
fun <T : DataModel> DocumentSnapshot.toModel(clazz : Class<T>) : T{
    val modelClazz = clazz.newInstance()
    modelClazz.inflateData(this?.data)

    return modelClazz
}