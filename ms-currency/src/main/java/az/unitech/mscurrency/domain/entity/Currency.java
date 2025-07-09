package az.unitech.mscurrency.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    @Id
    private String code;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false,precision = 10,scale = 4)
    private BigDecimal rate;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
