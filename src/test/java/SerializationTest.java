import com.fasterxml.jackson.databind.ObjectMapper;
import com.vish.spring.dto.CarDTO;
import com.vish.spring.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class SerializationTest {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        UserDTO user = new UserDTO();
        user.setName("Alice");
        user.setEmail("alice@example.com");

        CarDTO car = new CarDTO();
        car.setId("1");
        car.setModel("SUV");
        car.setName("Car A");
        car.setColor("Blue");
        car.setUserName("Alice");

        List<CarDTO> carList = new ArrayList<>();
        carList.add(car);

        user.setCarDTOList(carList);

        List<UserDTO> users = new ArrayList<>();
        users.add(user);

        String json = objectMapper.writeValueAsString(users);
        System.out.println(json);
    }
}
