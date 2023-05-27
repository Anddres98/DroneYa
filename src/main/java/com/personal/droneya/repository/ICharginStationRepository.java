package com.personal.droneya.repository;

import com.personal.droneya.model.entity.ChargingStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
El repositorio se extiende a JpaRepository para hacer consultas genericas, y se deben pasar 2 parametros el objeto
 que va guardar y el id de este objeto 'tipo de dato integer'*/


@Repository
public interface ICharginStationRepository extends JpaRepository<ChargingStation, Integer> {
}
