package com.diegusmich.intouch.data.model

/**
 * Represent User data as an immutable model. It implements IModelBuilder.
 *
 * @see com.diegusmich.intouch.data.model.IModelSelfBuilder
 * @since 0.2.3
 */
class User() : DataModel {

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

    var profileImgRef: String? = null
        private set

    var friendsRef: List<String>? = null
        private set

    var preferences: List<String>? = null
        private set

    var socials: Map<String, String>? = null
        private set

    override fun inflateData(docData: (MutableMap<String, Any>)?){
        name = docData?.get("name").toString()
        surname = docData?.get("surname").toString()
        username = docData?.get("username").toString()
        years = (docData?.get("years") as Long?)?.toShort()
        biography = docData?.get("biography").toString()
        profileImgRef = docData?.get("profile_img").toString()
        friendsRef = docData?.get("friends") as List<String>?
        preferences = docData?.get("preferences") as List<String>?
        socials = docData?.get("socials") as Map<String, String>?
    }
}