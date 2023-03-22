package com.diegusmich.intouch.data.model

/**
 * Represent Post data as an immutable model. It implements IModelBuilder.
 *
 * @see com.diegusmich.intouch.data.model.IModelSelfBuilder
 * @since 0.2.5
 */
class Post() : IModelSelfBuilder<Post>{
    var authorRef: String? = null
        private set

    var description: String? = null
        private set

    var eventRef: String? = null
        private set

    var likes: List<String>? = null
        private set

    var albumImgRef: List<String>? = null
        private set

    override fun fromData(docData: MutableMap<String, Any>?): Post {
        authorRef = docData?.get("author").toString()
        description = docData?.get("description").toString()
        eventRef = docData?.get("event").toString()
        likes = docData?.get("likes") as List<String>?
        albumImgRef = docData?.get("album") as List<String>?

        return this
    }
}