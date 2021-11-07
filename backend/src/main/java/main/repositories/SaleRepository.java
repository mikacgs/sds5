package main.repositories;

import main.dtos.SaleSuccessDTO;
import main.dtos.SaleSumDTO;
import main.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("SELECT NEW main.dtos.SaleSumDTO(obj.seller, SUM(obj.amount) ) " +
            "FROM Sale as obj GROUP BY " +
            "obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT NEW main.dtos.SaleSuccessDTO(obj.seller, SUM(obj.visited),SUM(obj.deals) ) " +
            "FROM Sale as obj GROUP BY " +
            "obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}
