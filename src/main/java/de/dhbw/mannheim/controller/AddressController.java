package de.dhbw.mannheim.controller;

import de.dhbw.mannheim.database.entities.Address;
import de.dhbw.mannheim.services.address.IAddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("addresses")
@Tag(name = "Adressen")
public class AddressController {

    private final IAddressService addressService;

    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Address> get(@PathVariable Long id) {
        Address address = this.addressService.getAddress(id);
        if (address == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address address) {
        Address savedAddress = this.addressService.insertAddress(address);
        if (savedAddress == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, Address address) {
        Address savedAddress = this.addressService.updateAddress(id, address);
        if (savedAddress != null)
            return new ResponseEntity<>(savedAddress, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        if (this.addressService.deleteAddress(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
