class BlogDao {

    val userDao = new UserDao()

    val blogPosts = hashMapOf(
            0 to Blog(title = "Sao is posting", body = "Just posting", id = 0, user: userDao.findById(0)),
            1 to Blog(title = "Ade is posting", body = "Just posting", id = 1, user: userDao.findById(1)),
            2 to Blog(title = "Sunday is posting", body = "Just posting", id = 2, user: userDao.findById(2)),
            3 to Blog(title = "Oye is posting", body = "Just posting", id = 3, user: userDao.findById(3)),

    )

    var lastId: AtomicInteger = AtomicInteger(blogPosts.size - 1)

    fun save(title: String, body: String, user: User) {
        val id = lastId.incrementAndGet()
        blogPosts.put(id, Blog(title = title, body = body, id = id, user: User))
    }

    fun findById(id: Int): Blog? {
        return blogPosts[id]
    }

    fun findByUserId(userId: Int): Blog? {
        val user = User.findByI
        return blogPosts.values.find { it.user == user }
    }

    fun update(id: Int, name: String, email: String) {
        users.put(id, User(name = name, email = email, id = id))
    }

    fun delete(id: Int) {
        users.remove(id)
    }

}