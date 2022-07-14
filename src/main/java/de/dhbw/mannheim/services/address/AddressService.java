package de.dhbw.mannheim.services.address;

import de.dhbw.mannheim.database.entities.Address;
import de.dhbw.mannheim.database.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService implements IAddressService{

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address getAddress(Long id) {
        Optional<Address> authority = this.addressRepository.findById(id);
        if (authority.isEmpty())
            return null;
        else
            return authority.get();
    }

    @Override
    public Address insertAddress(Address address) {
        if(!address.getId().equals(0L))
            return null;
        return this.addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        if (this.addressRepository.existsById(id) && id.equals(address.getId()))
            return this.addressRepository.save(address);
        return null;
    }

    @Override
    public Boolean deleteAddress(Long id) {
        if (!this.addressRepository.existsById(id))
            return false;
        else {
            this.addressRepository.deleteById(id);
            return true;
        }
    }
}
