package com.diegusmich.intouch.data.model

/**
 * Represent Post data as an immutable model. It implements IModelBuilder.
 *
 * @see com.diegusmich.intouch.data.model.IModelSelfBuilder
 * @since 0.2.6
 */
class Category() : IModelSelfBuilder<Category>{

    var name: String? = null
    private set

    var color : String? = null
    private set

    override fun fromData(docData: MutableMap<String, Any>?): Category {
        name = docData?.get("name").toString()
        color = docData?.get("color").toString()

        return this
    }
}