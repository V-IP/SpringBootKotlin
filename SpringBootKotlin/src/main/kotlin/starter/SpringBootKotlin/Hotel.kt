package starter.SpringBootKotlin

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Hotel(val name: String, val classification: Int, val noRooms: Int) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    private var noFreeRooms: Int = this.noRooms

    constructor(): this("",0,0)

    fun checkIn(noGuests: Int) {
        if (this.noFreeRooms >= noGuests)
            this.noFreeRooms -= noGuests
    }

    fun checkOut(noGuests: Int) {
        this.noFreeRooms += noGuests
    }

    fun getNoFreeRooms(): Int = this.noFreeRooms
}