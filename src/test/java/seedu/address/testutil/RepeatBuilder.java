package seedu.address.testutil;


import seedu.address.model.expenditure.Amount;
import seedu.address.model.expenditure.Date;
import seedu.address.model.expenditure.Info;
import seedu.address.model.expenditure.Repeat;
import seedu.address.model.expenditure.Repeat.Period;
import seedu.address.model.tag.Tag;

import static seedu.address.logic.commands.CommandTestUtil.VALID_AMOUNT_MRT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_END_DATE_MRT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INFO_MRT;
import static seedu.address.logic.commands.CommandTestUtil.VALID_START_DATE_MRT;


/**
 * A utility class to help with building Repeat objects.
 * Example usage: <br>
 *     {@code Repeat ab = new RepeatBuilder();}
 */
public class RepeatBuilder {

    public static final String DEFAULT_INFO = VALID_INFO_MRT;
    public static final double DEFAULT_AMOUNT = VALID_AMOUNT_MRT;
    public static final String DEFAULT_START_DATE = VALID_START_DATE_MRT;
    public static final String DEFAULT_END_DATE = VALID_END_DATE_MRT;
    public static final String DEFAULT_TAG = "Others";
    public static final String DEFAULT_PERIOD = Period.DAILY.toString();

    private Info info;
    private Amount amount;
    private Date startDate;
    private Date endDate;
    private Tag tag;
    private Period period;

    public RepeatBuilder() {
        info = new Info(DEFAULT_INFO);
        amount = new Amount(DEFAULT_AMOUNT);
        startDate = new Date(DEFAULT_START_DATE);
        endDate = new Date(DEFAULT_END_DATE);
        tag = new Tag(DEFAULT_TAG);
        period = Period.DAILY;
    }

    /**
     * Sets the {@code Info} of the {@code Repeat} that we are building.
     */
    public RepeatBuilder withInfo(String info) {
        this.info = new Info(info);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Repeat} that we are building.
     */
    public RepeatBuilder withTag(String tag) {
        this.tag = new Tag(tag);
        return this;
    }

    /**
     * Sets the {@code startDate} of the {@code Repeat} that we are building.
     */
    public RepeatBuilder withStartDate(String date) {
        this.startDate = new Date(date);
        return this;
    }

    /**
     * Sets the {@code endDate} of the {@code Repeat} that we are building.
     */
    public RepeatBuilder withEndDate(String date) {
        this.endDate = new Date(date);
        return this;
    }

    /**
     * Sets the {@code Amount} of the {@code Repeat} that we are building.
     */
    public RepeatBuilder withAmount(double amount) {
        this.amount = new Amount(amount);
        return this;
    }

    /**
     * Sets the {@code Repeat} of the {@code Repeat} that we are building.
     */
    public RepeatBuilder withPeriod(String period) {
        this.period = Period.valueOf(period);
        return this;
    }

    public Repeat build() {
        return new Repeat(info, amount, startDate, endDate, tag, period.toString());
    }

}
