package tdtu.edu.midterm.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String usename;
    @Column
    private Date date;
    @Column
    private String status;



}
