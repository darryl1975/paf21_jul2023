package sg.edu.nus.iss.paf21_jul2023.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf21_jul2023.model.Room;
import sg.edu.nus.iss.paf21_jul2023.repo.RoomRepository;

@Service
public class RoomService {
    
    @Autowired
    RoomRepository rmRepo;

    public int count() {
        return rmRepo.count();
    }

    public Boolean save(Room room) {
        return rmRepo.save(room);
    }

    public List<Room> findAll() {
        return rmRepo.getAllRooms();
    }

    public Room findById(int id) {
        return rmRepo.getRoomById(id);
    }

    public int update(Room room) {
        return rmRepo.update(room);
    }

    public int deleteById(int id) {
        return rmRepo.deleteById(id);
    }
}
