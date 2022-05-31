package com.gmail.yershhov.ant_cybernest.repositories;

import com.gmail.yershhov.ant_cybernest.entities.CsOrder;
import com.gmail.yershhov.ant_cybernest.entities.DotaOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CsRepository extends JpaRepository<CsOrder, Integer> {

}
