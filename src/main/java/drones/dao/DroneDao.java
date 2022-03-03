package drones.dao;

import drones.beans.Drones;

import java.util.Set;

public interface DroneDao {
    // CRUD
    boolean createDrone(Drones drone);
    boolean updateDrone(Drones drone);

    void deleteDrone(int id);


    void droneReady(int id);


    Set<Drones> getAllDrones();


}
