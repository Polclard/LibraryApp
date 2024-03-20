package org.laboratory.libraryapp.model.events;

import lombok.Getter;
import org.laboratory.libraryapp.model.Book;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class BookCreatedEvent extends ApplicationEvent {

    private LocalDateTime when;
    private Book theBook;

    public BookCreatedEvent(Book source){
        super(source);
        this.when = LocalDateTime.now();
        this.theBook = source;
    }

    public BookCreatedEvent(Book source, LocalDateTime when)
    {
        super(source);
        this.when = when;
        this.theBook = source;
    }

}
