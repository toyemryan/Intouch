package com.diegusmich.intouch.data.model

/**
 * Implements the model inflater method to parse Firebase data.
 * It's implemented by model classes.
 *
 * @since 0.2.2
 */
interface IModelSelfBuilder<T> {

    /**
     * Parse data and inflate all values to model.
     */
    fun fromData(docData : (MutableMap<String, Any>)?) : T

}