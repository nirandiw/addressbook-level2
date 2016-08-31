package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.StringJoiner;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    private final String valueEnteredByUser;
    private boolean isPrivate;

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.valueEnteredByUser = address;
        generateAddressComponents();
    }

    /**
     * Generates the Address components based on user input
     */

    private void generateAddressComponents() {
        int BLOCK_POSITION = 0;
        int STREET_POSITION = 1;
        int UNIT_POSITION = 2;
        int POSTAL_CODE_POSITION =3;
        String[] addressComponents = valueEnteredByUser.split(", ");
        int numberOfaddressComponents = addressComponents.length;
        block = (numberOfaddressComponents>=1)? new Block(addressComponents[BLOCK_POSITION]): new Block("");
        street = (numberOfaddressComponents>=2)? new Street(addressComponents[STREET_POSITION]): new Street("");
        unit = (numberOfaddressComponents>=3)? new Unit(addressComponents[UNIT_POSITION]): new Unit("");
        postalCode = (numberOfaddressComponents==4)? new PostalCode(addressComponents[POSTAL_CODE_POSITION]): new PostalCode("");

    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner= new StringJoiner(", ");
        if (!block.getBlock().equals("")){
            stringJoiner.add(block.getBlock());
        }
        if (!street.getStreet().equals("")){
            stringJoiner.add(street.getStreet());
        }
        if (!street.getStreet().equals("")) {
            stringJoiner.add(unit.getUnit());
        }

        if (!postalCode.getPostalcode().equals("")){
            stringJoiner.add(postalCode.getPostalcode());
        }

        return stringJoiner.toString().replaceAll(", $","");
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.valueEnteredByUser.equals(((Address) other).valueEnteredByUser)); // state check
    }

    @Override
    public int hashCode() {
        return valueEnteredByUser.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * Contains the block of th
     */

    class Block{
        private String block;

        public Block(String block){
            this.block = block;
        }

        public String getBlock() {
            return block;
        }

    }

    /**
     * Contains the street of the address and related functions
     */

    class Street{
        private String street;

        public Street(String street){
            this.street= street;
        }


        public String getStreet() {
            return street;
        }
    }

    /**
     * Contains the unit of the address and related functions.
     */
    class Unit{
        private String unit;

        public Unit(String unit){
            this.unit=unit;
        }

        public String getUnit() {
            return unit;
        }
    }

    class PostalCode{
        private String postalcode;

        public PostalCode(String postalcode){
            this.postalcode = postalcode;
        }

        public String getPostalcode() {
            return postalcode;
        }
    }


}