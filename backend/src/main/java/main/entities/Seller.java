package main.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "seller")
    private  List<Sale> sales = new ArrayList<>();

    public Seller() {

    }

    public List<Sale> getSales() {
        return sales;
    }


    public Seller(Long id, String name, List<Sale> sales) {
        super();
        this.id = id;
        this.name = name;
        this.sales = sales;
    }

    public Seller(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}