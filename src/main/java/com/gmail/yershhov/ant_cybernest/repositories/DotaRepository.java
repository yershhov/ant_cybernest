package com.gmail.yershhov.ant_cybernest.repositories;

import com.gmail.yershhov.ant_cybernest.entities.DotaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DotaRepository extends JpaRepository<DotaOrder, Integer> {
}
