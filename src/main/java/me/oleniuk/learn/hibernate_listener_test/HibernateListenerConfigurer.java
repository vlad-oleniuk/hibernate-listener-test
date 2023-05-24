package me.oleniuk.learn.hibernate_listener_test;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class HibernateListenerConfigurer implements ApplicationListener<ContextRefreshedEvent> {

    private final EntityManagerFactory entityManagerFactory;

    private final LoadQueryLogger loadQueryLogger;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        System.out.println("!!!!!!Context refreshed");

        SessionFactoryImpl sessionFactory = entityManagerFactory.unwrap(SessionFactoryImpl.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);

        registry.appendListeners(EventType.LOAD, loadQueryLogger);

        registry.appendListeners(EventType.PRE_LOAD, loadQueryLogger);

        registry.getEventListenerGroup(EventType.POST_LOAD).appendListener(loadQueryLogger);
    }
}
