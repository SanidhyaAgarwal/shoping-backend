package utils;

import com.springcore.model.Address;

import com.springcore.model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderBody {

    private Integer userId;
    private List<Integer> cartId=new ArrayList<>();
    private Integer addressId;


}
