package com.alex.eventsourcingspring;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountEventsRepository extends JpaRepository<AccountEvent, Integer> {
}
