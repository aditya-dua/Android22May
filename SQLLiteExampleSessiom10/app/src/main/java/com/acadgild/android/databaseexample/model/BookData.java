package com.acadgild.android.databaseexample.model;

/**
 * Created by AdityaDua on 16/06/17.
 */

public class BookData {

    /** 3 Columns in table for this class **/
    /** We need getter & setter becaus ealways make our variables as : private
     * which means no other class or method can access them and hence we provide
     * access to these variables using  methods which getter & setter.
     */
    String bookName;
    String authorName;
    String bookId;
    String id;// PRIMARY KEY OR SERIAL NUMBER TYPE OF KEY

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
