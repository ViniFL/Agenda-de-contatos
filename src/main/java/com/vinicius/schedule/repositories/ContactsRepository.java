package com.vinicius.schedule.repositories;

import com.vinicius.schedule.entities.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactsRepository extends JpaRepository<Contacts, Long> {
}
