import java.util.concurrent.atomic.AtomicInteger

class BlogDao {

    val userDao =  UserDao()

    val blogPosts = hashMapOf(
            0 to Blog(title = "Sao is posting", body = "Just posting", id = 0, user: userDao.findById(0)),
            1 to Blog(title = "Ade is posting", body = "Just posting", id = 1, user: userDao.findById(1)),
            2 to Blog(title = "Sunday is posting", body = "Just posting", id = 2, user: userDao.findById(2)),
            3 to Blog(title = "Oye is posting", body = "Just posting", id = 3, user: userDao.findById(3))

    )

    var lastId: AtomicInteger = AtomicInteger(blogPosts.size - 1)

    fun save(title: String, body: String, user: User) {
        val id = lastId.incrementAndGet()
        blogPosts.put(id, Blog(title = title, body = body, id = id, user: User))
    }

    fun findBlogById(id: Int): Blog? {
        return blogPosts[id]
    }

    fun findBlogByUserId(userId: Int): Blog? {
        return blogPosts.values.find { it.user == userDao.findById(userId) }
    }

    fun findBlogsByUser(userId: Int): List<Blog> {
        val blogList: List<Blog>
        blogPosts.values.findAll { it.user == userDao.findById(userId) }
    }

    fun updateBlog(id: Int, title: String, body: String, userId: Int) {
        blogPosts.put(id, User(name = name, email = email, id = id))
    }

    fun delete(id: Int) {
        blogPosts.remove(id)
    }

}