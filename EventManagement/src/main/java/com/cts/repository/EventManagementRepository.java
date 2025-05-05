package com.cts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.EventManagement;




public interface EventManagementRepository extends JpaRepository<EventManagement,Long> {

    List<EventManagement> findByEventCategory(String category);

	

}
