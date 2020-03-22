package seedu.address.model.expenditure;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Expenditure in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Expenditure {

    // Identity fields
    private final Info info;
    private final Amount amount;

    // Data fields
    private final Date date;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */

    public Expenditure(Info info, Amount amount, Date date, Set<Tag> tags) {
        requireAllNonNull(info, amount, date, tags);
        this.info = info;
        this.amount = amount;
        this.date = date;
        this.tags.addAll(tags);
    }

    public Info getInfo() {
        return info;
    }

    public Amount getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both expenditure refers to the same expenditure object.
     */
    public boolean isSameExpenditure(Expenditure otherExpenditure) {
        if (otherExpenditure == this) {
            return true;
        }

        return false;
    }

    /**
     * Returns true if both expenditures have all same fields.
     * Can be used for testing.
     */
    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Expenditure)) { // short circuit if not same type
            return false;
        } else if (other == this) {
            return true;
        }

        Expenditure otherExpenditure = (Expenditure) other;
        boolean sameInfo = otherExpenditure.info.equals(this.info);
        boolean sameAmt = otherExpenditure.amount.equals(this.amount);
        boolean sameDate = otherExpenditure.date.equals(this.date);
        boolean sameTag = false;

        if (otherExpenditure.tags.size() == this.tags.size()) {
            if (otherExpenditure.tags.size() == 0) {
                sameTag = true;
            } else {

                Iterator itr = tags.iterator();
                Iterator itrOther = otherExpenditure.tags.iterator();

                while (itr.hasNext() && itrOther.hasNext()) {
                    sameTag = itr.next().equals(itrOther.next());
                }

            }
        }

        return sameAmt && sameDate && sameInfo && sameTag;
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(info, amount, date, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getInfo())
                .append(" Amount: ")
                .append(getAmount())
                .append(" Date: ")
                .append(getDate())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}