package com.diegusmich.intouch.data.model

/**
 * Define an object for data model to build with Firebase document snapshot.
 *
 * @since 0.2.2
 */
interface DataModel {

    /**
     * Parse data and inflate all values to model.
     */
    fun inflateData(documentSnapshot : (MutableMap<String, Any>)?)

}