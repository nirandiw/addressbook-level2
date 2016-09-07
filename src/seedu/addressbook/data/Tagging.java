package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

/**
 * Represents the Tagging associtated with Person and the Tag
 */
public class Tagging {

    public enum TagOperation{
        ADD, REMOVE
    };

    private Person person_;
    private Tag tag_;
    private TagOperation tagOperation_;


    public Tagging(TagOperation tagOperation, Person person, Tag tag){
        person_= person;
        tag_= tag;
        tagOperation_ = tagOperation;

    }

    public Person getPerson_() {
        return person_;
    }

    public Tag getTag_() {
        return tag_;
    }

    public TagOperation getTagOperation_() {
        return tagOperation_;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(person_ + " [" + tag_ + "]");
        switch (tagOperation_){
            case ADD:
                sb.insert(0, "+");
                break;
            case REMOVE:
                sb.insert(0,"-");

        }
        return sb.toString();
    }

}
