package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents the contact details of a person.
 */

public class Contact {

    public final String value;
    private boolean isPrivate;

    public Contact(String address, boolean isPrivate, String validation, String constraints) throws IllegalValueException {
        this.value = address;
        this.isPrivate = isPrivate;
        if (!isValid(value.trim(), validation)) {
            throw new IllegalValueException(constraints);
        }
    }

    private boolean isValid(String value, String validation){
        if (value.matches(validation)){
            return true;
        }
        return false;

    }

    public boolean isPrivate() {
        return isPrivate;
    }


    public String toString() {
        return value;
    }

    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    public int hashCode() {
        return value.hashCode();
    }

}
