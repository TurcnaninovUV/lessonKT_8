class Comment(
    val noteId: Int,
    val ownerId: Int? = null,
    val message: String? = null,
    val guid: Int? = null,
    var availableСomment: Boolean = true
)  {

}