package org.laboratory.libraryapp.model.events;

import lombok.Getter;
import org.laboratory.libraryapp.model.Book;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class BookDeletedEvent extends ApplicationEvent {

    private LocalDateTime when;
    private Book theBook;

    public BookDeletedEvent(Book source) {
        super(source);
        this.when = LocalDateTime.now();
        this.theBook = source;
    }

    public BookDeletedEvent(Book source, LocalDateTime when) {
        super(source);
        this.when = when;
        this.theBook = source;
    }
}
