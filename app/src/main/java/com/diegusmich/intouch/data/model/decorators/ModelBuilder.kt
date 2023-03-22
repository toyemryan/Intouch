package com.diegusmich.intouch.data.model.decorators

import com.diegusmich.intouch.data.model.IModelSelfBuilder
import com.google.firebase.firestore.DocumentSnapshot


/**
 * Inline extension function that convert Firebase DocumentSnapshot in Model
 * adopting the Decorator Pattern
 *
 * @since 0.2.2
 */
inline fun <reified T: IModelSelfBuilder<T>> DocumentSnapshot.toModel() : T?{
    val _model = T::class.java.newInstance()

    return _model.fromData(this?.data)
}