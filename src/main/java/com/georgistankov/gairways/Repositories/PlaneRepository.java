package com.georgistankov.gairways.Repositories;

import com.georgistankov.gairways.Models.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface PlaneRepository extends JpaRepository<Plane, UUID> {
}
