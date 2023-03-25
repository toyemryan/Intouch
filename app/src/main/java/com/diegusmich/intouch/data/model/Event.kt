package com.diegusmich.intouch.data.model

//TODO: Definire classe Event

/**
 * Represent Event data as an immutable model. It implements IModelBuilder.
 *
 * @see com.diegusmich.intouch.data.model.IModelSelfBuilder
 * @since 0.2.6
 */
class Event : DataModel{

    override fun inflateData(docData: MutableMap<String, Any>?){
        TODO("Implementare fromData")
    }

}