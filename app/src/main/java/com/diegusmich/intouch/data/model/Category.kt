package com.diegusmich.intouch.data.model

/**
 * Represent Post data as an immutable model. It implements IModelBuilder.
 *
 * @see com.diegusmich.intouch.data.model.IModelSelfBuilder
 * @since 0.2.6
 */
class Category() : DataModel{

    var name: String? = null
    private set

    var color : String? = null
    private set

    override fun inflateData(docData: MutableMap<String, Any>?){
        name = docData?.get("name").toString()
        color = docData?.get("color").toString()
    }
}