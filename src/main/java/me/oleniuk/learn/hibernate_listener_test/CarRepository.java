package me.oleniuk.learn.hibernate_listener_test;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
