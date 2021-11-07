package main.services;

import main.dtos.SellerDTO;
import main.entities.Seller;
import main.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {
    @Autowired
    private SellerRepository repository;

    public List<SellerDTO> findAll() {
        List<Seller> list = repository.findAll();
        return list.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
    }

}
