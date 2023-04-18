package starter.SpringBootKotlin

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DbSeeder(val hotelRepository: HotelRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        this.hotelRepository.deleteAll()

        val continental = Hotel("Continental", 3, 30)
        val plaza = Hotel("Plaza",5,90)
        val hilton = Hotel("Hilton",4,40)

        val hotels = mutableListOf<Hotel>()
        hotels.add(continental)
        hotels.add(plaza)
        hotels.add(hilton)

        this.hotelRepository.saveAll(hotels)
        println(" -- Database has been initialized")
    }
}