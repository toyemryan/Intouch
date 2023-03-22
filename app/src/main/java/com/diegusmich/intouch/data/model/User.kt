package com.diegusmich.intouch.data.model

/**
 * Represent User data as an immutable model. It implements IModelBuilder.
 *
 * @see com.diegusmich.intouch.data.model.IModelBuilder
 * @since 0.2.2
 */
class User : IModelSelfBuilder<User> {

    var name: String? = null
        private set

    var surname: String? = null
        private set

    var username: String? = null
        private set

    var years: Short? = null
        private set

    var biography: String? = null
        private set

    var profile_img: String? = null
        private set

    var friends: List<String>? = null
        private set

    var preferences: List<String>? = null
        private set

    var socials: MutableMap<String, String>? = null
        private set

    override fun fromData(docData: (MutableMap<String, Any>)?): User {

        name = docData?.get("name").toString()
        surname = docData?.get("surname").toString()
        years = docData?.get("year") as Short?
        biography = docData?.get("biography").toString()
        profile_img = docData?.get("profile_img").toString()
        friends = docData?.get("friends") as List<String>
        preferences = docData?.get("preferences") as List<String>?
        socials = docData?.get("socials") as MutableMap<String, String>?

        return this
    }
}