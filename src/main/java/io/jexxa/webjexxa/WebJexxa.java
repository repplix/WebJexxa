package io.jexxa.webjexxa;

import io.jexxa.addend.applicationcore.ApplicationService;
import io.jexxa.addend.applicationcore.DomainService;
import io.jexxa.core.JexxaMain;
import io.jexxa.infrastructure.drivingadapter.rest.RESTfulRPCAdapter;

public final class WebJexxa
{
    public static void main(String[] args)
    {
        var jexxaMain = new JexxaMain(WebJexxa.class);

        jexxaMain
                // Bootstrap all classes annotated with @DomainService. In this application this causes to get
                // the latest books via ReferenceLibrary and forward DomainEvents to a message bus via DomainEventService
                .bootstrapAnnotation(DomainService.class)

                //bind all application services and the bounded context to driving adapters
                .bind(RESTfulRPCAdapter.class).toAnnotation(ApplicationService.class)
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())

                //run the application
                .run();
    }

    private WebJexxa()
    {
        //Private constructor since we only offer main
    }

}
