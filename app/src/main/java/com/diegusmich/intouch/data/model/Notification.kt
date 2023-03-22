package com.diegusmich.intouch.data.model


//TODO: Definire la classe Notification
/**
 * Represent Notification data as an immutable model. It implements IModelBuilder.
 *
 * @see com.diegusmich.intouch.data.model.IModelSelfBuilder
 * @since 0.2.6
 */
class Notification : IModelSelfBuilder<Notification> {

    override fun fromData(docData: MutableMap<String, Any>?): Notification {
        TODO("Implementare fromData()")

    }
}