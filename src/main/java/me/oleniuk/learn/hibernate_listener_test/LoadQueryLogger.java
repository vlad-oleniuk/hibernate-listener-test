package me.oleniuk.learn.hibernate_listener_test;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.*;
import org.springframework.stereotype.Service;

@Service
public class LoadQueryLogger implements LoadEventListener, PostLoadEventListener, PreLoadEventListener {

    @Override
    public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException {
        System.out.printf(
                "Load Event. type == %s, id == %s. entity == %s\n", loadType, event.getEntityId(), event.getEntityClassName()
        );
    }

    @Override
    public void onPostLoad(PostLoadEvent event) {
        System.out.printf("Post Load. Entity ==  %s; id == %s\n", event.getEntity(), event.getId());

    }

    @Override
    public void onPreLoad(PreLoadEvent event) {
        System.out.printf("Pre Load. Entity ==  %s; id == %s\n", event.getEntity(), event.getId());
    }
}
