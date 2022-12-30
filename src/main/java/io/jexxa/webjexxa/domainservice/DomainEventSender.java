package io.jexxa.webjexxa.domainservice;


import io.jexxa.addend.applicationcore.InfrastructureService;
import io.jexxa.webjexxa.domain.book.BookSoldOut;

@InfrastructureService
public interface DomainEventSender
{
    void publish(BookSoldOut domainEvent);
}
