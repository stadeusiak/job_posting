package spring.sta.posting;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Posting {

    private Long id;

    @NotNull
    @Length(min =1, max = 2560)
    private String description;

    @NotNull
    @DecimalMin("1.00")
    private BigDecimal salary;

    @Future
    @NotNull
    private LocalDate expiresDates;

    @NotNull
    @Valid
    private Company company;
}
