package com.example.cartservice.dto;


        import com.example.cartservice.Models.Product;
        import lombok.Getter;
        import lombok.Setter;

        import java.util.Date;

@Getter
@Setter
public class cartdto {
    private Long id;
    private Long userId;
    private Date date;
    private Product[] products;

}