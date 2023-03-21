package com.diegusmich.intouch.data.model

/**
 * Represent User data as an immutable model. It implements IModelBuilder.
 *
 * @see com.diegusmich.intouch.data.model.IModelBuilder
 * @since 0.2.2
 */
class User : IModelBuilder<User> {

    var name : String? = null
    private set

    var surname : String? = null
    private set

    var username : String? = null
    private set

    var years : Short? = null
    private set

    var biography : String? = null
    private set

    var profile_img : String? = null
    private set

    var friends : Array<String>? = null
    private set

    var preferences : Array<String>? = null
    private set

    var socials : MutableMap<String, String>? = null
    private set

    override fun fromData(docData : (MutableMap<String, Any>)?): User {
        name = docData?.get("name").toString()
        surname = docData?.get("surname").toString()

        return this
    }

}