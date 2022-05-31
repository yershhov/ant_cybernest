package com.gmail.yershhov.ant_cybernest.repositories;

import com.gmail.yershhov.ant_cybernest.entities.DotaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DotaRepository extends JpaRepository<DotaOrder, Integer> {
}
