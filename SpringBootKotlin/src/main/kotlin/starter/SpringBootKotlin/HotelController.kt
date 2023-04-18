package starter.SpringBootKotlin

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hotels")
class HotelController(val hotelRepository: HotelRepository) {

    @GetMapping("/all")
    //fun findAll(): MutableIterable<Hotel> = this.hotelRepository.findAll()
    fun findAll(): List<HotelDTO> {
        val hotels: MutableIterable<Hotel> = hotelRepository.findAll()
        return hotels.map { hotel ->
            HotelDTO(
                id = hotel.id,
                name = hotel.name,
                classification = hotel.classification,
                noRooms = hotel.noRooms,
                noFreeRooms = hotel.getNoFreeRooms()
            )
        }
    }

    @GetMapping("/{name}")
    fun findByName(@PathVariable(value = "name") name: String): List<Hotel> {
        return hotelRepository.findByName(name)
    }

    @PostMapping("/checking")
    fun checkIn(@RequestBody checkInRequest: CheckInRequest) {
        val hotel = this.hotelRepository.findByName(checkInRequest.hotelName)[0]
        hotel.checkIn(checkInRequest.noGuests)
        this.hotelRepository.save(hotel)
    }
}