package com.example.mountainsheltercms.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/offer")
class OfferController {


    @Autowired
    OfferRepository offerRepository;

    @PutMapping()
    @Transactional
    public Offer editOffer(@PathVariable Long id, @RequestBody Offer offer) {
        final var offerDB = offerRepository.getById(id);

        offerDB.setText(offer.getText());
        offerDB.setType(offer.getType());

        return offerDB;
    }

   @GetMapping()
    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

}
