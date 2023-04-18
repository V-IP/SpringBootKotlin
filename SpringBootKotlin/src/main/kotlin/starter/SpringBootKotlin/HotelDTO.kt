package starter.SpringBootKotlin

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class HotelDTO(val id: Long, val name: String, val classification: Int, val noRooms: Int, val noFreeRooms: Int) {}