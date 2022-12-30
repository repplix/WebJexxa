package io.jexxa.webjexxa.domainservice;


import io.jexxa.addend.applicationcore.DomainEventHandler;
import io.jexxa.addend.applicationcore.DomainService;
import io.jexxa.webjexxa.domain.DomainEventPublisher;
import io.jexxa.webjexxa.domain.book.BookSoldOut;

@DomainService
public class DomainEventService
{
    private final DomainEventSender domainEventSender;
    @SuppressWarnings("unused")
    public DomainEventService(DomainEventSender domainEventSender)
    {
        this.domainEventSender = domainEventSender;
        DomainEventPublisher.subscribe(BookSoldOut.class, this::handleEvent);
    }

    @DomainEventHandler
    public void handleEvent(BookSoldOut domainEvent)
    {
        domainEventSender.publish(domainEvent);
    }
}
