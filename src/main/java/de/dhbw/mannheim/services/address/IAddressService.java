package de.dhbw.mannheim.services.address;

import de.dhbw.mannheim.database.entities.Address;

public interface IAddressService {

    Address getAddress(Long id);
    Address insertAddress(Address address);
    Address updateAddress(Long id, Address address);
    Boolean deleteAddress(Long id);
}
