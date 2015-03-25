package grails.sample.plugin.database.migration

class Book {
    String title
    Author author

    static belongsTo = Author
}
