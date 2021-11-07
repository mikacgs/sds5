package main.services;

import main.dtos.SaleDTO;
import main.entities.Sale;
import main.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;

    public Page<SaleDTO> findAll(Pageable pageable) {
        Page<Sale> list = repository.findAll(pageable);
        return list.map(x -> new SaleDTO(x));
    }

}
