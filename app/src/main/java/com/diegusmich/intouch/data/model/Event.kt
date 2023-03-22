package com.diegusmich.intouch.data.model

//TODO: Definire classe Event

/**
 * Represent Event data as an immutable model. It implements IModelBuilder.
 *
 * @see com.diegusmich.intouch.data.model.IModelSelfBuilder
 * @since 0.2.6
 */
class Event : IModelSelfBuilder<Event>{

    override fun fromData(docData: MutableMap<String, Any>?): Event {
        TODO("Implementare fromData")
    }

}