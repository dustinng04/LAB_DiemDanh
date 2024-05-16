package com.lab.diemdanh.Repository;

import com.lab.diemdanh.Entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISlotRepository extends JpaRepository<Slot, Integer> {
}
