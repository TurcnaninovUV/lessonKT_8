import jdk.nashorn.internal.objects.Global.println
import java.util.Collections.emptyMap

class NoteService {
    private var noteAndCommentMap = emptyMap<Note, Comment>()

    fun addNote(note: Note) {
        noteAndCommentMap.put(note, null)
    }

    fun createComment(comment: Comment) {
        noteAndCommentMap.forEach { key, _ ->
            if (key.availableNote && key.id == comment.noteId)
                noteAndCommentMap.put(key, comment)
        }

    }

    fun deleteNote(note: Note) {
        noteAndCommentMap.forEach { key, _ ->
            if (note.id == key.id) key.availableNote = false
        }
    }

    fun deleteComment(comment: Comment) {
        noteAndCommentMap.forEach { _, value ->
            if (value.noteId == comment.noteId) value.availableСomment = false
        }
    }

    fun restoreComment(comment: Comment) {
        noteAndCommentMap.forEach { _, value ->
            if (value.noteId == comment.noteId) value.availableСomment = true
        }

    }

    fun getNotes() {
        noteAndCommentMap.forEach { key, _ ->
            if (key.availableNote) println(key)
        }
    }

    fun getById(note: Note) {
        noteAndCommentMap.forEach { key, _ ->
            if (key.id == note.id && key.availableNote) println(key)

        }
    }

    fun editComment(comment: Comment) {
        noteAndCommentMap.forEach { key, value ->
            if (value.noteId == comment.noteId && value.availableСomment) noteAndCommentMap.replace(key, comment)

        }
    }
}