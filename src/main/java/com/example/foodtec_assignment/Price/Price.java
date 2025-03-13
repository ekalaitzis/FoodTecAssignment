package com.example.foodtec_assignment.Price;

import com.example.foodtec_assignment.Item.Item;
import com.example.foodtec_assignment.Size.Size;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Entity
@EqualsAndHashCode
@Table(name = "price")
@ToString
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Positive
    @Column(name= "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "size_id", foreignKey = @ForeignKey(name = "fk_price"))
    private Size size;

    @ManyToOne
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "fk_price"))
    private Item item;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
