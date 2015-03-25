package grails.sample.plugin.database.migration

class Author {
    String name

    static hasMany = [books: Book]
}
