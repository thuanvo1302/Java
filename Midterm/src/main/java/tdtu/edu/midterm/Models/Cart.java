package tdtu.edu.midterm.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "cart")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String username;

    @Column
    private int product_id;

    @Column
    private String product_name;

    @Column
    private double product_price;

    @Column
    private int quantity;
    @Column
    private String product_image;
}
