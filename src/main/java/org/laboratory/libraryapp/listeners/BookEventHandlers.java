package org.laboratory.libraryapp.listeners;

import lombok.RequiredArgsConstructor;
import org.laboratory.libraryapp.model.events.BookCreatedEvent;
import org.laboratory.libraryapp.model.events.BookDeletedEvent;
import org.laboratory.libraryapp.model.events.BookUpdatedEvent;
import org.laboratory.libraryapp.service.BookService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookEventHandlers {
    private final BookService bookService;

    @EventListener
    public void onBookCreate(BookCreatedEvent event)
    {
        System.out.println("Book with name: " + event.getTheBook().getName() + " is created at: " + event.getWhen());
    }
    @EventListener
    public void onBoonDelete(BookDeletedEvent event)
    {
        System.out.println("Book with name: " + event.getTheBook().getName() + " is deleted at: " + event.getWhen());
    }
    @EventListener
    public void onBookUpdate(BookUpdatedEvent event)
    {
        System.out.println("Book with id: " + event.getTheBook().getId() + " is updated at with new name: " + event.getTheBook().getName() + " at " + event.getWhen());
    }

}

